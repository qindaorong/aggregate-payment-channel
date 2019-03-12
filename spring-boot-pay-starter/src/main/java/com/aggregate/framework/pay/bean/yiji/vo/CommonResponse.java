package com.aggregate.framework.pay.bean.yiji.vo;

import com.aggregate.framework.pay.bean.yiji.dto.BaseDto;
import lombok.Data;

@Data
public class CommonResponse extends BaseDto {

    private String resultCode;
    private String resultMessage;
    private String success;

}
