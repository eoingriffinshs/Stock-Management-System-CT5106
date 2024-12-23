package com.ct5106.StockManagementSystem;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenApiConfig
{
	@Bean
	public OpenAPI stockManagemtnOpenAPI()
	{
		return (new OpenAPI()).info((new Info()).title("Stock REST API").description("My stock").version("1.0"));
	}
}
