package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtxWithPrototype {
	
	@Bean
	@Scope("prototype")
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
}
