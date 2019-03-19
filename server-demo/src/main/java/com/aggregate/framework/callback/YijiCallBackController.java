package com.aggregate.framework.callback;

import com.aggregate.framework.service.callback.YijiCallBackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
