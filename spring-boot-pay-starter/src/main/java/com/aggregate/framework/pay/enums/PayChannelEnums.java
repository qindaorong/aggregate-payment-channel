package com.aggregate.framework.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayChannelEnums {
	/**
	 * 易极支付
	 */
	YIJI("yiji");

	private String payType;

}
