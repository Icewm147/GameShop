package za.ac.cput.gameshop_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.gameshop_2.domain.TransactionItem;
import za.ac.cput.gameshop_2.repository.ITransactionItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionItemService implements IService< TransactionItem, Integer> {


    private final ITransactionItemRepository transactionItemRepository;

    @Autowired
    public TransactionItemService(ITransactionItemRepository transactionsItemRepository) {
        this.transactionItemRepository = transactionsItemRepository;
    }

    @Override
    public TransactionItem save(TransactionItem entity) {
        return transactionItemRepository.save(entity);
    }

    @Override
    public Optional<TransactionItem> findById(Integer integer) {
        return transactionItemRepository.findById(integer);
    }

    @Override
    public List<TransactionItem> findAll() {
        return transactionItemRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        transactionItemRepository.deleteById(integer);
    }
}
