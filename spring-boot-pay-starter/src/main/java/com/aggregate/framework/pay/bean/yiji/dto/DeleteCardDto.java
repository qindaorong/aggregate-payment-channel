package com.aggregate.framework.pay.bean.yiji.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCardDto extends BaseDto {

    /**
     * 签约号
     */
    @ApiModelProperty(value = "签约号")
    @NotBlank(message = "支付标记不能为空")
    private String signNo;

    /**
     * 交易订单号(16-40)
     */
    @ApiModelProperty(value = "交易订单号(16-40)")
    @NotBlank(message = "交易订单号不能为空")
    @Length(min=16,max = 40,message = "交易订单号长度为16-40位")
    private String merchOrderNo;

}
