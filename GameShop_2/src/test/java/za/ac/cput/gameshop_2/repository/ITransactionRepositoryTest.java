package za.ac.cput.gameshop_2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.domain.Transaction;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ITransactionRepositoryTest {

    @Autowired
    ITransactionRepository transactionRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @Test
    void testFindById(){
        // Assuming a customer with ID '1' already exists
        Optional<Customer> customerOptional = customerRepository.findById(1);
        assertTrue(customerOptional.isPresent());

        Customer customer = customerOptional.get();

        Transaction transaction = new Transaction.Builder()
                .setCustomer(customer)
                .setSellDate(new Date())
                .setAmount(99.99)
                .build();

        transactionRepository.save(transaction);

        Optional<Transaction> retrievedTransaction = transactionRepository.findById(transaction.getTransactionId());
        assertTrue(retrievedTransaction.isPresent());
    }
}