package com.aggregate.framework.bean;

import com.aggregate.framework.enums.PayChannelEnums;
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
