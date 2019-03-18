package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.pay.components.PayProxyHandler;
import com.aggregate.framework.pay.config.AggregatePayConfig;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.service.impl.YijiPayServiceImpl;
import com.yiji.openapi.sdk.YijiPayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AggregatePayServiceImpl implements AggregatePayService {

    private Map<String,AggregatePayService> serviceMap = new HashMap<String,AggregatePayService>();

    @Autowired
    AggregatePayConfig.YijiPayConfig yijiPayConfig;

    @Autowired
    YijiPayClient yijiPayClient;

    @PostConstruct
    public void init(){
        serviceMap.put(PayChannelEnums.YIJI.name(), YijiPayServiceImpl.getInstance(yijiPayConfig,yijiPayClient));
    }


    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
        return this.doProcess(requestDto,"verifyBankCard");
    }

    @Override
    public CommonResponse verifyBankCardQuery(AggregateRequestDto<VerifyBankCardQueryDto> requestDto) {
        return this.doProcess(requestDto,"verifyBankCardQuery");
    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        return this.doProcess(requestDto,"loan");
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        return this.doProcess(requestDto,"addApplyCard");
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        return this.doProcess(requestDto,"cardAddConfirm");
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        return this.doProcess(requestDto,"cardDelete");
    }

    @Override
    public CommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        return this.doProcess(requestDto,"payEntrustPay");
    }


    private CommonResponse doProcess(AggregateRequestDto<?> requestDto,String methodName){
        CommonResponse  commonResponse = null;
        try {
            Object obj = new PayProxyHandler().getInstance(serviceMap.get(requestDto.getEnums().name()));
            Method method = obj.getClass().getMethod(methodName,requestDto.getClass());
            commonResponse = (CommonResponse)method.invoke(obj,requestDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commonResponse;
    }

}
