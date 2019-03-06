package com.aggregate.framework.controller;

import com.aggregate.framework.pay.bean.yiji.dto.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.VerifyBankCardDto;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.enums.yiji.VerifyCardTypeEnums;
import com.aggregate.framework.pay.service.YijiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    YijiService yijiService;

    @GetMapping(value = "/test")
    public void test(){
        VerifyBankCardDto verifyBankCardDto =
                VerifyBankCardDto.builder()
                        .bankCardNo("6225882139817719")
                        .verifyCardType(VerifyCardTypeEnums.threeElement.getVerifyCardType())
                        .certNo("610103198804273616")
                        .mobileNo("18621075370")
                        .name("秦道荣")
                        .outOrderNo("123456").build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardDto).enums(PayChannelEnums.YIJI).build();
        yijiService.verifyBankCard(aggregateRequestDto);
        //log.debug("[aggregayrPayService][verifyBankCard] value is {}",isPass);
    }
}
