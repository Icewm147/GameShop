package za.ac.cput.gameshop_2.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.domain.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerFactoryTest {

    @Test
    void createCustomer() {
        Customer customer = CustomerFactory.createCustomer(1, "John Doe", "john.doe@example.com", "1234567890", "123 Main St");
        assertNotNull(customer);
    }

    @Test
    void createCustomerFail(){
        Customer customer = CustomerFactory.createCustomer(1,"Fail Name", "fail@example.com", "", "123 Failure St");
        assertNotNull(customer);
    }
}