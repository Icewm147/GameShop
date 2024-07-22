package za.ac.cput.gameshop_2.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.gameshop_2.domain.Customer;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @Order(1)
    void save() {
        Customer customer = new Customer.Builder().setCustomerName("Richard").setCustomerEmail("TestEmail@Mail.com").setCustomerPhone("1234567890").setCustomerAddress("123 Fake Street").build();
        Customer savedCustomer = customerService.save(customer);
        assertNotNull(savedCustomer);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Customer> customer = customerService.findById(25);
        assertTrue(customer.isPresent());
        System.out.println(customer);
    }

    @Test
    @Order(3)
    void findAll() {
        List<Customer> customers = customerService.findAll();
        assertFalse(customers.isEmpty());
        System.out.println(customers);
    }

    @Test
    @Order(4)
    void deleteById() {
        customerService.deleteById(13);
        Optional<Customer> customer = customerService.findById(13);
        assertFalse(customer.isPresent());
        System.out.println("Customer has been Deleted");
    }
}