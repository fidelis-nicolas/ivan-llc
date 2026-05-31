package com.ivanllc.ivanllc.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    private int id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate DOB;
    private int department_id;
    private int role_id;

}

