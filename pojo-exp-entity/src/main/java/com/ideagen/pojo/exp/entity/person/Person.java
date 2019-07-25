package com.ideagen.pojo.exp.entity.person;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private long id;

    private String name;

    private String fullName;

    private int age;

    private Address address;
}
