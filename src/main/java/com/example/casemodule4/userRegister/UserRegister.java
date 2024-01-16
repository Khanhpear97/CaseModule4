package com.example.casemodule4.userRegister;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {

    private Long id;

    @Column(name = "username")
    @NotEmpty(message = "Username should not be empty")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Max(value = 100, message = "Your age cannot be more than 100 years old")
    @Min(value = 18, message = "Your age must not be less than 18 years old")
    private Long age;

    @NotEmpty(message = "Phone number should not be empty")
    private String phone;

}
