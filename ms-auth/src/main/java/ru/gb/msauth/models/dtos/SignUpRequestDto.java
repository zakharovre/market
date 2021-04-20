package ru.gb.msauth.models.dtos;

import lombok.Data;

@Data
public class SignUpRequestDto {

    private String username;

    private String password;
}
