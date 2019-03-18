package com.aggregate.framework.pay.bean.yiji.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDto extends BaseDto {

    /**
     * 商户订单号
     */
    @ApiModelProperty(value = "商户订单号")
    @NotBlank(message = "商户订单号不能为空")
    private String merchOrderNo;
    /**
     * 放款金额
     */
    @ApiModelProperty(value = "放款金额")
    @NotBlank(message = "放款金额不能为空")
    @DecimalMin("0")
    private BigDecimal transAmount;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String accountName;
    /**
     * 身份证号码(收款人)
     * 收款人为个人时，为用户个人的身份证号，支持最后一位输入大写或小写的X
     * 收款人为公司时，则不传；
     */
    @ApiModelProperty(value = "身份证号码")
    @NotBlank(message = "身份证号码(收款人)不能为空")
    private String certNo;
    /**
     * 银行卡号（收款人）
     */
    @ApiModelProperty(value = "银行卡号")
    @NotBlank(message = "银行卡号不能为空")
    private String accountNo;
    /**
     * 收款账户类型[AccountTypeEnums]
     */
    @ApiModelProperty(value = "收款账户类型")
    @NotBlank(message = "收款账户类型不能为空")
    private String accountType;
    /**
     * 银行编码
     * 收款人为公司时，必填银行编码
     */
    @ApiModelProperty(value = "银行编码 收款人为公司时，必填银行编码")
    private String bankCode;
    /**
     * 用途
     */
    @ApiModelProperty(value = "用途")
    private String purpose;
    /**
     * 备注[非必需]
     */
    @ApiModelProperty(value = "备注[非必需]")
    private String remark;
    /**
     * 分润信息（json）[非必需]
     */
    @ApiModelProperty(value = "分润信息非必需")
    private String shareProfits;
    /**
     * 分润收款方账户ID[非必需]
     */
    @ApiModelProperty(value = "分润收款方账户ID[非必需]")
    private String shareUserId;
    /**
     * 分润金额[非必需]
     */
    @ApiModelProperty(value = "分润金额[非必需]")
    private String shareAmount;
    /**
     * 分润备注[非必需]
     */
    @ApiModelProperty(value = "分润备注[非必需]")
    private String memo;

}
