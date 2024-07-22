package za.ac.cput.gameshop_2.service;

import java.util.List;
import java.util.Optional;

public interface IService <T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
