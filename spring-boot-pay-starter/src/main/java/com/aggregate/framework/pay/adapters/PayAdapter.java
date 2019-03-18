package com.aggregate.framework.pay.adapters;

import com.aggregate.framework.pay.service.AggregatePayService;

public interface PayAdapter extends AggregatePayService {

    boolean support(Object adapter);
}
