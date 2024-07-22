package za.ac.cput.gameshop_2.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameFactoryTest {

    @Test
    void createGame() {
        Transaction transaction = new Transaction();
        Game game = new Game();
        TransactionItem transactionItem = TransactionItemFactory.createTransactionItem(1, transaction, game, 2, 50.0);

        assertNotNull(transactionItem);
    }
}