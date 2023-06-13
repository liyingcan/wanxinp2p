package cn.itcast.wanxinp2p.api.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

//@Data
@ApiModel(value = "ConsumerRequest", description = "平台c端用户开户信息")
public class ConsumerRequest {

	@ApiModelProperty("id")
	private Long id;

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("真实姓名")
	private String fullname;

	@ApiModelProperty("身份证号")
	private String idNumber;

	@ApiModelProperty("银行编码")
	private String bankCode;

	@ApiModelProperty("银行卡号")
	private String cardNumber;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("角色")
	private String role;

	@ApiModelProperty("请求流水号")
	private String requestNo;

	@ApiModelProperty("用户编号")
	private String userNo;

	@ApiModelProperty("页面回跳 URL")
	private String callbackUrl;

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

}
