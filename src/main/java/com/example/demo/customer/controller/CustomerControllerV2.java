package com.example.demo.customer.controller;

import com.example.demo.customer.controller.dto.CreateCustomerRequest;
import com.example.demo.customer.controller.dto.CustomerResponse;
import com.example.demo.customer.model.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.exception.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${customers-api-v2-uri}")
@RequiredArgsConstructor
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @GetMapping
    List<CustomerResponse> getCustomers() {
        return customerService.getCustomers()
                .stream()
                .map(CustomerResponse::of)
                .toList();
    }

    @GetMapping("{id}")
    CustomerResponse getCustomer(@PathVariable Long id) {
        return CustomerResponse.of(customerService.getCustomer(id));
    }

    @GetMapping("{id}/exception")
    CustomerResponse getCustomerException(@PathVariable Long id) {
        throw new ApiRequestException("ApiRequestException for customer %d".formatted(id));
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        System.out.println("POST REQUEST...");
        System.out.println(createCustomerRequest);
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
