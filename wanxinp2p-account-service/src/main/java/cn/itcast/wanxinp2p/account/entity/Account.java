package cn.itcast.wanxinp2p.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.baomidou.mybatisplus.annotation.TableName;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	public Account() {
		
	}
	public Account(Long id, String username, String mobile, String password, String salt, String status,
			String domain) {
		this.id = id;
		this.username = username;
		this.mobile = mobile;
		this.password = password;
		this.salt = salt;
		this.domain = domain;
	}

	/**
	 * 主键
	 */
	@TableId("ID")
	private Long id;

	/**
	 * 用户名
	 */
	@TableField("USERNAME")
	private String username;


	/**
	 * 手机号
	 */
	@TableField("MOBILE")
	private String mobile;

	/**
	 * 密码
	 */
	@TableField("PASSWORD")
	private String password;

	/**
	 * 加密盐
	 */
	@TableField("SALT")
	private String salt;

	/**
	 * 账号状态
	 */
	@TableField("STATUS")
	private Integer status;

	/**
	 * 域(c：c端用户；b：b端用户)
	 */
	@TableField("DOMAIN")
	private String domain;

}
