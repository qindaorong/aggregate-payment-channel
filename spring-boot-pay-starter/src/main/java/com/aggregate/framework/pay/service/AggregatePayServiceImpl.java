package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.YijiCommonResponse;
import com.aggregate.framework.pay.components.PayProxyHandler;
import com.aggregate.framework.pay.enums.PayChannelEnums;
import com.aggregate.framework.pay.service.impl.YijiPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class AggregatePayServiceImpl implements AggregatePayService {

    private Map<String,AggregatePayService> serviceMap = new HashMap<>();

    @PostConstruct
    public void init(){
        serviceMap.put(PayChannelEnums.YIJI.name(), YijiPayServiceImpl.getInstance());
    }


    @Override
    public YijiCommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {

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
    public YijiCommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        return null;
    }

    @Override
    public YijiCommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        return null;
    }

    @Override
    public YijiCommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        return null;
    }

    @Override
    public YijiCommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        return null;
    }

    @Override
    public YijiCommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        return null;
    }
}
