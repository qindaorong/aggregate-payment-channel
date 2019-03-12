package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.pay.components.PayProxyHandler;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.service.impl.YijiPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AggregatePayServiceImpl implements AggregatePayService {

    private Map<String,AggregatePayService> serviceMap = new HashMap<>();

    @PostConstruct
    public void init(){
        serviceMap.put(PayChannelEnums.YIJI.name(), YijiPayServiceImpl.getInstance());
    }


    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {

        Object obj = null;
        try {
            obj = new PayProxyHandler().getInstance(serviceMap.get(requestDto.getEnums().name()));
            Method method = obj.getClass().getMethod("verifyBankCard",requestDto.getClass());
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        return null;
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        return null;
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        return null;
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        return null;
    }

    @Override
    public CommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        return null;
    }
}
