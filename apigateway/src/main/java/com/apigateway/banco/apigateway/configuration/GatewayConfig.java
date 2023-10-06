package com.apigateway.banco.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig 
{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) 
    {
        return builder.routes()
            .route("cliente_route", r -> r.path("/clientes/**")
                .uri("http://localhost:8080"))
            .route("cuenta_route", r -> r.path("/cuentas/**")
                .uri("http://localhost:8081"))
            .route("productocredito_route", r -> r.path("/productoscredito/**")
                .uri("http://localhost:8082"))
            .route("tarjetacredito_route", r -> r.path("/tarjetascredito/**")
                .uri("http://localhost:8083"))
            .route("titularfirmante_route", r -> r.path("/titularesfirmantes/**")
                .uri("http://localhost:8084"))
            .build();
    }
}