package za.ac.cput.gameshop_2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Customer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ICustomerRepositoryTest {

    @Autowired
    ICustomerRepository customerRepository;

    @Test
    void testFindById() {
        Customer customer = new Customer.Builder().setCustomerName("Jane Doe").setCustomerEmail("Jane.Doe@example.com").setCustomerPhone("123456789").setCustomerAddress("123 Main Test Rd").build();
        customerRepository.save(customer);
        Optional<Customer> retrievedCustomer = customerRepository.findById(customer.getCustomerId());
        assertTrue(retrievedCustomer.isPresent());
    }
}