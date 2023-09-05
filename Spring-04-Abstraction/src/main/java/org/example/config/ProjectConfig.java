package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.example")
@ComponentScan(basePackages = {"org.example.proxy","org.example.repository","org.example.service"})
public class ProjectConfig {
}

