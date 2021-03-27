package com.gsas.storemarket.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gsas.storemarket.web.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiEndPointInfo(){
        return new ApiInfoBuilder().title("API de productos de minimarket")
                .description("Servicios para la consulta de productos de minimarket")
                .license("MTI v2.0 - TheGsas")
                .version("1.0.0.1")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
}
