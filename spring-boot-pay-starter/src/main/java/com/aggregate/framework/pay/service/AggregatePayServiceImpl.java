package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.adapters.PayAdapter;
import com.aggregate.framework.pay.adapters.YijiAdapter;
import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@Slf4j
public class AggregatePayServiceImpl implements AggregatePayService {

    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"verifyBankCard");
        }
        return null;
    }

    @Override
    public CommonResponse verifyBankCardQuery(AggregateRequestDto<VerifyBankCardQueryDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"verifyBankCardQuery");
        }
        return null;
    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"loan");
        }
        return null;
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"addApplyCard");
        }
        return null;
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"cardAddConfirm");
        }
        return null;
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"cardDelete");
        }
        return null;
    }

    @Override
    public CommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        Class<? extends PayAdapter> clazz ;
        if(requestDto.getEnums().equals(PayChannelEnums.YIJI)){
            clazz = YijiAdapter.class;
            return this.doProcess(requestDto, clazz,"payEntrustPay");
        }
        return null;
    }

    private CommonResponse doProcess(AggregateRequestDto<?> requestDto,Class<? extends PayAdapter> clazz,String methodName){
        CommonResponse  commonResponse = null;
        try{
            PayAdapter adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                Method method = adapter.getClass().getMethod(methodName,AggregateRequestDto.class);
                commonResponse = (CommonResponse)method.invoke(adapter,requestDto);
                return commonResponse;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
