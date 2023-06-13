package cn.itcast.wanxinp2p.depository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 存管交易记录表
 * </p>
 *
 * @author wuzhao@itcast.cn
 * @since 2019-05-17
 */
//@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DepositoryRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private Long id;

    /**
     * 请求流水号
     */
    @TableField("REQUEST_NO")
    private String requestNo;

    /**
     * 请求类型:1.用户信息(新增、编辑)、2.绑卡信息
     */
    @TableField("REQUEST_TYPE")
    private String requestType;

    /**
     * 业务实体类型
     */
    @TableField("OBJECT_TYPE")
    private String objectType;

    /**
     * 关联业务实体标识
     */
    @TableField("OBJECT_ID")
    private Long objectId;

    /**
     * 请求时间
     */
    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    /**
     * 是否是同步调用
     */
    @TableField("IS_SYN")
    private Integer isSyn;

    /**
     * 数据同步状态
     */
    @TableField("REQUEST_STATUS")
    private Integer requestStatus;

    /**
     * 消息确认时间
     */
    @TableField("CONFIRM_DATE")
    private LocalDateTime confirmDate;

	/**
	 * 返回数据
	 */
	@TableField("RESPONSE_DATA")
	private String responseData;

	public DepositoryRecord() {
	}

	public DepositoryRecord(String requestNo, String requestType, String objectType, Long objectId) {
		this.requestNo = requestNo;
		this.requestType = requestType;
		this.objectType = objectType;
		this.objectId = objectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getIsSyn() {
		return isSyn;
	}

	public void setIsSyn(Integer isSyn) {
		this.isSyn = isSyn;
	}

	public Integer getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}

	public LocalDateTime getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(LocalDateTime confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
