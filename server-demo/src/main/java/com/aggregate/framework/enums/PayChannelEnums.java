package com.aggregate.framework.enums;

import com.aggregate.framework.adapters.PayAdapter;
import com.aggregate.framework.adapters.YijiAdapter;
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
