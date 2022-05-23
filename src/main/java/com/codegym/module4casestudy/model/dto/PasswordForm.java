package com.codegym.module4casestudy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordForm {
    @NotEmpty
    @Size(min = 5, max = 12)
    private String password;

    @NotEmpty
    @Size(min = 5, max = 12)
    private String confirmPassword;
}
