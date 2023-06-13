package cn.itcast.wanxinp2p.consumer.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.itcast.wanxinp2p.api.consumer.model.ConsumerRegisterDTO;
import cn.itcast.wanxinp2p.consumer.entity.Consumer;
@Mapper
public interface ConsumerMapper extends BaseMapper<Consumer>{

	Integer register(ConsumerRegisterDTO consumerRegisterDTO);

}
