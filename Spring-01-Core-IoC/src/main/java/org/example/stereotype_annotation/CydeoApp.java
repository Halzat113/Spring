package org.example.stereotype_annotation;

import org.example.bean_annotation.ConfigAny;
import org.example.bean_annotation.ConfigApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);
        System.out.println(context.getBean(Integer.class));

    }
}
