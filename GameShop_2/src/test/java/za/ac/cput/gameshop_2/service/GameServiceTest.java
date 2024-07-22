package za.ac.cput.gameshop_2.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.gameshop_2.domain.Game;

import java.util.List;
import java.util.Optional;
import java.util.jar.JarOutputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Test
    @Order(1)
    void save() {
        Game game = new Game.Builder().setTitle("TitleTest").setGenre("GenreTest").setGameCondition("ConditionTest").setPlatform("PlatformTest").setPrice(59.99).build();
        Game savedGame = gameService.save(game);
        assertNotNull(savedGame);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Game> game = gameService.findById(1);
        assertTrue(game.isPresent());
        System.out.println(game);
    }

    @Test
    @Order(3)
    void findAll() {
        List<Game> games = gameService.findAll();
        assertFalse(games.isEmpty());
        System.out.println(games);
    }

    @Test
    @Order(4)
    void deleteById() {
        gameService.deleteById(15);
        Optional<Game> game = gameService.findById(15);
        assertFalse(game.isPresent());
        System.out.println("Game Deleted");
    }
}