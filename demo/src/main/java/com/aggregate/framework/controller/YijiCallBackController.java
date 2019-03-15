package com.aggregate.framework.controller;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.VerifyBankCardDto;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.enums.yiji.VerifyCardTypeEnums;
import com.aggregate.framework.pay.service.AggregatePayService;
import com.aggregate.framework.pay.service.callback.YijiCallBackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class YijiCallBackController {


    @Autowired
    private YijiCallBackService yijiCallBackService;

    /**
     * 验卡异步回调通知
     * @param request
     * @param response
     */
    @RequestMapping("/verifyBankCardCallBackNotify")
    public void verifyBankCardCallBackNotify(final HttpServletRequest request, HttpServletResponse response) {
        log.info("[YijiCallBackController].[verifyBankCardCallBackNotify] notify start");
        try {
        Boolean flag = yijiCallBackService.verifyBankCardCallBack(request);
        if (flag) {
            log.info("[YijiCallBackController].[verifyBankCardCallBackNotify] notify success");
            response.getWriter().write("SUCCESS");
        } else {
            log.info("[YijiCallBackController].[verifyBankCardCallBackNotify] notify fail");
            response.getWriter().write("FAIL");
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
