package cn.itcast.wanxinp2p.account.service;


import cn.itcast.wanxinp2p.account.common.AccountErrorCode;
//import cn.itcast.wanxinp2p.account.FeignSpi.FeignClientSpi;
//import cn.itcast.wanxinp2p.account.common.AccountErrorCode;
import cn.itcast.wanxinp2p.common.domain.BusinessException;
import cn.itcast.wanxinp2p.common.domain.CommonErrorCode;
import cn.itcast.wanxinp2p.common.domain.RestResponse;
//import cn.itcast.wanxinp2p.common.dto.VerificationInfo;
import cn.itcast.wanxinp2p.common.util.OkHttpUtil;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SmsService {

    @Value("${sms.url}")
    private String smsURL;

    @Value("${sms.enable}")
    private Boolean smsEnable;
    //okhttp3
    public RestResponse getSMSCode(String mobile) {
        if (smsEnable) {
            return OkHttpUtil.post(smsURL + "/generate?effectiveTime=300&name=sms", "{\"mobile\":" + mobile + "}");

        }
        return RestResponse.success();
    }

    /**
     * 校验验证码
     * @param key 校验标识  redis中的键
     * @param code 短信验证码
     */
    public void verifySmsCode(String key,String code){
        if (smsEnable) {
            StringBuilder params = new StringBuilder("/verify?name=sms");
            params.append("&verificationKey=").append(key).append("&verificationCode=").append(code);
            RestResponse smsResponse = OkHttpUtil.post(smsURL + params, "");
            if (smsResponse.getCode() != CommonErrorCode.SUCCESS.getCode() || smsResponse.getResult().toString().equalsIgnoreCase("false")) {
                throw new BusinessException(AccountErrorCode.E_140152);
            }
        }
    }
}
