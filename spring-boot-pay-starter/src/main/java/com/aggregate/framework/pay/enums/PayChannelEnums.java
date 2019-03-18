package com.aggregate.framework.pay.enums;

import com.aggregate.framework.pay.adapters.PayAdapter;
import com.aggregate.framework.pay.adapters.YijiAdapter;
import lombok.Getter;

@Getter
public enum PayChannelEnums {

	/**
	 * 易极支付
	 */
	YIJI(new YijiAdapter());

	private PayAdapter payAdapter;

	PayChannelEnums(PayAdapter payAdapter){
		this.payAdapter = payAdapter;
	}

	public PayAdapter get(){
		return  this.payAdapter;
	}




}
