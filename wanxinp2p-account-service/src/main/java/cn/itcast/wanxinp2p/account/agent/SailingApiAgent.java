package cn.itcast.wanxinp2p.account.agent;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value="sailing")
public interface SailingApiAgent {
	 @PostMapping(value="/sailing/testpost")
	    public String testPost() ;
}
