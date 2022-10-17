package com.example.demo.customer.controller.dto;

import com.example.demo.customer.model.Customer;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerResponse {

    private final Long id;
    private final String name;
    private final String email;

    public static CustomerResponse of(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }

}
