package za.ac.cput.gameshop_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.gameshop_2.domain.Game;

@Repository
public interface IGameRepository extends JpaRepository<Game, Integer> {
}
