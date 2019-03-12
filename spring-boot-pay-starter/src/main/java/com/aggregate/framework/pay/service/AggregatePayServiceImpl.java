package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.YijiCommonResponse;
import com.aggregate.framework.pay.components.PayProxyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AggregatePayServiceImpl implements AggregatePayService {

    @Autowired
    PayProxyHandler payProxyHandler;


    @Override
    public YijiCommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
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
