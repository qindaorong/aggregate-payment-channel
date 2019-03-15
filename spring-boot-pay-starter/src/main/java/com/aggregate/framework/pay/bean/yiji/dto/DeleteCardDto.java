package com.aggregate.framework.pay.bean.yiji.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCardDto extends BaseDto {

    /**
     * 签约号
     */
    private String signNo;

    /**
     * 交易订单号(16-40)
     */
    private String merchOrderNo;

}
