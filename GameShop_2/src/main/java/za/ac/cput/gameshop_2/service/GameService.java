package za.ac.cput.gameshop_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.gameshop_2.domain.Game;
import za.ac.cput.gameshop_2.repository.IGameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IService<Game, Integer> {

    private final IGameRepository gameRepository;

    @Autowired
    public GameService(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game save(Game entity) {
        return gameRepository.save(entity);
    }

    @Override
    public Optional<Game> findById(Integer integer) {
        return gameRepository.findById(integer);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        gameRepository.deleteById(integer);
    }
}
