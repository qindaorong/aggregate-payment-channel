package com.aggregate.framework.pay.bean.yiji.dto;

import com.aggregate.framework.pay.enums.yiji.ApplyChannelEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyCardDto extends BaseDto {

    /**
     * 签约通道 AccountTypeEnums
     */
    private ApplyChannelEnums enums;

    /**
     * 签约账号（银行卡号）
     */
    private String signAccId;

    /**
     * 签约人姓名
     */
    private String signName;

    /**
     * 签约人身份证号
     */
    private String signID;


    /**
     * 银行预留手机号
     */
    private String signMobile;

}
