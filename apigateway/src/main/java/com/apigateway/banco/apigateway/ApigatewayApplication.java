package com.apigateway.banco.apigateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	@Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() 
	{
        return factory -> factory.setPort(5000); // Cambia el puerto a 5000
    }
}
