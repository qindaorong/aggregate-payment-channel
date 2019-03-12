package com.aggregate.framework.pay.service.impl;

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
     * 用户key
     */
    protected static  String privateKey;

    /**
     * 易极请求url
     */
    protected static  String url;


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


    protected Map<String ,String> initChargebacksCommonPara(String service){
        Map<String ,String> map = new HashMap<String, String>();
        map.put(YijipayConstants.ORDER_NO, Ids.oid());
        map.put("protocol","httpPost");
        map.put("service",service);
        map.put("version","1.0");
        map.put("partnerId",partnerId);
        map.put("signType","MD5");
        map.put("merchOrderNo","");
        map.put("context","");
        map.put("returnUrl","");
        map.put("notifyUrl","");

        return map;
    }




    protected String doPost(Map<String ,String> paraMap){
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


}
