package com.aggregate.framework.controller;


import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.framework.exceptions.CodeMessage;
import com.aggregate.framework.pay.framework.exceptions.ExceptionAdvice;
import com.aggregate.framework.pay.framework.exceptions.ResponseResult;
import com.aggregate.framework.pay.service.AggregatePayService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class YijiController {

    @Autowired
    AggregatePayService yijiService;

    /**
     *  验卡
     */
    @PostMapping(value = "/verifyBankCard")
    @ApiOperation(value="验卡接口使用时,可进行三要素验卡、四要素验卡或四要素加短信验卡",httpMethod = "POST", notes = "VerifyBankCardDto  请求实体具体参数以swagger文档说明为参考")
    public CommonResponse verifyBankCard(@RequestBody final @Valid VerifyBankCardDto verifyBankCardDto){
        /*VerifyBankCardDto verifyBankCardDto =
                VerifyBankCardDto.builder()
                        .bankCardNo("6226095711393038")
                        .verifyCardType(VerifyCardTypeEnums.threeElement.getVerifyCardType())
                        .certNo("610429199009085178")
                        .mobileNo("18317146596")
                        .name("马涛")
                        .outOrderNo("1234567891").build();*/
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardDto).enums(PayChannelEnums.YIJI).build();
        return  yijiService.verifyBankCard(aggregateRequestDto);
        //log.debug("[aggregayrPayService][verifyBankCard] value is {}",isPass);
    }

    /**
     * 验卡查询
     */
    @PostMapping(value = "/verifyBankCardQuery")
    @ApiOperation(value="验卡查询接口",httpMethod = "POST", notes = "VerifyBankCardQueryDto  请求实体具体参数以swagger文档说明为参考")
    public CommonResponse verifyBankCardQuery(@RequestBody final @Valid VerifyBankCardQueryDto verifyBankCardQueryDto){
     /*   VerifyBankCardQueryDto verifyBankCardQueryDto =
                VerifyBankCardQueryDto.builder()
                        .outOrderNo("1234567891").build();*/

        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardQueryDto).enums(PayChannelEnums.YIJI).build();
        return yijiService.verifyBankCardQuery(aggregateRequestDto);
        //log.debug("[aggregayrPayService][verifyBankCard] value is {}",isPass);
    }



    /**
     * 放款
     */
    @ApiOperation(value="放款接口",httpMethod = "POST", notes = "LoanDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/loan")
    public CommonResponse loan(@RequestBody final @Valid LoanDto loanDto){
       /* BigDecimal bigDecimal = new BigDecimal(1);
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
                        .build();*/
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(loanDto).enums(PayChannelEnums.YIJI).build();
        return yijiService.loan(aggregateRequestDto);
    }




    /**
     *  添加银行卡（签约）
     *  statues : ok
     */
    @ApiOperation(value=" 添加银行卡（签约）",httpMethod = "POST", notes = "ApplyCardDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/addApplyCard")
    public CommonResponse addApplyCard(@RequestBody final @Valid ApplyCardDto applyCardDto){
       /* ApplyCardDto applyCardDto =
                ApplyCardDto.builder()
                        .enums(ApplyChannelEnums.unionpay)
                        .signAccId("6226095711393038")
                        .signName("马涛")
                        .signID("610429199009085178")
                        .signMobile("18317146596")
                        .merchOrderNo("12345678901234567890")
                        .build();*/
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(applyCardDto).enums(PayChannelEnums.YIJI).build();
        return yijiService.addApplyCard(aggregateRequestDto);
    }


    /**
     *  确认添加银行卡
     *  statues : ok
     */
    @ApiOperation(value="确认添加银行卡",httpMethod = "POST", notes = "CardAddConfirmDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/cardAddConfirm")
    public ResponseResult cardAddConfirm(@RequestBody final @Valid CardAddConfirmDto cardAddConfirmDto, BindingResult bindingResult){
       /* CardAddConfirmDto cardAddConfirmDto =
                CardAddConfirmDto.builder()
                        // 动态短信验证码
                        .authMsg("123456")
                        // 申请添加银行卡时，由易极付返回
                        .signNo("000q01o01j1b6qzjwk00")
                        .merchOrderNo("12345678901234567890")
                        .build();*/
        if(bindingResult.hasErrors()){
            CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
            return ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
        }else{
            AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(cardAddConfirmDto).enums(PayChannelEnums.YIJI).build();
            CommonResponse response = yijiService.cardAddConfirm(aggregateRequestDto);
            return ResponseResult.success(response);
        }
    }



    /**
     *  删除银行卡（解约）
     *  statues : hold on
     */
    @ApiOperation(value="删除银行卡（解约）",httpMethod = "POST", notes = "DeleteCardDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/cardDelete")
    public CommonResponse cardDelete(@RequestBody final @Valid DeleteCardDto deleteCardDto){
      /*  DeleteCardDto deleteCardDto =
                DeleteCardDto.builder()
                        // 申请添加银行卡时，由易极付返回
                        .signNo("000q01o01j1b6qzjwk00")
                        .merchOrderNo("12345678901234567890")
                        .build();*/
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(deleteCardDto).enums(PayChannelEnums.YIJI).build();
        return yijiService.cardDelete(aggregateRequestDto);
    }


    /**
     *  扣款
     */
    @ApiOperation(value="扣款",httpMethod = "POST", notes = "EntrustPayDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/payEntrustPay")
    public CommonResponse payEntrustPay(@RequestBody final @Valid EntrustPayDto entrustPayDto){
       /* BigDecimal bigDecimal = new BigDecimal(1);
        EntrustPayDto entrustPayDto =
                EntrustPayDto.builder()
                        .orderDesc("特仑苏1盒")
                        // 生活服务消费
                        .bizTp("100007")
                        .tradeAmount(bigDecimal)
                        // 申请添加银行卡时，由易极付返回
                        .signNo("")
                        .build();*/
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(entrustPayDto).enums(PayChannelEnums.YIJI).build();
        return yijiService.payEntrustPay(aggregateRequestDto);
    }
}
