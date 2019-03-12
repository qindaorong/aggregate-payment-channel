package com.aggregate.framework.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:payment_channel.properties")
public class AggregatePayConfig {

    @Data
    @Component(value = "yijiPayConfig")
    @ConfigurationProperties(prefix = "channerls.yiji")
    public static class YijiPayConfig{
        private String url;
        private String partnerId;
        private String privateKey;
        private String keystoreName;
        private String keystorePassword;
        private String publicKeyName;
    }
}
