package org.example.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    private Long id;
    private String name;
    private String country;
    private int publishedYear;
    private int price;
    private Long author;
//    private Author author;
}
