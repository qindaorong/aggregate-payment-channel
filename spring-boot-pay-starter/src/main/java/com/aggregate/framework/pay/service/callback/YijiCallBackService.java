package com.aggregate.framework.pay.service.callback;

import javax.servlet.http.HttpServletRequest;

public interface YijiCallBackService {

      /**
     * 验卡异步通知
     * @param request
     * @return
     */
    Boolean verifyBankCardCallBack(HttpServletRequest request);


    /**
     * 放款异步通知
     * @param request
     * @return
     */
    Boolean loanCallBack(HttpServletRequest request);


    /**
     * 委托扣款异步通知
     * @param request
     * @return
     */
    Boolean payEntrustPayCallBack(HttpServletRequest request);

}
