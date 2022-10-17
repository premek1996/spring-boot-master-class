package com.example.demo.customer.controller;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${customers-api-v1-uri}")
@Deprecated
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("all")
    List<Customer> getCustomers() {
        return List.of(Customer.builder()
                        .id(1L)
                        .name("v1")
                        .password("123")
                        .build(),
                Customer.builder()
                        .id(2L)
                        .name("v1")
                        .password("456")
                        .build());
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }


    @DeleteMapping("{id}")
    void deleteCustomer(@PathVariable Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }

}
