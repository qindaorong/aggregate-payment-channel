package com.aggregate.framework.service.callback;

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




}
