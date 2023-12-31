package cn.itcast.wanxinp2p.api.consumer;



import java.util.List;

import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRegisterDTO;
import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRequest;
import cn.itcast.wanxinp2p.api.depository.GatewayRequest;
import cn.itcast.wanxinp2p.common.domain.RestResponse;

/**
 * 用户中心接口API
 */
public interface ConsumerAPI {

    /**
     * 用户注册  保存用户信息
     * @param consumerRegisterDTO
     * @return
     */
   RestResponse register(ConsumerRegisterDTO consumerRegisterDTO);
	/**
	 * 测试
	 * 使用BeanUtils进行DO、Model、VO层数据间转换数据
	 * 批量插入
	 * @param listConsumerRegisterDTO
	 * @return
	 */
	public RestResponse listInsert( List<ConsumerRegisterDTO> listConsumerRegisterDTO);
    /**
     * 生成开户请求数据
     * @param consumerRequest 开户信息
     * @return
     */
    RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest);

}
