package com.aggregate.framework.pay.service.callback;

import javax.servlet.http.HttpServletRequest;

public interface EntrustPayCallBackService {

    /**
     * 委托扣款异步通知
     * @param request
     * @return
     */
    Boolean payEntrustPayCallBack(HttpServletRequest request);
}
