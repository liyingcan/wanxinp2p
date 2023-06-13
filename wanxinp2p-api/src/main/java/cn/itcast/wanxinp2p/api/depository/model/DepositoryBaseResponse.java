package cn.itcast.wanxinp2p.api.depository.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <P>
 * 返回参数信息基类
 * </p>
 */
//@Data
@Accessors(chain = true)
public class DepositoryBaseResponse implements Serializable {

    @ApiModelProperty("返回码")
    private String respCode;

    @ApiModelProperty("描述信息")
    private String respMsg;

    @ApiModelProperty("交易状态")
    private Integer status;

    @ApiModelProperty("请求流水号")
    private String requestNo;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

}
