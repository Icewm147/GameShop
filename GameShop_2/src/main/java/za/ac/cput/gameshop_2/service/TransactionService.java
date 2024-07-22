package za.ac.cput.gameshop_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.repository.ITransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements IService <Transaction, Integer> {

    private final ITransactionRepository transactionRepository;

    @Autowired
    public TransactionService(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction entity) {
        return transactionRepository.save(entity);
    }

    @Override
    public Optional<Transaction> findById(Integer integer) {
        return transactionRepository.findById(integer);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        transactionRepository.deleteById(integer);
    }
}
