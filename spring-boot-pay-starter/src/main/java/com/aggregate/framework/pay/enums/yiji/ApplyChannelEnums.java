package com.aggregate.framework.pay.enums.yiji;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplyChannelEnums {

	unionpay("unionpay"),
	nucc("nucc");

	private String applyChannel;

}
