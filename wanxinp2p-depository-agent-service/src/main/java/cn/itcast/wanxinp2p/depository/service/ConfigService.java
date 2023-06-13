package cn.itcast.wanxinp2p.depository.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 本类用于获取配置文件中的配置, 封装成service方便调用
 */
@Service
public class ConfigService {
	@Value("${depository.url}")
	private String depositoryUrl;
	@Value("${depository.publicKey}")
	private String depositoryPublicKey;
	@Value("${p2p.publicKey}")
	private String p2pPublicKey;
	@Value("${p2p.privateKey}")
	private String p2pPrivateKey;
	@Value("${p2p.code}")
	private String p2pCode;
	/**
	 * 银行存管系统服务地址
	 * 
	 * @return
	 */
//    public String getDepositoryUrl() {
//        return config.getProperty("depository.url", null);
//    }
	public String getDepositoryUrl() {
		return depositoryUrl;
	}

	/**
	 * 银行存管系统公钥
	 * 
	 * @return
	 */
//    public String getDepositoryPublicKey() {
//        return config.getProperty("depository.publicKey", null);
//    }
	public String getDepositoryPublicKey() {
		return depositoryPublicKey;
	}

	/**
	 * 万信P2P系统公钥
	 * 
	 * @return
	 */
//    public String getP2pPublicKey() {
//        return config.getProperty("p2p.publicKey", null);
//    }
	public String getP2pPublicKey() {
		return p2pPublicKey;
	}
	/**
	 * 万信P2P系统 标识
	 * 
	 * @return
	 */
//    public String getP2pCode() {
//        return config.getProperty("p2p.code", null);
//    }
	public String getP2pCode() {
		return p2pCode;
	}

	/**
	 * 万信P2P系统私钥
	 * 
	 * @return
	 */
//    public String getP2pPrivateKey() {
//        return config.getProperty("p2p.privateKey", null);
//    }
	public String getP2pPrivateKey() {
		return p2pPrivateKey;
	}
}
