package com.aggregate.framework.pay.bean.yiji.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardAddConfirmDto extends BaseDto {

    /**
     * 支付标记
     */
    private String signNo;

    /**
     * 动态验证码
     */
    private String authMsg;

}
