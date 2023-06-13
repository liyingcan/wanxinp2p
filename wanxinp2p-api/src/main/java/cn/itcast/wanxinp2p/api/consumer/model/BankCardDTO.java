package cn.itcast.wanxinp2p.api.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@Data
@ApiModel(value = "BankCardDTO", description = "银行卡信息")
public class BankCardDTO {

	@ApiModelProperty("标识")
	private Long id;

	@ApiModelProperty("用户标识")
	private Long consumerId;

	@ApiModelProperty("用户实名")
	private String fullName;

	@ApiModelProperty("银行编码")
	private String bankCode;

	@ApiModelProperty("银行名称")
	private String bankName;

	@ApiModelProperty("银行卡号")
	private String cardNumber;

	@ApiModelProperty("银行预留手机号")
	private String mobile;

	@ApiModelProperty("可用状态")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
