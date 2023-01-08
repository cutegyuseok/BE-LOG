package com.example.blog.main.dto;

import com.example.blog.main.entity.Login;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {

    private String email;
    private String name;

    public Login toEntity(){
        return Login.builder()
                .email(email)
                .name(name)
                .build();
    }
}
