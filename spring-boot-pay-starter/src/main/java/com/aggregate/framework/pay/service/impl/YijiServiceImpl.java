package com.aggregate.framework.pay.service.impl;

import com.aggregate.framework.pay.bean.AggregateRequestDto;
import com.aggregate.framework.pay.bean.yiji.dto.*;
import com.aggregate.framework.pay.bean.yiji.vo.CommonResponse;
import com.aggregate.framework.pay.config.AggregatePayConfig;
import com.aggregate.framework.pay.enums.yiji.ApplyChannelEnums;
import com.aggregate.framework.pay.framework.yiji.Constants;
import com.aggregate.framework.pay.service.YijiService;
import com.aggregate.framework.pay.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class YijiServiceImpl extends BaseYijiService implements YijiService {


    @Autowired
    AggregatePayConfig.YijiPayConfig yijiPayConfig;

    @PostConstruct
    public void init(){
        super.partnerId = yijiPayConfig.getPartnerId();
        super.privateKey = yijiPayConfig.getPrivateKey();
        super.url = yijiPayConfig.getUrl();
    }

    @Override
    public CommonResponse verifyBankCard(AggregateRequestDto<VerifyBankCardDto> requestDto) {
        VerifyBankCardDto verifyBankCardDto = requestDto.getT();
        Map<String, String> map =super.initCommonPara(Constants.YijiServiceUrl.VERIFY_BANK_CARD);
        map.put("outOrderNo",verifyBankCardDto.getOutOrderNo());
        map.put("name",verifyBankCardDto.getName());
        map.put("certNo",verifyBankCardDto.getCertNo());
        map.put("bankCardNo",verifyBankCardDto.getBankCardNo());
        map.put("mobileNo",verifyBankCardDto.getMobileNo());
        map.put("verifyCardType",verifyBankCardDto.getVerifyCardType());

        String responseStr = super.doPost(map);
        CommonResponse commonResponse = JsonUtil.parseObject(responseStr, CommonResponse.class);
        return commonResponse;

    }

    @Override
    public CommonResponse loan(AggregateRequestDto<LoanDto> requestDto) {
        LoanDto loanDto = requestDto.getT();
        Map<String, String> map =super.initCommonPara(Constants.YijiServiceUrl.LOAN);

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
        CommonResponse commonResponse = JsonUtil.parseObject(responseStr, CommonResponse.class);
        return commonResponse;
    }

    @Override
    public CommonResponse addApplyCard(AggregateRequestDto<ApplyCardDto> requestDto) {
        ApplyCardDto applyCardDto = requestDto.getT();
        String serviceUrl = applyCardDto.getEnums().equals(ApplyChannelEnums.unionpay)?Constants.YijiServiceUrl.UNIONPAY:Constants.YijiServiceUrl.NUCC;
        Map<String, String> map =super.initCommonPara(serviceUrl);

        map.put("signAccId",applyCardDto.getSignAccId());
        map.put("signName",applyCardDto.getSignName());
        map.put("signID",applyCardDto.getSignID());
        map.put("signMobile",applyCardDto.getSignMobile());

        String responseStr = super.doPost(map);
        CommonResponse commonResponse = JsonUtil.parseObject(responseStr, CommonResponse.class);
        return commonResponse;
    }

    @Override
    public CommonResponse cardAddConfirm(AggregateRequestDto<CardAddConfirmDto> requestDto) {
        CardAddConfirmDto cardAddConfirmDto = requestDto.getT();
        Map<String, String> map =super.initCommonPara(Constants.YijiServiceUrl.CARD_ADD_CONFIRM);

        map.put("signNo",cardAddConfirmDto.getSignNo());
        map.put("authMsg",cardAddConfirmDto.getAuthMsg());

        String responseStr = super.doPost(map);
        CommonResponse commonResponse = JsonUtil.parseObject(responseStr, CommonResponse.class);
        return commonResponse;
    }

    @Override
    public CommonResponse cardDelete(AggregateRequestDto<DeleteCardDto> requestDto) {
        DeleteCardDto deleteCardDto = requestDto.getT();
        Map<String, String> map =super.initCommonPara(Constants.YijiServiceUrl.CARD_DELETE);

        map.put("signNo",deleteCardDto.getSignNo());

        String responseStr = super.doPost(map);
        CommonResponse commonResponse = JsonUtil.parseObject(responseStr, CommonResponse.class);
        return commonResponse;
    }

    @Override
    public CommonResponse payEntrustpay(AggregateRequestDto<EntrustPayDto> requestDto) {
        return null;
    }
}
