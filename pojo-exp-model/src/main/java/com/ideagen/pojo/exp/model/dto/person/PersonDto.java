package com.ideagen.pojo.exp.model.dto.person;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private String name;

    private String fullName;

    private int age;

    private String addressLine1;

    private String addressLine2;

    private String postCode;

    private String city;

    private String state;

    private String country;
}
