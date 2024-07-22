package za.ac.cput.gameshop_2.service;

import za.ac.cput.gameshop_2.domain.Customer;

import java.util.List;

public interface ICustomerService<C, I extends Number> extends IService<Customer, Integer> { //<<--------------------------------- what is this <C, I extends Number> ???
    List<Customer> findAlls();
}
