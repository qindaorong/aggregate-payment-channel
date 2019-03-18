package com.aggregate.framework.pay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig implements EnvironmentAware {

    private static final String ENV_PROFILE = "aggregate.swagger.";
    private RelaxedPropertyResolver propertyResolver;

    private static boolean enable = true;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(propertyResolver.getProperty("package")))
                .paths(PathSelectors.any())
                .build().enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(propertyResolver.getProperty("title"))
                .description(propertyResolver.getProperty("description"))
                .version(propertyResolver.getProperty("version"))
                .build();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_PROFILE);
    }
}