package com.aggregate.framework.pay.service.impl;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.pay.bean.yiji.vo.YijiCommonResponse;
import com.aggregate.framework.pay.components.SpringApplicationContext;
import com.aggregate.framework.pay.config.AggregatePayConfig;
import com.aggregate.framework.pay.enums.yiji.ApplyChannelEnums;
import com.aggregate.framework.pay.framework.yiji.Constants;
import com.aggregate.framework.pay.service.AggregatePayService;
import com.aggregate.framework.pay.utils.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;


public class YijiPayServiceImpl extends BaseYijiService implements AggregatePayService {

    AggregatePayConfig.YijiPayConfig yijiPayConfig;

    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
        VerifyBankCardDto verifyBankCardDto = requestDto.getT();
        Map<String, String> map =super.initPaymentCommonPara(Constants.YijiServiceUrl.VERIFY_BANK_CARD);
        map.put("outOrderNo",verifyBankCardDto.getOutOrderNo());
        map.put("name",verifyBankCardDto.getName());
        map.put("certNo",verifyBankCardDto.getCertNo());
        map.put("bankCardNo",verifyBankCardDto.getBankCardNo());
        map.put("mobileNo",verifyBankCardDto.getMobileNo());
        map.put("verifyCardType",verifyBankCardDto.getVerifyCardType());

        String responseStr = super.doPost(map);
        return this.convert2CommonResponse(responseStr);

    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        LoanDto loanDto = requestDto.getT();
        Map<String, String> map =super.initPaymentCommonPara(Constants.YijiServiceUrl.LOAN);

        map.put("merchOrderNo",loanDto.getMerchOrderNo());
        map.put("transAmount",String.valueOf(loanDto.getTransAmount().doubleValue()));
        map.put("accountName",loanDto.getAccountName());
        map.put("certNo",loanDto.getCertNo());
        map.put("accountNo",loanDto.getAccountNo());
        map.put("accountType",loanDto.getAccountType());
        map.put("bankCode", StringUtils.isEmpty(loanDto.getBankCode())?"":loanDto.getBankCode());
        map.put("purpose",loanDto.getPurpose());
        map.put("remark",StringUtils.isEmpty(loanDto.getRemark())?"":loanDto.getRemark());
        map.put("shareProfits",StringUtils.isEmpty(loanDto.getShareProfits())?"":loanDto.getShareProfits());
        map.put("shareUserId",StringUtils.isEmpty(loanDto.getShareUserId())?"":loanDto.getShareUserId());
        map.put("shareAmount",StringUtils.isEmpty(loanDto.getShareAmount())?"":loanDto.getShareAmount());
        map.put("memo",StringUtils.isEmpty(loanDto.getMemo())?"":loanDto.getMemo());

        String responseStr = super.doPost(map);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        ApplyCardDto applyCardDto = requestDto.getT();
        String serviceUrl = applyCardDto.getEnums().equals(ApplyChannelEnums.unionpay)?Constants.YijiServiceUrl.UNIONPAY:Constants.YijiServiceUrl.NUCC;
        Map<String, String> map =super.initChargebacksCommonPara(serviceUrl);

        map.put("signAccId",applyCardDto.getSignAccId());
        map.put("signName",applyCardDto.getSignName());
        map.put("signID",applyCardDto.getSignID());
        map.put("signMobile",applyCardDto.getSignMobile());

        String responseStr = super.doPost(map);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        CardAddConfirmDto cardAddConfirmDto = requestDto.getT();
        Map<String, String> map =super.initChargebacksCommonPara(Constants.YijiServiceUrl.CARD_ADD_CONFIRM);

        map.put("signNo",cardAddConfirmDto.getSignNo());
        map.put("authMsg",cardAddConfirmDto.getAuthMsg());

        String responseStr = super.doPost(map);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        DeleteCardDto deleteCardDto = requestDto.getT();
        Map<String, String> map =super.initChargebacksCommonPara(Constants.YijiServiceUrl.CARD_DELETE);
        map.put("signNo",deleteCardDto.getSignNo());

        String responseStr = super.doPost(map);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        EntrustPayDto entrustPayDto = requestDto.getT();
        Map<String, String> map =super.initChargebacksCommonPara(Constants.YijiServiceUrl.PAY_ENTRUSTPAY);

        map.put("orderDesc",entrustPayDto.getOrderDesc());
        map.put("bizTp",entrustPayDto.getBizTp());
        map.put("tradeAmount",String.valueOf(entrustPayDto.getTradeAmount().doubleValue()));
        map.put("payeeUserId",yijiPayConfig.getPartnerId());
        map.put("signNo",entrustPayDto.getSignNo());

        String responseStr = super.doPost(map);

        return this.convert2CommonResponse(responseStr);
    }

    private YijiPayServiceImpl(){
        if(YijiPayServiceImpl.YijiPayServiceHolder.YIJIPAY_SERVICE != null){
            throw new RuntimeException("不允许创建多个实例");
        }

        if(Objects.isNull(yijiPayConfig)){
            yijiPayConfig = SpringApplicationContext.getBean(AggregatePayConfig.YijiPayConfig .class);
            super.partnerId = yijiPayConfig.getPartnerId();
            super.privateKey = yijiPayConfig.getPrivateKey();
            super.url = yijiPayConfig.getUrl();
        }
    }


    public static final YijiPayServiceImpl getInstance(){
        return YijiPayServiceImpl.YijiPayServiceHolder.YIJIPAY_SERVICE;
    }


    private static class YijiPayServiceHolder{
        private static final YijiPayServiceImpl YIJIPAY_SERVICE = new YijiPayServiceImpl();
    }

    public  CommonResponse convert2CommonResponse(String  responseStr){
        CommonResponse commonResponse  = new CommonResponse();
        YijiCommonResponse yijiCommonResponse = JsonUtil.parseObject(responseStr, YijiCommonResponse.class);
        BeanUtils.copyProperties(yijiCommonResponse,commonResponse);
        return commonResponse;
    }



}
