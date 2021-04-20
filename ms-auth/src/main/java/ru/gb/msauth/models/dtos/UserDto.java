package ru.gb.msauth.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.msauth.models.entities.User;

@Data
@NoArgsConstructor
public class UserDto {
    private int id;
    private String userName;

    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
    }
}
