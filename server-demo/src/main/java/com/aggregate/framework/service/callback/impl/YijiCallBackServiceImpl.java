package com.aggregate.framework.service.callback.impl;


import com.aggregate.framework.config.AggregatePayConfig;
import com.aggregate.framework.enums.yiji.ResultCodeEnums;
import com.aggregate.framework.service.callback.YijiCallBackService;
import com.aggregate.framework.utils.NotifyUtils;
import com.yiji.openapi.tool.YijifuGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
@Slf4j
public class YijiCallBackServiceImpl implements YijiCallBackService {

    @Autowired
    private AggregatePayConfig.YijiPayConfig yijiPayConfig;

    @Override
    public Boolean verifyBankCardCallBack(HttpServletRequest request) {
        Map<String, String> notifyData = NotifyUtils.getNotifyParameters(request);
        boolean signResult = YijifuGateway.getOpenApiClientService().verificationSign(notifyData,yijiPayConfig.getPrivateKey());
        if (signResult) {
            // todo
            String errorCode = notifyData.get("errorCode");
            String serviceStatus = notifyData.get("notifyData");
            if(ResultCodeEnums.executeSuccess.equals(serviceStatus)){
                log.info("[YijiCallBackServiceImpl].[verifyBankCardCallBack] verifyBankCard success");
            }else{
                log.info("[YijiCallBackServiceImpl].[verifyBankCardCallBack] verifyBankCard fail");
            }
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean loanCallBack(HttpServletRequest request) {
        Map<String, String> notifyData = NotifyUtils.getNotifyParameters(request);
        boolean signResult = YijifuGateway.getOpenApiClientService().verificationSign(notifyData,yijiPayConfig.getPrivateKey());
        return null;
    }


}
