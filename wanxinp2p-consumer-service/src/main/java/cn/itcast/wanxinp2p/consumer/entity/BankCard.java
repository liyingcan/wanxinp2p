package cn.itcast.wanxinp2p.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户绑定银行卡信息
 * </p>
 *
 * @author zhupeiyuan
 * @since 2019-05-07
 */
//@Data
@TableName("bank_card")
public class BankCard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 用户标识
     */
    @TableField("CONSUMER_ID")
    private Long consumerId;

    /**
     * 银行编码
     */
    @TableField("BANK_CODE")
    private String bankCode;

	/**
	 * 银行名称
	 */
	@TableField("BANK_NAME")
	private String bankName;

    /**
     * 银行卡号
     */
    @TableField("CARD_NUMBER")
    private String cardNumber;

    /**
     * 银行预留手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 可用状态
     */
    @TableField("STATUS")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
