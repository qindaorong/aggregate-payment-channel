package com.aggregate.framework.pay.bean.yiji.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyBankCardQueryDto extends BaseDto {

    /**
     * 商户订单号
     */
    @ApiModelProperty(value = "商户订单号")
    @NotBlank(message = "商户订单号不能为空")
    private String outOrderNo;

}
