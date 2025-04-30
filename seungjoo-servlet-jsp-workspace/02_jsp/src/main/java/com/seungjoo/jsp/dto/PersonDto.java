package com.seungjoo.jsp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PersonDto {
    private String name;
    private int age;
    private String gender;
}