package com.airlineSystem.airline.Repositories;

import com.airlineSystem.airline.Entities.Customer;

import com.airlineSystem.airline.Entities.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    private Customer cust1;
    private Customer cust2;

    @BeforeEach

    void InsertRecord() {
        customerRepository.saveAll(List.of(
                new Customer("Agustine Riviera", CustomerStatus.SILVER,115235),
                new Customer ("Alaina Sepulvida",CustomerStatus.NOUN,6008),
                new Customer ("Tom Jones",CustomerStatus.GOLD,205767),
                new Customer  ("Sam Rio",CustomerStatus.NOUN,2653),
                new Customer("Jessica James",CustomerStatus.SILVER,127656),
                new Customer ("Ana Janco",CustomerStatus.SILVER,136773),
                new Customer  ("Jennifer Cortez",CustomerStatus.GOLD,300582),
                new Customer  ("Christian Janco",CustomerStatus.SILVER,14642)
        ));}

    @Test
    void findAll() {
        List<Customer> customers = customerRepository.findAll();
        assertEquals(8, customers.size());
    }

    @Test
    void findByCustomerByName() {
        List<Customer> foundCustomer = customerRepository.findCustomerByCustomerName("Sam Rio");
        assertEquals(1, foundCustomer.size());
        assertEquals("Sam Rio", foundCustomer.get(0).getCustomerName());
    }

    @Test
    void findCustomerByCustomerStatus() {
        CustomerStatus Customerstatus = CustomerStatus.SILVER;
        List<Customer> customers = customerRepository.findCustomerByCustomerStatus(CustomerStatus.SILVER);
        assertEquals(4, customers.size());
        assertEquals(CustomerStatus.SILVER, customers.get(0).getCustomerStatus());
        assertEquals(CustomerStatus.SILVER, customers.get(1).getCustomerStatus());
        assertNotNull(customers, "List of customers can not be empty");
        assertFalse(customers.isEmpty(), "List of customers can not be empty");
        assertTrue(customers.stream().allMatch(customer -> customer.getCustomerStatus() == Customerstatus),
                "You must have status");
    }
    @AfterEach
    public void removeAll() {
        customerRepository.deleteAll();
    }

    }




