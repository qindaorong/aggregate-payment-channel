package com.aggregate.framework.service.callback.impl;

import com.aggregate.framework.service.callback.EntrustPayCallBackService;
import com.yiji.openapi.message.common.deposit.DeductApplyNotify;
import com.yiji.openapi.sdk.common.message.ApiMessage;
import com.yiji.openapi.sdk.notify.NotifyHandler;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class EntrustPayCallBackServiceImpl extends NotifyHandler implements EntrustPayCallBackService {
    @Override
    public void handleNotify(ApiMessage apiMessage) {
        //获取异步响应实体
        DeductApplyNotify deductApplyNotify = (DeductApplyNotify)apiMessage;
        //异步通知业务处理
        if(StringUtils.equals("DEPOSIT_SUCCESS", deductApplyNotify.getResultCode())) {
            //TODO成功进行业务处理
        }else {
            //TODO失败进行业务处理
        }
    }

    @Override
    public String serviceKey() {
        return null;
    }

    @Override
    public Boolean payEntrustPayCallBack(HttpServletRequest request) {
        return null;
    }
}
