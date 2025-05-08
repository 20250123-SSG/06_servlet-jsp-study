package com.kyungbae.jsp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PersonDto {
    private String name;
    private int age;
    private String gender;
}
