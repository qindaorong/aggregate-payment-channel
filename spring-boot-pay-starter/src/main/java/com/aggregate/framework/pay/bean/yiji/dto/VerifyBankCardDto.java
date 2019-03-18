package com.aggregate.framework.pay.bean.yiji.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyBankCardDto extends BaseDto {

    /**
     * 商户订单号
     */
    @ApiModelProperty(value = "商户订单号")
    @NotBlank(message = "商户订单号不能为空")
    private String outOrderNo;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    @NotBlank(message = "身份证号不能为空")
    private String certNo;
    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    @NotBlank(message = "银行卡号不能为空")
    private String bankCardNo;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Length(max = 11, min = 11, message = "手机号的长度必须是11位.")
    private String mobileNo;
    /**
     * 验卡类型[VerifyCardTypeEnums]
     */
    @ApiModelProperty(value = "验卡类型")
    @NotBlank(message = "验卡类型不能为空")
    private  String verifyCardType;

}
