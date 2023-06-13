package cn.itcast.wanxinp2p.consumer.service;

import java.util.List;



import com.baomidou.mybatisplus.extension.service.IService;


import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRegisterDTO;
import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRequest;
import cn.itcast.wanxinp2p.api.depository.GatewayRequest;
import cn.itcast.wanxinp2p.api.depository.model.DepositoryConsumerResponse;
import cn.itcast.wanxinp2p.common.domain.RestResponse;
import cn.itcast.wanxinp2p.consumer.entity.Consumer;

public interface ConsumerService extends IService<Consumer>{
	/**
	 * 检验用户是否存在
	 * @param mobile
	 * @return
	 */
	Integer checkMobile(String mobile);
	/**
	 * 用户注册
	 * @param consumerRegisterDTO
	 * @return
	 */
	void register(ConsumerRegisterDTO consumerRegisterDTO);
	public RestResponse listInsert( List<ConsumerRegisterDTO> listConsumerRegisterDTO);

    /**
    生成开户数据
    @param consumerRequest
    @return
    */
    RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest);
    /**
     * 更新开户结果
    * @param response
    * @return
    */
    Boolean modifyResult(DepositoryConsumerResponse response);

}
