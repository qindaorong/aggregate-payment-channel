package com.aggregate.framework.pay.enums.yiji;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  BankCodeEnums {
    ABC("农业银行","ABC"),
    BKSH("上海银行","BKSH"),
    BOBJ("北京银行","BOBJ"),
    BOC("中国银行","BOC"),
    BOCD("成都银行","BOCD"),
    BOGZ("贵州银行","BOGZ"),
    BTCB("包商银行","BTCB"),
    CBHB("渤海银行","CBHB"),
    CCB("建设银行","CCB"),
    CEB("光大银行","CEB"),
    CGB("广发银行","CGB"),
    CIB("兴业银行","CIB"),
    CITIC("中信银行","CITIC"),
    CMB("招商银行","CMB"),
    CMBC("民生银行","CMBC"),
    COMM("交通银行","COMM"),
    CQCB("重庆银行","CQCB"),
    CQRCB("重庆农商行","CQRCB"),
    CQTGB("重庆三峡银行","CQTGB"),
    CSRCB("常熟农商行","CSRCB"),
    EBCL("恒丰银行","EBCL");

    private String bankName;

    private String bankCode;
}
