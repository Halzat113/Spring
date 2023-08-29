package org.example;

import org.example.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }


//    Direct wiring
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car());
//        return p;
//    }

    //Autowiring
    @Bean
    org.example.Person person(Car car){
        org.example.Person p =new org.example.Person();
        p.setName("Mike");
        p.setCar(car);
        return p;
    }
}
