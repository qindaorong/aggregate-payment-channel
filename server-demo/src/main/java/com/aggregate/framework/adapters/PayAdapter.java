package com.aggregate.framework.adapters;


import com.aggregate.framework.service.AggregatePayService;

public interface PayAdapter extends AggregatePayService {

    boolean support(Object adapter);
}
