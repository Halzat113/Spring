package org.example;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Java {
    //Field Injection
//    @Autowired
//    OfficeHours officeHours;

    OfficeHours officeHours;

    //Construction Injection
    //this works when we have only one constructor
    //@Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("weekly teaching hours : "+(20 + officeHours.getHours()));
    }
}
