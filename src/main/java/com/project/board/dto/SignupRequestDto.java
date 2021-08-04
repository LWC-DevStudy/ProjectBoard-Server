package com.project.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    private String userName;
    private String password;
    private String passwordConfirm;

}
