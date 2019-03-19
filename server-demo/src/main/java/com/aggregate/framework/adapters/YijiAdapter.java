package com.aggregate.framework.adapters;

import com.aggregate.framework.bean.AggregateRequestDto;
import com.aggregate.framework.bean.yiji.dto.*;
import com.aggregate.framework.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.bean.yiji.vo.YijiCommonResponse;
import com.aggregate.framework.components.SpringApplicationContext;
import com.aggregate.framework.config.AggregatePayConfig;
import com.aggregate.framework.enums.yiji.ApplyChannelEnums;
import com.aggregate.framework.framework.yiji.Constants;
import com.aggregate.framework.utils.JsonUtil;
import com.yiji.openapi.sdk.ApiSdkConstants;
import com.yiji.openapi.sdk.YijiPayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Map;

@Slf4j
public class YijiAdapter extends YIjiBaseAdapter implements PayAdapter {
    private YijiPayClient yijiPayClient;
    private AggregatePayConfig.YijiPayConfig yijiPayConfig;

    @Override
    public boolean support(Object adapter) {

        if(adapter instanceof YijiAdapter){
            yijiPayClient = SpringApplicationContext.getBean(YijiPayClient.class);
            yijiPayConfig = SpringApplicationContext.getBean(AggregatePayConfig.YijiPayConfig.class);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
        VerifyBankCardDto verifyBankCardDto = requestDto.getT();
        Map<String, String> map =super.initPaymentCommonPara(Constants.YijiServiceUrl.VERIFY_BANK_CARD,yijiPayConfig.getPartnerId());
        map.put("outOrderNo",verifyBankCardDto.getOutOrderNo());
        map.put("name",verifyBankCardDto.getName());
        map.put("certNo",verifyBankCardDto.getCertNo());
        map.put("bankCardNo",verifyBankCardDto.getBankCardNo());
        map.put("mobileNo",verifyBankCardDto.getMobileNo());
        map.put("verifyCardType",verifyBankCardDto.getVerifyCardType());

        String responseStr = super.gateWayDoPost(map,yijiPayConfig);
        return this.convert2CommonResponse(responseStr);

    }

    @Override
    public CommonResponse verifyBankCardQuery(AggregateRequestDto<VerifyBankCardQueryDto> requestDto) {
        VerifyBankCardQueryDto verifyBankCardQueryDto = requestDto.getT();
        Map<String, String> map = super.initPaymentCommonPara(Constants.YijiServiceUrl.VERIFY_BANK_CARD_QUERY,yijiPayConfig.getPartnerId());
        map.put("outOrderNo",verifyBankCardQueryDto.getOutOrderNo());
        String responseStr = super.gateWayDoPost(map,yijiPayConfig);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        LoanDto loanDto = requestDto.getT();
        Map<String, String> map =super.initPaymentCommonPara(Constants.YijiServiceUrl.LOAN,yijiPayConfig.getPartnerId());

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

        String responseStr = super.gateWayDoPost(map,yijiPayConfig);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        ApplyCardDto applyCardDto = requestDto.getT();
        String serviceUrl = applyCardDto.getEnums().equals(ApplyChannelEnums.unionpay)?Constants.YijiServiceUrl.UNIONPAY:Constants.YijiServiceUrl.NUCC;
        Map<String, String> map = super.initDeductionCommonPara(serviceUrl);

        map.put("merchOrderNo",applyCardDto.getMerchOrderNo());
        map.put("signAccId",applyCardDto.getSignAccId());
        map.put("signName",applyCardDto.getSignName());
        map.put("signID",applyCardDto.getSignID());
        map.put("signMobile",applyCardDto.getSignMobile());

        String responseStr = super.sdkDoPost(map,yijiPayClient);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        CardAddConfirmDto cardAddConfirmDto = requestDto.getT();
        Map<String, String> map =super.initDeductionCommonPara(Constants.YijiServiceUrl.CARD_ADD_CONFIRM);

        map.put("signNo",cardAddConfirmDto.getSignNo());
        map.put("authMsg",cardAddConfirmDto.getAuthMsg());
        map.put("merchOrderNo",cardAddConfirmDto.getMerchOrderNo());

        String responseStr = super.sdkDoPost(map,yijiPayClient);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        DeleteCardDto deleteCardDto = requestDto.getT();
        Map<String, String> map =super.initDeductionCommonPara(Constants.YijiServiceUrl.CARD_DELETE);
        map.put("signNo",deleteCardDto.getSignNo());
        map.put("merchOrderNo",deleteCardDto.getMerchOrderNo());

        String responseStr = super.sdkDoPost(map,yijiPayClient);
        return this.convert2CommonResponse(responseStr);
    }

    @Override
    public CommonResponse payEntrustPay(AggregateRequestDto<EntrustPayDto> requestDto) {
        EntrustPayDto entrustPayDto = requestDto.getT();
        Map<String, String> map =super.initDeductionCommonPara(Constants.YijiServiceUrl.PAY_ENTRUSTPAY);

        map.put("orderDesc",entrustPayDto.getOrderDesc());
        map.put("bizTp",entrustPayDto.getBizTp());
        map.put("tradeAmount",String.valueOf(entrustPayDto.getTradeAmount().doubleValue()));
        map.put("payeeUserId", ApiSdkConstants.PARTNERID);
        map.put("signNo",entrustPayDto.getSignNo());

        String responseStr = super.sdkDoPost(map,yijiPayClient);

        return this.convert2CommonResponse(responseStr);
    }

    public CommonResponse convert2CommonResponse(String  responseStr){
        CommonResponse commonResponse  = new CommonResponse();
        YijiCommonResponse yijiCommonResponse = JsonUtil.parseObject(responseStr, YijiCommonResponse.class);
        commonResponse.setResultCode(yijiCommonResponse.getResultCode());
        commonResponse.setResultMessage(yijiCommonResponse.getResultMessage());
        commonResponse.setResponseStr(responseStr);
        commonResponse.setFlag( Boolean.valueOf(yijiCommonResponse.getSuccess()));
        return commonResponse;
    }




}
