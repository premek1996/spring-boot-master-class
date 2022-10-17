package com.example.demo.customer.service;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("it should throw exception when customer with given id not found")
    void test1() {
        when(customerRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> customerService.getCustomer(any(Long.class)))
                .isInstanceOf(NotFoundException.class);

        verify(customerRepository, times(1))
                .findById(any(Long.class));

        verifyNoMoreInteractions(customerRepository);
    }

    @Test
    @DisplayName("it should return found customer")
    void test2() {
        var id = 1L;
        var customer = Customer.builder()
                .id(id)
                .email("email")
                .password("password")
                .build();

        when(customerRepository.findById(id))
                .thenReturn(Optional.of(customer));

        assertThat(customerService.getCustomer(id))
                .usingRecursiveComparison()
                .isEqualTo(customer);

        verify(customerRepository, times(1))
                .findById(id);

        verifyNoMoreInteractions(customerRepository);
    }

}