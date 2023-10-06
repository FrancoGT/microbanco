package com.mcvs.productocredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductocreditoServiceApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(ProductocreditoServiceApplication.class, args);
	}
	@Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() 
	{
        return factory -> factory.setPort(8082); // Cambia el puerto a 8082
    }
}
