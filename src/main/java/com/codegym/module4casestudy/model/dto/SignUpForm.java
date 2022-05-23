package com.codegym.module4casestudy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String dateOfBirth;
    private String address;

}
