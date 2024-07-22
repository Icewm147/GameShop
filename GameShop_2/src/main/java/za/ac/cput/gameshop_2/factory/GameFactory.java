package za.ac.cput.gameshop_2.factory;

import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.util.Helper;

public class GameFactory {

    public static Game createGame(int gameId, String title, String genre, String platform, String gameCondition, double price) {
        if (Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(genre) || Helper.isNullOrEmpty(platform) || Helper.isNullOrEmpty(gameCondition) || price <= 0) {
            throw new IllegalArgumentException("All fields must be provided and valid.");
        }

        return new Game.Builder()
                .setGameId(gameId)
                .setTitle(title)
                .setGenre(genre)
                .setPlatform(platform)
                .setGameCondition(gameCondition)
                .setPrice(price)
                .build();
    }
}

