package za.ac.cput.gameshop_2.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.domain.TransactionItem;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private GameService gameService;

    private int savedCustomerId;
    private int savedGameId;
    private int savedTransactionId;

    @BeforeEach
    void setUp() {
        // Creating and saving a Customer
        Customer customer = new Customer.Builder()
                .setCustomerName("Erwin Rommel")
                .setCustomerEmail("rommel@desertfox")
                .setCustomerPhone("999999999")
                .setCustomerAddress("147 Reich rd")
                .build();
        Customer savedCustomer = customerService.save(customer);
        savedCustomerId = savedCustomer.getCustomerId();

        // Creating and saving a Game
        Game game = new Game.Builder()
                .setTitle("ExampleTitle")
                .setGenre("ExampleGenre")
                .setPlatform("ExampleGenre")
                .setGameCondition("ExampleCondition")
                .setPrice(59.99)
                .build();
        Game savedGame = gameService.save(game);
        savedGameId = savedGame.getGameId();

        // Creating a Transaction
        Transaction transaction = new Transaction.Builder()
                .setCustomer(savedCustomer)
                .setSellDate(new Date())
                .setAmount(59.99)
                .build();

        // Creating and adding TransactionItem to the Transaction
        TransactionItem transactionItem = new TransactionItem.Builder()
                .setTransaction(transaction)
                .setGame(savedGame)
                .setQuantity(2)
                .setPrice(119.98)
                .build();
        transaction.setTransactionItems(List.of(transactionItem));

        // Saving the Transaction
        Transaction savedTransaction = transactionService.save(transaction);
        savedTransactionId = savedTransaction.getTransactionId();
    }

    @Test
    @Order(1)
    void save() {
        Transaction transaction = transactionService.findById(savedTransactionId).orElse(null);
        assertNotNull(transaction);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Transaction> foundTransaction = transactionService.findById(savedTransactionId);
        assertTrue(foundTransaction.isPresent());
    }

    @Test
    @Order(3)
    void findAll() {
        List<Transaction> transactions = transactionService.findAll();
        assertFalse(transactions.isEmpty());
    }

    @Test
    @Order(4)
    @Transactional
    void deleteById() {
        transactionService.deleteById(savedTransactionId);
        Optional<Transaction> foundTransaction = transactionService.findById(savedTransactionId);
        assertFalse(foundTransaction.isPresent());
    }
}