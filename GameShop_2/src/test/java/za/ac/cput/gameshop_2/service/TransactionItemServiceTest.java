package za.ac.cput.gameshop_2.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionItemServiceTest {

    @Autowired
    private TransactionItemService transactionItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private GameService gameService;

    private int savedTransactionItemId;
    private int savedCustomerId;
    private int savedTransactionId;
    private int savedGameId;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer.Builder()
                .setCustomerName("Erwin Rommel")
                .setCustomerEmail("rommel@desertfox")
                .setCustomerPhone("999999999")
                .setCustomerAddress("147 Reich rd")
                .build();
        Customer savedCustomer = customerService.save(customer);
        savedCustomerId = savedCustomer.getCustomerId();

        Transaction transaction= new Transaction.Builder()
                .setCustomer(customer)
                .setSellDate(new Date())
                .setAmount(59.99)
                .build();
        Transaction savedTransaction = transactionService.save(transaction);
        savedTransactionId = savedTransaction.getTransactionId();

        Game game = new Game.Builder()
                .setTitle("ExampleTitle")
                .setGenre("ExampleGenre")
                .setPlatform("ExampleGenre")
                .setGameCondition("ExampleCondition")
                .setPrice(59.99)
                .build();
        Game savedGame = gameService.save(game);
        savedGameId = savedGame.getGameId();

        TransactionItem transactionItem = new TransactionItem.Builder()
                .setTransaction(transaction)
                .setGame(game)
                .setQuantity(2)
                .setPrice(119.98)
                .build();
        TransactionItem savedTransactionItem = transactionItemService.save(transactionItem);
        savedTransactionItemId = savedTransactionItem.getTransactionItemId();
    }

    @Test
    @Order(1)
    void save() {
//        Transaction transaction = transactionService.findAll().getFirst();
//        Game game = gameService.findAll().getFirst();
//
//        TransactionItem transactionItem = new TransactionItem.Builder()
//                .setTransaction(transaction)
//                .setGame(game)
//                .setQuantity(2)
//                .setPrice(119.98)
//                .build();
//
//        TransactionItem savedTransactionItem = transactionItemService.save(transactionItem);
        TransactionItem transactionItem = transactionItemService.findById(savedTransactionItemId).orElse(null);
        assertNotNull(transactionItem);
        assertEquals(2, transactionItem.getQuantity());
    }

    @Test
    @Order(2)
    void findById() {
        TransactionItem transactionItem = transactionItemService.findAll().getFirst();
        Optional<TransactionItem> foundTransactionItem = transactionItemService.findById(transactionItem.getTransactionItemId());
        assertTrue(foundTransactionItem.isPresent());
        //System.out.println(foundTransactionItem); <---------Stack overflow, toString() is the issue, change fetch to EAGER
    }

    @Test
    @Order(3)
    void findAll() {
        List<TransactionItem> transactionItems = transactionItemService.findAll();
        assertFalse(transactionItems.isEmpty());
    }

    @Test
    @Order(4)
    @Transactional
    void deleteById() {
        transactionItemService.deleteById(savedTransactionItemId);
        Optional<TransactionItem> foundTransactionItem = transactionItemService.findById(savedTransactionItemId);
        assertFalse(foundTransactionItem.isPresent());
    }
}