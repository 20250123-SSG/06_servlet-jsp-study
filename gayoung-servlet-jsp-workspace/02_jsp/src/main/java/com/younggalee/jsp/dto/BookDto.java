package com.younggalee.jsp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookDto {
    private int no;
    private String title;
    private String author;
}
