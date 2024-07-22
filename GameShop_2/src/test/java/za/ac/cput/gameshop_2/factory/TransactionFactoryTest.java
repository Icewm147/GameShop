package za.ac.cput.gameshop_2.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionFactoryTest {

    @Test
    void createTransaction() {
        Customer customer = new Customer();
        List<TransactionItem> transactionItems = new ArrayList<>();
        Transaction transaction = TransactionFactory.createTransaction(1, customer, new Date(), 100.0, transactionItems);

        assertNotNull(transaction);
    }
}