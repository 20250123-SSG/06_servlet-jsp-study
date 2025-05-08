package com.kyungbae.jsp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDto {
    private int no;
    private String title;
    private String author;
}

