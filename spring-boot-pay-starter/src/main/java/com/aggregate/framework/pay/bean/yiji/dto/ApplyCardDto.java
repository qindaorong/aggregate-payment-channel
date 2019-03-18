package com.aggregate.framework.pay.bean.yiji.dto;

import com.aggregate.framework.pay.enums.yiji.ApplyChannelEnums;
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
public class ApplyCardDto extends BaseDto {

    /**
     * 签约通道 AccountTypeEnums
     */
    @ApiModelProperty(value = "签约通道")
    @NotBlank(message = "签约通道不能为空")
    private ApplyChannelEnums enums;

    /**
     * 签约账号（银行卡号）
     */
    @ApiModelProperty(value = "签约账号（银行卡号）")
    @NotBlank(message = "签约账号（银行卡号）不能为空")
    private String signAccId;

    /**
     * 签约人姓名
     */
    @ApiModelProperty(value = "签约人姓名")
    @NotBlank(message = "签约人姓名不能为空")
    private String signName;

    /**
     * 签约人身份证号
     */
    @ApiModelProperty(value = "签约人身份证号")
    @NotBlank(message = "签约人身份证号不能为空")
    private String signID;


    /**
     * 银行预留手机号
     */
    @ApiModelProperty(value = "银行预留手机号")
    @Length(max = 11, min = 11, message = "手机号的长度必须是11位.")
    private String signMobile;


    /**
     * 交易订单号(16-40)
     */
    @ApiModelProperty(value = "交易订单号(16-40)")
    @Length(min=16,max = 40,message = "交易订单号长度为16-40位")
    private String merchOrderNo;

}
