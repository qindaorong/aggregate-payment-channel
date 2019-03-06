package com.aggregate.framework.pay.bean.yiji.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyBankCardDto extends BaseDto {

    /**
     * 商户订单号
     */
    private String outOrderNo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String certNo;
    /**
     * 银行卡号
     */
    private String bankCardNo;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 验卡类型[VerifyCardTypeEnums]
     */
    private  String verifyCardType;

}
