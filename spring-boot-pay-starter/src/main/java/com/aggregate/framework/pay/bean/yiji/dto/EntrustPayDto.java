package com.aggregate.framework.pay.bean.yiji.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntrustPayDto extends BaseDto {


    /**
     * 订单详情
     */
    @ApiModelProperty(value = "订单详情")
    @NotBlank(message = "订单详情不能为空")
    private String orderDesc;

    /**
     * 业务种类
     */
    @ApiModelProperty(value = "业务种类")
    @NotBlank(message = "业务种类不能为空")
    private String bizTp;

    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额")
    @NotNull
    private BigDecimal tradeAmount;

    /**
     * 收款人易极付ID
     */
    @ApiModelProperty(value = "收款人易极付ID")
    @NotBlank(message = "收款人易极付ID不能为空")
    private String payeeUserId;

    /**
     * 支付标记
     */
    @ApiModelProperty(value = "支付标记")
    @NotBlank(message = "支付标记不能为空")
    private String signNo;
    /**
     * 分账金额(默认为0)
     */
    @ApiModelProperty(value = "分账金额(默认为0)")
    private BigDecimal distributeAmount;
}
