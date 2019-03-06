package com.aggregate.framework.config;

import com.aggregate.framework.pay.config.AggregatePayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @auther: qindaorong
 * @Date: 2018/8/22 11:23
 * @Description:
 */
@Component
@Slf4j
public class DemoCommandLineRunner implements CommandLineRunner {


    @Autowired
    AggregatePayConfig.YijiPayConfig yijiPayConfig;

    @Override
    public void run(String... args) throws Exception {
        log.debug("[yijiPayConfig] init over! PartnerId:{}", yijiPayConfig.getPartnerId());
    }
}
