package org.example.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class,ConfigAny.class);
        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();
        String str = container.getBean(String.class);
        System.out.println(str);

        //PartTimeMentor pm = container.getBean("p1",PartTimeMentor.class);
        PartTimeMentor pm = container.getBean(PartTimeMentor.class);
        pm.createAccount();
    }
}
