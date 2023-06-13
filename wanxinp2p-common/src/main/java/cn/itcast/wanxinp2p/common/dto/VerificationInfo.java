package cn.itcast.wanxinp2p.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 验证信息，客户端保存key，展示content
 */
@Data
//@AllArgsConstructor
public class VerificationInfo {

    public VerificationInfo(String key2, String content2) {
		// TODO Auto-generated constructor stub
    	this.key=key2;
    	this.content=content2;
	}

	/**
     *
     */
    private String key;

    /**
     * 混淆后的内容
     * 举例：
     * 1.图片验证码为:图片base64编码
     * 2.短信验证码为:null
     * 3.邮件验证码为: null
     * 4.邮件链接点击验证为：null
     * ...
     */
    private String content;

}
