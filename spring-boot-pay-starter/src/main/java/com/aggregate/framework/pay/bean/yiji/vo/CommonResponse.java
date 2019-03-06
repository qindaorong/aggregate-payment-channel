package com.aggregate.framework.pay.bean.yiji.vo;

import com.aggregate.framework.pay.bean.yiji.dto.BaseDto;
import lombok.Data;

@Data
public class CommonResponse extends BaseDto {
    private String protocol;
    private String service;
    private String version;
    private String partnerId;
    private String orderNo;
    private String merchOrderNo;
    private String signType;
    private String sign;
    private String resultCode;
    private String resultMessage;
    private String success;

}
