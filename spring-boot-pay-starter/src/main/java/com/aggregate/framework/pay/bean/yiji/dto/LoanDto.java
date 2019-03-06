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
public class LoanDto extends BaseDto {

    /**
     * 商户订单号
     */
    private String merchOrderNo;
    /**
     * 放款金额
     */
    private BigDecimal transAmount;
    /**
     * 账户名（收款人）
     */
    private String accountName;
    /**
     * 身份证号码(收款人)
     * 收款人为个人时，为用户个人的身份证号，支持最后一位输入大写或小写的X
     * 收款人为公司时，则不传；
     */
    private String certNo;
    /**
     * 银行卡号（收款人）
     */
    private String accountNo;
    /**
     * 收款账户类型[AccountTypeEnums]
     */
    private String accountType;
    /**
     * 银行编码
     * 收款人为公司时，必填银行编码
     */
    private String bankCode;
    /**
     * 用途
     */
    private String purpose;
    /**
     * 备注[非必需]
     */
    private String remark;
    /**
     * 分润信息（json）[非必需]
     */
    private String shareProfits;
    /**
     * 分润收款方账户ID[非必需]
     */
    private String shareUserId;
    /**
     * 分润金额[非必需]
     */
    private String shareAmount;
    /**
     * 分润备注[非必需]
     */
    private String memo;

}
