package com.example.lesson_30_08_21.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String email;
    private String password;
    private Integer role;
}
