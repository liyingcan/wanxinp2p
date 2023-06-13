package cn.itcast.wanxinp2p.api.account.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 封装账户登录信息
 * </p>
 */
//@Data
@ApiModel(value = "AccountLoginDTO", description = "账户登录信息")
public class AccountLoginDTO {

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("域(c：c端用户；b：b端用户)")
	private String domain;

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	

}
