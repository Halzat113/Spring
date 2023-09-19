package org.example.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("RH")
@Component
public class RegularHours implements HoursRepository {

    @Override
    public int getHours() {
        return 40;
    }
}
