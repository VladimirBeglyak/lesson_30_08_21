package com.example.lesson_30_08_21.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserDto {
    private String email;
    private String password;
}
