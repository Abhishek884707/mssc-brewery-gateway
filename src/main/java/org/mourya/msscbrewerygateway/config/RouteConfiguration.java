package org.mourya.msscbrewerygateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Profile("google")
@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder){
        log.info("The Path was : ");
       return builder.routes()
               .route("google", r -> r
                       .path("/googlesearch")
                       .filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
                       .uri("https://google.com"))
                       .build();
    }

}
