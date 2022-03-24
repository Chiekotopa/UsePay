package com.usePay.com;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "UseAnPay API", version = "1.0", description = "UseAnPay Information"))

public class UseAndPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UseAndPayApplication.class, args);
              
                
                
	}
        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
        }

}
