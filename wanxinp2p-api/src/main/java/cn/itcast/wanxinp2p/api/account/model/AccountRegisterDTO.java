package cn.itcast.wanxinp2p.api.account.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@Data
@ApiModel(value = "AccountRegisterDTO", description = "账户注册信息")
public class AccountRegisterDTO {

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("密码")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
