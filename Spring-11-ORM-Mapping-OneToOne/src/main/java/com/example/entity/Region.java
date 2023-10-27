package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@Data
@Table(name = "regions")
public class Region extends BaseEntity{

    private String division;
    private String country;

    @OneToOne(mappedBy = "region")
    private Employee employee;

    public Region(String division, String country) {
        this.division = division;
        this.country = country;
    }
}
