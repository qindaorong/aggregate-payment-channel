package com.aggregate.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AggregatePayConfig {

    @Data
    @Component(value = "yijiPayConfig")
    @ConfigurationProperties(prefix = "channerls.yiji")
    public static class YijiPayConfig{
        private String url;
        private String partnerId;
        private String privateKey;
    }
}
