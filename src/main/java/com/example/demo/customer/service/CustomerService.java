package com.example.demo.customer.service;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository
                .findById(customerId)
                .orElseThrow(() -> {
                            NotFoundException notFoundException = new NotFoundException("Customer with id %d not found".formatted(customerId));
                            log.error(notFoundException.getMessage());
                            return notFoundException;
                        }
                );
    }

}
