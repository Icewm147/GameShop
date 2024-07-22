package za.ac.cput.gameshop_2.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;
import za.ac.cput.gameshop_2.util.Helper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TransactionItemFactoryTest {

    @Test
    void createTransactionItem() {
        Transaction transaction = new Transaction.Builder()
                .setTransactionId(1)
                .setCustomerId(1)
                .setSellDate(new Date())
                .setAmount(100.0)
                .build();

        Game game = new Game.Builder()
                .setGameId(1)
                .setTitle("Example Game")
                .setGenre("Action")
                .setPlatform("PC")
                .setPrice(59.99)
                .build();

        TransactionItem transactionItem = TransactionItemFactory.createTransactionItem(1, transaction, game, 2, 119.98);
        assertNotNull(transactionItem);
    }
}