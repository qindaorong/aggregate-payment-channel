package com.aggregate.framework.enums.yiji;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnums {

	publicType("PUBLIC"),
	privateType("PRIVATE");

	private String resultCode;

}
