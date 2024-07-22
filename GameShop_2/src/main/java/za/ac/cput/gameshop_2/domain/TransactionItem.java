package za.ac.cput.gameshop_2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class TransactionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionItemId;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "transactionId", nullable = false)
    @JsonBackReference
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "gameId")
    private Game game;

    public TransactionItem() {
    }

    private TransactionItem(Builder builder) {
        this.transactionItemId = builder.transactionItemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.transaction = builder.transaction;
        this.game = builder.game;
    }

    public int getTransactionItemId() {
        return transactionItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Game getGame() {
        return game;
    }

    public TransactionItem setTransactionItemId(int transactionItemId) {
        this.transactionItemId = transactionItemId;
        return this;
    }

    public TransactionItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public TransactionItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public TransactionItem setTransaction(Transaction transaction) {
        this.transaction = transaction;
        return this;
    }

    public TransactionItem setGame(Game game) {
        this.game = game;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionItem that = (TransactionItem) o;
        return transactionItemId == that.transactionItemId &&
                quantity == that.quantity &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(transaction, that.transaction) &&
                Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionItemId, quantity, price, transaction, game);
    }

    @Override
    public String toString() {
        return "TransactionItem{" +
                "transactionItemId=" + transactionItemId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", transaction=" + transaction +
                ", game=" + game +
                '}';
    }

    public static class Builder {
        private int transactionItemId;
        private int quantity;
        private double price;
        private Transaction transaction;
        private Game game;

        public Builder setTransactionItemId(int transactionItemId) {
            this.transactionItemId = transactionItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setTransaction(Transaction transaction) {
            this.transaction = transaction;
            return this;
        }

        public Builder setGame(Game game) {
            this.game = game;
            return this;
        }

        public Builder copy(TransactionItem transactionItem) {
            this.transactionItemId = transactionItem.transactionItemId;
            this.quantity = transactionItem.quantity;
            this.price = transactionItem.price;
            this.transaction = transactionItem.transaction;
            this.game = transactionItem.game;
            return this;
        }

        public TransactionItem build() {
            return new TransactionItem(this);
        }
    }
}
