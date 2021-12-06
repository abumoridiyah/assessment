package com.assesment.assesment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Users {
    @Id
    private String id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private Address address;
}
