package com.aggregate.framework.controller;


import com.aggregate.framework.bean.AggregateRequestDto;
import com.aggregate.framework.bean.yiji.dto.*;
import com.aggregate.framework.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.enums.PayChannelEnums;
import com.aggregate.framework.framework.exceptions.CodeMessage;
import com.aggregate.framework.framework.exceptions.ExceptionAdvice;
import com.aggregate.framework.framework.exceptions.ResponseResult;
import com.aggregate.framework.service.AggregatePayService;
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
    public ResponseResult verifyBankCard(@RequestBody final @Valid VerifyBankCardDto verifyBankCardDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
            return  ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
        }else{
            AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardDto).enums(PayChannelEnums.YIJI).build();
            CommonResponse commonResponse = yijiService.verifyBankCard(aggregateRequestDto);
            if(commonResponse.getFlag()){
                return ResponseResult.success(commonResponse);
            }else{
                return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,commonResponse.getResultMessage(),commonResponse);
            }
        }
    }

    /**
     * 验卡查询
     */
    @PostMapping(value = "/verifyBankCardQuery")
    @ApiOperation(value="验卡查询接口",httpMethod = "POST", notes = "VerifyBankCardQueryDto  请求实体具体参数以swagger文档说明为参考")
    public ResponseResult verifyBankCardQuery(@RequestBody final @Valid VerifyBankCardQueryDto verifyBankCardQueryDto, BindingResult bindingResult){
     if(bindingResult.hasErrors()){
         CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
         return  ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
     }else{
         AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(verifyBankCardQueryDto).enums(PayChannelEnums.YIJI).build();
         CommonResponse commonResponse = yijiService.verifyBankCardQuery(aggregateRequestDto);
         if(commonResponse.getFlag()){
             return ResponseResult.success(commonResponse);
         }else{
             return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,commonResponse.getResultMessage(),commonResponse);
         }
     }
    }



    /**
     * 放款
     */
    @ApiOperation(value="放款接口",httpMethod = "POST", notes = "LoanDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/loan")
    public ResponseResult loan(@RequestBody final @Valid LoanDto loanDto, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
           return ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
       }else{
           AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(loanDto).enums(PayChannelEnums.YIJI).build();
           CommonResponse commonResponse = yijiService.loan(aggregateRequestDto);
           if(commonResponse.getFlag()){
               return ResponseResult.success(commonResponse);
           }else{
               return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,commonResponse.getResultMessage(),commonResponse);
           }
       }
    }




    /**
     *  添加银行卡（签约）
     *  statues : ok
     */
    @ApiOperation(value=" 添加银行卡（签约）",httpMethod = "POST", notes = "ApplyCardDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/addApplyCard")
    public ResponseResult addApplyCard(@RequestBody final @Valid ApplyCardDto applyCardDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
            return ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
        }else{
            AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(applyCardDto).enums(PayChannelEnums.YIJI).build();
            CommonResponse commonResponse = yijiService.addApplyCard(aggregateRequestDto);
            if(commonResponse.getFlag()){
                return ResponseResult.success(commonResponse);
            }else{
                return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,commonResponse.getResultMessage(),commonResponse);
            }
        }
    }


    /**
     *  确认添加银行卡
     *  statues : ok
     */
    @ApiOperation(value="确认添加银行卡",httpMethod = "POST", notes = "CardAddConfirmDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/cardAddConfirm")
    public ResponseResult cardAddConfirm(@RequestBody final @Valid CardAddConfirmDto cardAddConfirmDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
            return ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
        }else{
            AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(cardAddConfirmDto).enums(PayChannelEnums.YIJI).build();
            CommonResponse response = yijiService.cardAddConfirm(aggregateRequestDto);
            if(response.getFlag()){
                return ResponseResult.success(response);
            }else{
                return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,response.getResultMessage(),response);
            }
        }
    }



    /**
     *  删除银行卡（解约）
     *  statues : hold on
     */
    @ApiOperation(value="删除银行卡（解约",httpMethod = "POST", notes = "DeleteCardDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/cardDelete")
    public ResponseResult cardDelete(@RequestBody final @Valid DeleteCardDto deleteCardDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
            return ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
        }else{
            AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(deleteCardDto).enums(PayChannelEnums.YIJI).build();
            CommonResponse commonResponse = yijiService.cardDelete(aggregateRequestDto);
            if(commonResponse.getFlag()){
                return ResponseResult.success(commonResponse);
            }else{
                return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,commonResponse.getResultMessage(),commonResponse);
            }
        }
    }


    /**
     *  扣款
     */
    @ApiOperation(value="扣款",httpMethod = "POST", notes = "EntrustPayDto  请求实体具体参数以swagger文档说明为参考")
    @PostMapping(value = "/payEntrustPay")
    public ResponseResult payEntrustPay(@RequestBody final @Valid EntrustPayDto entrustPayDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            CodeMessage codeMessage = ExceptionAdvice.handleMethodArgumentNotValidException(bindingResult);
            return  ResponseResult.fail(codeMessage.getCode(),codeMessage.getMessage());
        }
        AggregateRequestDto aggregateRequestDto = AggregateRequestDto.builder().t(entrustPayDto).enums(PayChannelEnums.YIJI).build();
        CommonResponse commonResponse = yijiService.payEntrustPay(aggregateRequestDto);
        if(commonResponse.getFlag()){
            return ResponseResult.success(commonResponse);
        }else{
            return ResponseResult.fail(ExceptionAdvice.EXCEPTCODE,commonResponse.getResultMessage(),commonResponse);
        }
    }
}
