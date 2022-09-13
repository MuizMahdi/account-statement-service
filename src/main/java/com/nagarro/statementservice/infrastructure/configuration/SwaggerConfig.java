package com.nagarro.statementservice.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "X-Auth-Token";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Statement Service API")
                .description("Account Statement Application")
                .version("v0.0.1"))
            .components(new Components()
                .addSecuritySchemes(AUTHORIZATION_HEADER, new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name(AUTHORIZATION_HEADER)))
            .addSecurityItem(new SecurityRequirement().addList(AUTHORIZATION_HEADER));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("statement-service").pathsToMatch("/**").build();
    }
}
