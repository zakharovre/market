package ru.gb.msauth.models.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}