package com.ideagen.pojo.exp.entity.person;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String addressLine1;

    private String addressLine2;

    private String postCode;

    private String city;

    private String state;

    private String country;
}
