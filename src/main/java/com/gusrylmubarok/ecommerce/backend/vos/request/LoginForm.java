package com.gusrylmubarok.ecommerce.backend.vos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
