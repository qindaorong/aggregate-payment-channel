package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;

public interface YijiService {


    /**--------------------验卡 + 放款------------------**/
    /**
     * 验证银行卡
     * @param requestDto
     * @return
     */
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto);

    /**
     * 放卡
     * @param requestDto
     * @return
     */
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto);



    /**--------------------委托 + 扣款------------------**/

    /**
     * 申请添加银行卡
     * @return
     */
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto);


    /**
     * 确认添加银行卡
     * @return
     */
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto);

    /**
     * 解约
     * @return
     */
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto);


    /**
     * 扣款
     * @return
     */
    public CommonResponse payEntrustpay(AggregateRequestDto<EntrustPayDto> requestDto);
}
