package com.aggregate.framework.config;

import com.aggregate.framework.pay.config.AggregatePayConfig;
import com.yiji.openapi.sdk.ApiSdkConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
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


    @Autowired
    private Environment env;



    @Override
    public void run(String... args) throws Exception {
        String activeProfile = env.getProperty("spring.profiles.active");
        log.debug("[activeProfile] is {}", activeProfile);
        log.debug("[ApiSdkConstants][PARTNERID] is {}", ApiSdkConstants.PARTNERID);
        log.debug("[ApiSdkConstants][SECRETKEY] is {}", ApiSdkConstants.SECRETKEY);
    }
}
