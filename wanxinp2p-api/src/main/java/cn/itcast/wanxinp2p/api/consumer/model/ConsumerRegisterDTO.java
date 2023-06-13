package cn.itcast.wanxinp2p.api.consumer.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


//@Data
@ApiModel(value = "ConsumerRegisterDTO", description = "用户注册信息")
public class ConsumerRegisterDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("用户角色.B借款人or I投资人")
	private String role;

	@ApiModelProperty("验证码key")
	private String key;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	

}
