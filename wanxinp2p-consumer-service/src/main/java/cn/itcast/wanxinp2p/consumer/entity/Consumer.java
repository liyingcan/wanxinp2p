package cn.itcast.wanxinp2p.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("consumer")
//@Data
//和数据库表中13列对应
public class Consumer {
	/**
	 * 主键
	 */
	@TableId(value="id",type=IdType.AUTO)
	private Long id;
	/**
	 * 用户名
	 */
	@TableField("username")
	private String username;
	/**
	 * 真实姓名
	 */
	@TableField("fullname")
	private String fullname;
	/**
	 * 身份证号
	 */
	@TableField("id_number")
	private String idNumber;
	/**
	 * 用户编码,生成唯一,用户在存管系统标识
	 */
	@TableField("user_no")
	private String userNo;
	/**
	 * 平台预留手机号
	 */
	@TableField("mobile")
	private String mobile;
	/**
	 * 用户类型,个人or企业，预留
	 */
	@TableField("user_type")
	private String userType;
	/**
	 * 用户角色.B借款人or I投资人
	 */
	@TableField("role")
	private String role;
	/**
	 * 存管授权列表
	 */
	@TableField("auth_list")
	private String authList;
	/**
	 * 是否已绑定银行卡
	 */
	@TableField("is_bind_card")
	private Integer isBindCard;
	/**
	 * 可贷额度
	 */
	@TableField("loan_amount")
	private Integer loanAmount;
	/**
	 * 可用状态
	 */
	@TableField("status")
	private Integer status;
	/**
	 * 请求流水号
	 */
	@TableField("request_no")
	private Integer requestNo;
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
	public Integer getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(Integer requestNo) {
		this.requestNo = requestNo;
	}
	
	

}
