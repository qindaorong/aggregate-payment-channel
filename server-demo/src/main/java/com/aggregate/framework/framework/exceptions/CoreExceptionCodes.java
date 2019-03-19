package com.aggregate.framework.framework.exceptions;


public class CoreExceptionCodes {
    public static final CodeMessage SUCCESS = new CodeMessage(200, "成功");
    public static final CodeMessage FAIL = new CodeMessage(-1 , "失败");
    public static final CodeMessage UNKNOWN_ERROR = new CodeMessage(999999, "系统异常");
    public static final CodeMessage PARAM_IS_NULL = new CodeMessage(20001, "参数为空");
    public static final CodeMessage HTTP_CODE_WRONG = new CodeMessage(61000, "Http请求返回码错误");

    CoreExceptionCodes() {
    }
}
