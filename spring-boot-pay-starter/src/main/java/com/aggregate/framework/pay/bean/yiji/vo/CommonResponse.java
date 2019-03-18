package com.aggregate.framework.pay.bean.yiji.vo;

import com.aggregate.framework.pay.bean.yiji.dto.BaseDto;
import lombok.Data;

@Data
public class CommonResponse extends BaseDto {

    private String resultCode;

    private String resultMessage;

    /**
     * 第三方返回json
     */
    private String responseStr;

    /**
     * 成功标识
     */
    private Boolean flag;

}
