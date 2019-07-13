package com.libi.demo.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-11 22:03
 */
@Configuration
public class SwaggerConfig {
    /**
     * 创建基本的swagger配置
     * @param apiInfo
     * @return
     */
    @Bean
    public Docket docket(ApiInfo apiInfo) {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //设置全局的token变量，在每一个接口里都会实现
        tokenPar
                .name("token")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                //加入一个需要的前置参数
                .globalOperationParameters(pars)
                .select()
                //扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.libi.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    /**
     * 创建一个api信息
     * @return
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api的标题
                .title("swagger测试")
                //描述
                .description("这是一个测试swagger，jwt和jpa的Demo")
                .version("0.1")
                .build();
    }
}
