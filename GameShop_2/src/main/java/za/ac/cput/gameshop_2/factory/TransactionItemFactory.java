package za.ac.cput.gameshop_2.factory;

import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;
import za.ac.cput.gameshop_2.util.Helper;

public class TransactionItemFactory {

    public static TransactionItem createTransactionItem(int transactionItemId, Transaction transaction, Game game, int quantity, double price) {
        if (Helper.isNull(game) || Helper.isNull(transaction) || quantity <= 0 || price <= 0) {
            throw new IllegalArgumentException("Game, transaction, quantity, or price is invalid");
        }

        return new TransactionItem.Builder()
                .setTransactionItemId(transactionItemId)
                .setTransaction(transaction)
                .setGame(game)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}

