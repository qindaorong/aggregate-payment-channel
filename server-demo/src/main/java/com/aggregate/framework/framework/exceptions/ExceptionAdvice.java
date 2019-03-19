package com.aggregate.framework.framework.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExceptionAdvice {


    public static final Integer EXCEPTCODE = 500;
    /**
     * 400 - Bad Request
     */
    public static CodeMessage handleMethodArgumentNotValidException(BindingResult bindingResult ) {
        CodeMessage codeMessage = new CodeMessage();
        codeMessage.setCode(400);
        List<String> messageList = new ArrayList<String>();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError objectError : allErrors) {
            String msg = objectError.getDefaultMessage();
            messageList.add(msg);
        }
        codeMessage.setMessage("参数错误!" + StringUtils.join(messageList, '&'));
        return codeMessage;

    }


}
