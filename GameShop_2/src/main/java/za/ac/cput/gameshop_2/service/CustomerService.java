package za.ac.cput.gameshop_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.repository.ICustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements IService<Customer, Integer> {

    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return customerRepository.findById(integer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        customerRepository.deleteById(integer);
    }
}