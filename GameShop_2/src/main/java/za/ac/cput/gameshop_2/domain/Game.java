package za.ac.cput.gameshop_2.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;
    private String gameCondition; // Changed from 'condition' to 'gameCondition'
    private String genre;
    private String platform;
    private double price;
    private String title;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<TransactionItem> transactionItems;

    public Game() {
    }

    private Game(Builder builder) {
        this.gameId = builder.gameId;
        this.gameCondition = builder.gameCondition; // Changed from 'condition' to 'gameCondition'
        this.genre = builder.genre;
        this.platform = builder.platform;
        this.price = builder.price;
        this.title = builder.title;
        this.transactionItems = builder.transactionItems;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameCondition() {
        return gameCondition;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public List<TransactionItem> getTransactionItems() {
        return transactionItems;
    }

    public Game setGameId(int gameId) {
        this.gameId = gameId;
        return this;
    }

    public Game setGameCondition(String gameCondition) { // Changed from 'condition' to 'gameCondition'
        this.gameCondition = gameCondition;
        return this;
    }

    public Game setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Game setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public Game setPrice(double price) {
        this.price = price;
        return this;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public Game setTransactionItems(List<TransactionItem> transactionItems) {
        this.transactionItems = transactionItems;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                Double.compare(game.price, price) == 0 &&
                Objects.equals(gameCondition, game.gameCondition) && // Changed from 'condition' to 'gameCondition'
                Objects.equals(genre, game.genre) &&
                Objects.equals(platform, game.platform) &&
                Objects.equals(title, game.title) &&
                Objects.equals(transactionItems, game.transactionItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameCondition, genre, platform, price, title, transactionItems); // Changed from 'condition' to 'gameCondition'
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameCondition='" + gameCondition + '\'' + // Changed from 'condition' to 'gameCondition'
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", transactionItems=" + transactionItems +
                '}';
    }

    public static class Builder {
        private int gameId;
        private String gameCondition; // Changed from 'condition' to 'gameCondition'
        private String genre;
        private String platform;
        private double price;
        private String title;
        private List<TransactionItem> transactionItems;

        public Builder setGameId(int gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder setGameCondition(String gameCondition) { // Changed from 'condition' to 'gameCondition'
            this.gameCondition = gameCondition;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTransactionItems(List<TransactionItem> transactionItems) {
            this.transactionItems = transactionItems;
            return this;
        }

        public Builder copy(Game game) {
            this.gameId = game.gameId;
            this.gameCondition = game.gameCondition; // Changed from 'condition' to 'gameCondition'
            this.genre = game.genre;
            this.platform = game.platform;
            this.price = game.price;
            this.title = game.title;
            this.transactionItems = game.transactionItems;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
