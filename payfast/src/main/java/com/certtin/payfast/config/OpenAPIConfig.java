/**
 * 
 */
package com.certtin.payfast.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Payfast API", version = "v1"))
//@SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//)
public class OpenAPIConfig {
}