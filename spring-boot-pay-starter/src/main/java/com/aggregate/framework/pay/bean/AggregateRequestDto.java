package com.aggregate.framework.pay.bean;

import com.aggregate.framework.pay.enums.PayChannelEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AggregateRequestDto<T> {

    private T t;

    private PayChannelEnums enums;
}
