package com.example.demo.customer.controller.dto;

import com.example.demo.customer.model.Customer;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ToString
@Setter
public class CreateCustomerRequest {

    @NotBlank(message = "name must be not empty")
    private String name;

    @NotBlank(message = "password must be not empty")
    private String password;

    @NotBlank(message = "email must be not empty")
    @Email
    private String email;

    public Customer toCustomer() {
        return Customer.builder()
                .name(name)
                .password(password)
                .email(email)
                .build();
    }

}
