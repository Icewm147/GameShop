package za.ac.cput.gameshop_2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Game;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IGameRepositoryTest {

    @Autowired
    IGameRepository gameRepository;

    @Test
    void testFindById() {
        Game game = new Game.Builder()
                .setTitle("TitleTest")
                .setGenre("GenreTest")
                .setPlatform("PlatformTest")
                .setPrice(59.99)
                .setGameCondition("ConditionTest")
                .build();

        gameRepository.save(game);
        Optional<Game> retrieveGame = gameRepository.findById(game.getGameId());
        assertTrue(retrieveGame.isPresent());
    }
}