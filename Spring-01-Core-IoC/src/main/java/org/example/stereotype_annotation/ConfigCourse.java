package org.example.stereotype_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "org.example")
public class ConfigCourse {
    @Bean
    Integer number(){
        return 100;
    }

}
