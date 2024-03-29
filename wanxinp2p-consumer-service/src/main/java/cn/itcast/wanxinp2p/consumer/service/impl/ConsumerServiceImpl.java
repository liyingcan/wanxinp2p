package cn.itcast.wanxinp2p.consumer.service.impl;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.itcast.wanxinp2p.api.account.model.AccountDTO;
import cn.itcast.wanxinp2p.api.account.model.AccountRegisterDTO;
import cn.itcast.wanxinp2p.api.consumer.model.BankCardDTO;
import cn.itcast.wanxinp2p.api.consumer.model.ConsumerDTO;
import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRegisterDTO;
import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRequest;
import cn.itcast.wanxinp2p.api.depository.GatewayRequest;
import cn.itcast.wanxinp2p.api.depository.model.DepositoryConsumerResponse;
import cn.itcast.wanxinp2p.common.domain.BusinessException;
import cn.itcast.wanxinp2p.common.domain.CodePrefixCode;
import cn.itcast.wanxinp2p.common.domain.CommonErrorCode;
import cn.itcast.wanxinp2p.common.domain.DepositoryReturnCode;
import cn.itcast.wanxinp2p.common.domain.RestResponse;
import cn.itcast.wanxinp2p.common.domain.SexEnum;
import cn.itcast.wanxinp2p.common.domain.StatusCode;
import cn.itcast.wanxinp2p.common.util.BeanCopyUtil;
import cn.itcast.wanxinp2p.common.util.CodeNoUtil;
import cn.itcast.wanxinp2p.consumer.agent.AccountApiAgent;
import cn.itcast.wanxinp2p.consumer.agent.DepositoryAgentApiAgent;
import cn.itcast.wanxinp2p.consumer.common.ConsumerErrorCode;
import cn.itcast.wanxinp2p.consumer.entity.BankCard;
import cn.itcast.wanxinp2p.consumer.entity.Consumer;
import cn.itcast.wanxinp2p.consumer.mapper.ConsumerMapper;
import cn.itcast.wanxinp2p.consumer.service.BankCardService;
import cn.itcast.wanxinp2p.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper,Consumer> implements ConsumerService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServiceImpl.class);
	@Autowired
	private ConsumerMapper consumerMapper;
	@Autowired
	private AccountApiAgent accountApiAgent;
    @Autowired
    private BankCardService bankCardService;
    @Autowired
    private DepositoryAgentApiAgent depositoryAgentApiAgent;
	/**
	 * 用户注册
	 */
	@Override
	public void register(ConsumerRegisterDTO consumerRegisterDTO) {
		//检验是否已注册
		if(checkMobile(consumerRegisterDTO.getMobile())==1) {
			throw new BusinessException(ConsumerErrorCode.E_140107);
		}
		Consumer consumer=new Consumer();
		BeanUtils.copyProperties(consumerRegisterDTO, consumer);
		consumer.setUsername(CodeNoUtil.getNo(CodePrefixCode.CODE_NO_PREFIX));
		consumer.setUserNo(CodeNoUtil.getNo(CodePrefixCode.CODE_REQUEST_PREFIX));
		consumer.setIsBindCard(0);
		//保存用户信息
		save(consumer);
		 //远程调用account
        AccountRegisterDTO accountRegisterDTO=new AccountRegisterDTO();
        BeanUtils.copyProperties(consumerRegisterDTO, accountRegisterDTO);
        RestResponse<AccountDTO> restResponse=accountApiAgent.register(accountRegisterDTO);
        if(restResponse.getCode()!= CommonErrorCode.SUCCESS.getCode()){
            throw new BusinessException(ConsumerErrorCode.E_140106);
        }
//		Integer i=consumerMapper.register(consumerRegisterDTO);
	}
	@Override
	public Integer checkMobile(String mobile) {
		return getByMobile(mobile,false)!=null?1:0;
	}
    private ConsumerDTO getByMobile(String mobile){
        Consumer consumer=getOne(new QueryWrapper<Consumer>().lambda().eq(Consumer::getMobile,mobile));
        return convertConsumerEntityToDTO(consumer);
    }

	/**
	 * 根据手机号获取用户信息
	 * @param mobile 手机号
	 * @param throwEx 不存在是否抛出异常
	 * @return
	 */
	private ConsumerDTO getByMobile(String mobile,Boolean throwEx) {
		Consumer entity=getOne(new QueryWrapper<Consumer>().lambda().eq(Consumer::getMobile,mobile));
		return convertConsumerEntityToDTO(entity);
	}
	@Override
    @Transactional
    public RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest) {
        //1.判断当前用户是否已经开户
        ConsumerDTO consumerDTO=getByMobile(consumerRequest.getMobile());
        if(consumerDTO.getIsBindCard()==1){
            throw new BusinessException(ConsumerErrorCode.E_140105);
        }

        //2.判断提交过来的银行卡是否已被绑定
       BankCardDTO bankCardDTO = bankCardService.getByCardNumber(consumerRequest.getCardNumber());
        if(bankCardDTO!=null && bankCardDTO.getStatus()== StatusCode.STATUS_IN.getCode()){
            throw  new BusinessException(ConsumerErrorCode.E_140151);
        }

        //3.更新用户的信息
        consumerRequest.setId(consumerDTO.getId());
        //产生请求流水号和用户编号
        consumerRequest.setUserNo(CodeNoUtil.getNo(CodePrefixCode.CODE_CONSUMER_PREFIX));
        consumerRequest.setRequestNo(CodeNoUtil.getNo(CodePrefixCode.CODE_REQUEST_PREFIX));
        //设置查询条件和需要更新的数据
        UpdateWrapper<Consumer> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Consumer::getMobile,consumerDTO.getMobile());
        updateWrapper.lambda().set(Consumer::getUserNo, consumerRequest.getUserNo());
        updateWrapper.lambda().set(Consumer::getRequestNo, consumerRequest.getRequestNo());
        updateWrapper.lambda().set(Consumer::getFullname, consumerRequest.getFullname());
        updateWrapper.lambda().set(Consumer::getIdNumber, consumerRequest.getIdNumber());
        updateWrapper.lambda().set(Consumer::getAuthList, "ALL");
        update(updateWrapper);

        //4.保存银行卡信息
        BankCard bankCard=new BankCard();
        bankCard.setConsumerId(consumerDTO.getId());
        bankCard.setBankCode(consumerRequest.getBankCode());
        bankCard.setCardNumber(consumerRequest.getCardNumber());
        bankCard.setMobile(consumerRequest.getMobile());
        bankCard.setStatus(StatusCode.STATUS_OUT.getCode());
        BankCardDTO existBankCard = bankCardService.getByConsumerId(bankCard.getConsumerId());
        if (existBankCard != null) {
            bankCard.setId(existBankCard.getId());
        }
        bankCardService.saveOrUpdate(bankCard);

        //5.准备数据，发起远程调用，把数据发到存管代理服务
        return depositoryAgentApiAgent.createConsumer(consumerRequest);
    }
	//勿删
		@Override
		public RestResponse listInsert(List<ConsumerRegisterDTO> listConsumerRegisterDTO) {
//			List<Consumer> consumerList = BeanCopyUtil.copyListProperties(listConsumerRegisterDTO, Consumer::new, (consumerRegisterDTO, consumer) ->{
//		        // 这里可以定义特定的转换规则int->String。属性类型不一致时设置类型转换
//				consumer.setMobile(SexEnum.getDescByCode(consumerRegisterDTO.getMobile()).getDesc());});
//			saveBatch(consumerList,0);
//			return RestResponse.success(consumerList);
			return null;
		}
	    @Override
	    @Transactional
	    public Boolean modifyResult(DepositoryConsumerResponse response) {
	        //1.获取数据(状态)
	       int status = response.getRespCode().equals(DepositoryReturnCode.RETURN_CODE_00000.getCode())?StatusCode.STATUS_IN.getCode():StatusCode.STATUS_FAIL.getCode();

	        //2.更新用户信息
	        Consumer consumer=getByRequestNo(response.getRequestNo());
	        update(Wrappers.<Consumer>lambdaUpdate().eq(Consumer::getId,consumer.getId()).set(Consumer::getIsBindCard,status).set(Consumer::getStatus,status));

	        //3.更新银行卡信息
	        return bankCardService.update(Wrappers.<BankCard>lambdaUpdate()
	                .eq(BankCard::getConsumerId, consumer.getId())
	                .set(BankCard::getStatus, status).set(BankCard::getBankCode,
	                        response.getBankCode())
	                .set(BankCard::getBankName, response.getBankName()));
	    }

	    private Consumer getByRequestNo(String requestNo){
	        return getOne(Wrappers.
	                <Consumer>lambdaQuery().eq(Consumer::getRequestNo,requestNo));
	    }

	    public void confirmRegister(ConsumerRegisterDTO consumerRegisterDTO) {
	    	LOGGER.info("execute confirmRegister");
	    }
	    public void cancelRegister(ConsumerRegisterDTO consumerRegisterDTO) {
	    	LOGGER.info("execute cancelRegister");
	        remove(Wrappers.<Consumer>lambdaQuery().eq(Consumer::getMobile,
	                consumerRegisterDTO.getMobile()));
	    }

	/**
	 * entity转为dto
	 * @param entity
	 * @return
	 */
	private ConsumerDTO convertConsumerEntityToDTO(Consumer entity) {
        if (entity == null) {
            return null;
        }
        ConsumerDTO dto = new ConsumerDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
	}
	

}
