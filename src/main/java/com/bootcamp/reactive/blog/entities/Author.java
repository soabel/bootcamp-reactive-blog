package com.bootcamp.reactive.blog.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(value="authors")
public class Author {
    @Id
    private String id;
    private String email;
    private String phone;
    private Date birthDate;
}
