package cn.itcast.wanxinp2p.api.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


//@Data
@ApiModel(value = "ConsumerDTO", description = "平台c端用户信息")
public class ConsumerDTO {

	@ApiModelProperty("用户id")
	private Long id;

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("真实姓名")
	private String fullname;

	@ApiModelProperty("身份证号")
	private String idNumber;

	@ApiModelProperty("用户编码，用户在存管系统标识，不允许重复")
	private String userNo;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("用户类型,个人or企业，预留")
	private String userType;

	@ApiModelProperty("角色")
	private String role;

	@ApiModelProperty("存管授权列表")
	private String authList;

	@ApiModelProperty("是否已绑定银行卡")
	private Integer isBindCard;

	@ApiModelProperty("启用状态")
	private Integer status;

	@ApiModelProperty("可贷额度")
	private BigDecimal loanAmount;

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

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAuthList() {
		return authList;
	}

	public void setAuthList(String authList) {
		this.authList = authList;
	}

	public Integer getIsBindCard() {
		return isBindCard;
	}

	public void setIsBindCard(Integer isBindCard) {
		this.isBindCard = isBindCard;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

}