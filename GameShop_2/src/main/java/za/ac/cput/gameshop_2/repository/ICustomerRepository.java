package za.ac.cput.gameshop_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.gameshop_2.domain.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    void findCustomerById(Integer id);
}
