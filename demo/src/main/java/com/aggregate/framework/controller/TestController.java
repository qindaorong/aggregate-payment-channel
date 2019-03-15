package com.aggregate.framework.controller;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.enums.yiji.AccountTypeEnums;
import com.aggregate.framework.pay.enums.yiji.ApplyChannelEnums;
import com.aggregate.framework.pay.enums.yiji.VerifyCardTypeEnums;
import com.aggregate.framework.pay.service.AggregatePayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@Slf4j
public class TestController {

    @Autowired
    AggregatePayService yijiService;


    /**
     *  验卡
     */
    @GetMapping(value = "/verifyBankCard")
    public void verifyBankCard(){
        VerifyBankCardDto verifyBankCardDto =
                VerifyBankCardDto.builder()
                        .bankCardNo("6226095711393038")
                        .verifyCardType(VerifyCardTypeEnums.threeElement.getVerifyCardType())
                        .certNo("610429199009085178")
                        .mobileNo("18317146596")
                        .name("马涛")
                        .outOrderNo("1234567891").build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardDto).enums(PayChannelEnums.YIJI).build();
        yijiService.verifyBankCard(aggregateRequestDto);
        //log.debug("[aggregayrPayService][verifyBankCard] value is {}",isPass);
    }

    /**
     * 验卡查询
     */
    @GetMapping(value = "/verifyBankCardQuery")
    public void verifyBankCardQuery(){
        VerifyBankCardQueryDto verifyBankCardQueryDto =
                VerifyBankCardQueryDto.builder()
                        .outOrderNo("1234567891").build();

        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardQueryDto).enums(PayChannelEnums.YIJI).build();
        yijiService.verifyBankCardQuery(aggregateRequestDto);
        //log.debug("[aggregayrPayService][verifyBankCard] value is {}",isPass);
    }



    /**
     * 放款
     */
    @GetMapping(value = "/loan")
    public void loan(){
        BigDecimal bigDecimal = new BigDecimal(1);
        Date date = new Date();
        LoanDto loanDto =
                LoanDto.builder()
                        .merchOrderNo(date.getTime()+"")
                        .transAmount(bigDecimal)
                        .accountName("郭欣")
                        .certNo("610121199107274442")
                        .accountNo("6214830297644683")
                        .accountType(AccountTypeEnums.privateType.getResultCode())
                        .bankCode("CMB")
                        .purpose("代发工资")
                        .build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(loanDto).enums(PayChannelEnums.YIJI).build();
        yijiService.loan(aggregateRequestDto);
        //log.debug("[aggregayrPayService][verifyBankCard] value is {}",isPass);
    }




    /**
     *  添加银行卡（签约）
     *  statues : ok
     */
    @GetMapping(value = "/addApplyCard")
    public void addApplyCard(){
        ApplyCardDto applyCardDto =
                ApplyCardDto.builder()
                        .enums(ApplyChannelEnums.unionpay)
                        .signAccId("6226095711393038")
                        .signName("马涛")
                        .signID("610429199009085178")
                        .signMobile("18317146596")
                        .merchOrderNo("12345678901234567890")
                        .build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(applyCardDto).enums(PayChannelEnums.YIJI).build();
        yijiService.addApplyCard(aggregateRequestDto);
    }


    /**
     *  确认添加银行卡
     *  statues : ok
     */
    @GetMapping(value = "/cardAddConfirm")
    public void cardAddConfirm(){
        CardAddConfirmDto cardAddConfirmDto =
                CardAddConfirmDto.builder()
                        // 动态短信验证码
                        .authMsg("123456")
                        // 申请添加银行卡时，由易极付返回
                        .signNo("000q01o01j1b6qzjwk00")
                        .merchOrderNo("12345678901234567890")
                        .build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(cardAddConfirmDto).enums(PayChannelEnums.YIJI).build();
        yijiService.cardAddConfirm(aggregateRequestDto);
    }



    /**
     *  删除银行卡（解约）
     *  statues : hold on
     */
    @GetMapping(value = "/cardDelete")
    public void cardDelete(){
        DeleteCardDto deleteCardDto =
                DeleteCardDto.builder()
                        // 申请添加银行卡时，由易极付返回
                        .signNo("000q01o01j1b6qzjwk00")
                        .merchOrderNo("12345678901234567890")
                        .build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(deleteCardDto).enums(PayChannelEnums.YIJI).build();
        yijiService.cardDelete(aggregateRequestDto);
    }


    /**
     *  扣款
     */
    @GetMapping(value = "/payEntrustPay")
    public void payEntrustPay(){
        BigDecimal bigDecimal = new BigDecimal(1);
        EntrustPayDto entrustPayDto =
                EntrustPayDto.builder()
                        .orderDesc("特仑苏1盒")
                        // 生活服务消费
                        .bizTp("100007")
                        .tradeAmount(bigDecimal)
                        // 申请添加银行卡时，由易极付返回
                        .signNo("")
                        .build();
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(entrustPayDto).enums(PayChannelEnums.YIJI).build();
        yijiService.payEntrustPay(aggregateRequestDto);
    }
}
