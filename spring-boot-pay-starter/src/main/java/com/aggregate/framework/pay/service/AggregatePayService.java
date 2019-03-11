package com.aggregate.framework.pay.service;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.YijiCommonResponse;

public interface AggregatePayService {


    /**--------------------验卡 + 放款------------------**/
    /**
     * 验证银行卡
     * @param requestDto
     * @return
     */
    public YijiCommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto);

    /**
     * 放卡
     * @param requestDto
     * @return
     */
    public YijiCommonResponse loan(AggregateRequestDto<LoanDto> requestDto);



    /**--------------------委托 + 扣款------------------**/

    /**
     * 申请添加银行卡
     * @return
     */
    public YijiCommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto);


    /**
     * 确认添加银行卡
     * @return
     */
    public YijiCommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto);

    /**
     * 解约
     * @return
     */
    public YijiCommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto);


    /**
     * 扣款
     * @return
     */
    public YijiCommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto);
}
