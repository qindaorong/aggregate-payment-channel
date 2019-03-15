package com.aggregate.framework.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ComponentScan({"com.aggregate.framework.pay","com.yiji.*"})
@ImportResource(locations= {"classpath:spring/yiji-openapi-sdk.xml"})

@Slf4j
public class PayWayConfigure {



}