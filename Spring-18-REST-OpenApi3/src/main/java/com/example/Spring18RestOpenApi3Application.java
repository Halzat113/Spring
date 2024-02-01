package com.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Spring18RestOpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring18RestOpenApi3Application.class, args);
    }

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                //.servers(Arrays.asList(new Server().url("https://dev.cinema.com")))
                .info(new Info().title("Cinema Application OpenAPI").version("v1").description("Cinema application API documentation"));
    }

}
