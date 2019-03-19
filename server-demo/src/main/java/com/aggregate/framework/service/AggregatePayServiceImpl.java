package com.aggregate.framework.service;


import com.aggregate.framework.adapters.PayAdapter;
import com.aggregate.framework.bean.AggregateRequestDto;
import com.aggregate.framework.bean.yiji.dto.*;
import com.aggregate.framework.bean.yiji.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AggregatePayServiceImpl implements AggregatePayService {

    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.verifyBankCard(requestDto);
        }
        return null;
    }

    @Override
    public CommonResponse verifyBankCardQuery(AggregateRequestDto<VerifyBankCardQueryDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.verifyBankCardQuery(requestDto);
        }
        return null;
    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.loan(requestDto);
        }
        return null;
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.addApplyCard(requestDto);
        }
        return null;
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.cardAddConfirm(requestDto);
        }
        return null;
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.cardDelete(requestDto);
        }
        return null;
    }

    @Override
    public CommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        PayAdapter adapter= requestDto.getEnums().get();
        if(adapter.support(adapter)) {
            return adapter.payEntrustPay(requestDto);
        }
        return null;
    }
}
