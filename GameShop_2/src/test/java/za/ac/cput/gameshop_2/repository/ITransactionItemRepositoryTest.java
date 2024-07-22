package za.ac.cput.gameshop_2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ITransactionItemRepositoryTest {

    @Autowired
    ITransactionItemRepository repository;

    @Autowired
    IGameRepository gameRepository;

    @Autowired
    ITransactionRepository transactionRepository;

    @Test
    void testFindById() {
        // Fetch existing game
        Optional<Game> optionalGame = gameRepository.findById(1);
        assertTrue(optionalGame.isPresent(), "Game with ID 1 should exist");

        Game game = optionalGame.get();

        // Fetch existing transaction
        Optional<Transaction> optionalTransaction = transactionRepository.findById(1);
        assertTrue(optionalTransaction.isPresent(), "Transaction with ID 1 should exist");

        Transaction transaction = optionalTransaction.get();

        // Create new transaction item using existing game and transaction
        TransactionItem transactionItem = new TransactionItem.Builder()
                .setGame(game)
                .setTransaction(transaction)
                .setPrice(59.99)
                .setQuantity(1)
                .build();

        repository.save(transactionItem);
        Optional<TransactionItem> retrievedTransactionItem = repository.findById(transactionItem.getTransactionItemId());
        assertTrue(retrievedTransactionItem.isPresent());
    }
}