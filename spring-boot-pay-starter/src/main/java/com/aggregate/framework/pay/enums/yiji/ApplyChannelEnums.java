package com.aggregate.framework.pay.enums.yiji;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JSONType(serializeEnumAsJavaBean = true)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApplyChannelEnums {

	unionpay("card.add.apply.unionpay"),
	nucc("card.add.apply.nucc");

	private String applyChannel;

}
