package com.aggregate.framework.enums.yiji;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCodeEnums {

	executeSuccess("EXECUTE_SUCCESS"),
	executeFail("EXECUTE_FAIL"),
	executeProcessing("EXECUTE_PROCESSING"),
	timeOut("TIME_OUT");

	private String resultCode;

}
