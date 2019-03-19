package com.aggregate.framework.enums.yiji;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VerifyCardTypeEnums {

    /**
     * 三要素
     */
    threeElement("THREE_ELEMENT"),
    /**
     * 四要素
     */
    fourElement("FOUR_ELEMENT"),
    /**
     * 四要素短信
     */
    fourCaptchaElement("FOUR_CAPTCHA_ELEMENT"),
    /**
     * 运营商四要素
     */
    telecomFourElement("TELECOM_FOUR_ELEMENT");

    private String verifyCardType;
}
