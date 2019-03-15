package com.aggregate.framework.pay.service.impl;

import com.aggregate.framework.pay.config.AggregatePayConfig;
import com.aggregate.framework.pay.enums.yiji.ApplyChannelEnums;
import com.yiji.openapi.sdk.ApiSdkConstants;
import com.yiji.openapi.sdk.YijiPayClient;
import com.yiji.openapi.tool.YijifuGateway;
import com.yiji.openapi.tool.YijipayConstants;
import com.yiji.openapi.tool.util.Ids;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public class BaseYijiService {

    /**
     * 用户id
     */
    protected static String partnerId;

    /**
     * 添加银行卡测试id
     */
    protected static String partnerIdTest;

    /**
     * 用户key
     */
    protected static  String privateKey;

    /**
     * 易极请求url
     */
    protected static  String url;

    /**
     * 易极请求openApiUrl
     */
    protected static  String openApiUrl;



    protected Map<String ,String> initPaymentCommonPara(String service){
        Map<String ,String> map = new HashMap<String, String>();
        map.put("protocol","httpPost");
        map.put("service",service);
        map.put("version","1.0");
        map.put("partnerId",partnerId);
        map.put(YijipayConstants.ORDER_NO, Ids.oid());
        map.put("signType","MD5");
        map.put("returnUrl","");
        map.put("notifyUrl","");

        return map;
    }

    /**
     * 扣款公共参数
     * @param service
     * @return
     */
    protected Map<String ,String> initDeductionCommonPara(String service){
        Map<String ,String> map = new HashMap<String, String>();
        map.put("signType", "RSA");
        map.put("protocol", " HTTP-FORM-JOSN");
        map.put("orderNo", Ids.oid());
        map.put("service", service);
        map.put("partnerId", ApiSdkConstants.PARTNERID);
        map.put("version", "1.0");
        return map;
    }


    protected String gateWaydoPost(Map<String, String> paraMap){
        String responseStr = "";
        try {
            //同步请求(已经做了签名验签)
            responseStr = YijifuGateway.getOpenApiClientService().doPost(url,paraMap, privateKey);
            log.debug("response string is :{}",responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }


    protected String sdkDoPost(Map<String, String> paraMap, YijiPayClient yijiPayClient){
        String signString = yijiPayClient.sign(paraMap);
        paraMap.put("sign", signString);
        String responseStr = yijiPayClient.post(ApiSdkConstants.SERVICE_GATEWAY, paraMap);
        boolean isPass = yijiPayClient.verySign(responseStr);
        if(isPass) {
            log.debug("verySign passed ！response string is :{}",responseStr);
        }else {
            log.debug("verySign not pass ");
        }
        return responseStr;
    }
}
