package com.aggregate.framework.pay.bean.yiji.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntrustPayDto extends BaseDto {


    /**
     * 订单详情
     */
    private String orderDesc;

    /**
     * 业务种类
     */
    private String bizTp;

    /**
     * 交易金额
     */
    private BigDecimal tradeAmount;

    /**
     * 收款人易极付ID
     */
    private String payeeUserId;

    /**
     * 支付标记
     */
    private String signNo;
    /**
     * 分账金额(默认为0)
     */
    private BigDecimal distributeAmount;
}
