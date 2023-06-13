package cn.itcast.wanxinp2p.api.account.model;

import lombok.Data;

/**
 * 当前登录用户
 */
//@Data
public class LoginUser {
	/**
	 * tenantId : 1
	 * departmentId : 1
	 * payload : {"res":"res1111111"}
	 * username : admin
	 * mobile : 18611106983
	 * userAuthorities : {"ROLE1":["p1","p2"]}
	 * clientId : wanxin-p2p-web-admin
	 */

	private String tenantId;
	private String departmentId;
	private String payload;
	private String username;
	private String mobile;
	private String userAuthorities;
	private String clientId;
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
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
	public String getUserAuthorities() {
		return userAuthorities;
	}
	public void setUserAuthorities(String userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
