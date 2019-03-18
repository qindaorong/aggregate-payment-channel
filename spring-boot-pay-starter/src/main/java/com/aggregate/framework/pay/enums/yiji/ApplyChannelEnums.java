package com.aggregate.framework.pay.enums.yiji;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplyChannelEnums {

	unionpay("card.add.apply.unionpay"),
	nucc("card.add.apply.nucc");

	private String applyChannel;

}
