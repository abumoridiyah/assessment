package com.assesment.assesment.model;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private Address address;
}
