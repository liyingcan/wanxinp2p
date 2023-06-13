package cn.itcast.wanxinp2p.api.account.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


//@Data
@ApiModel(value = "AccountDTO", description = "账户信息")
public class AccountDTO {

	@ApiModelProperty("标识")
	private Long id;

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("账号状态")
	private Integer status;

	@ApiModelProperty(" 域(c：c端用户；b：b端用户)")
	private String domain;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
}
