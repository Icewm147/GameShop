package za.ac.cput.gameshop_2.factory;

import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.domain.Transaction;
import za.ac.cput.gameshop_2.domain.TransactionItem;
import za.ac.cput.gameshop_2.util.Helper;

import java.util.Date;
import java.util.List;

public class TransactionFactory {

    public static Transaction createTransaction(int transactionId, Customer customer, Date sellDate, double amount, List<TransactionItem> transactionsItems) {
        if (Helper.isNull(customer) || Helper.isNull(sellDate) || Helper.isNull(transactionsItems) || amount <= 0) {
            throw new IllegalArgumentException("customer,sellDate,transactionsItems, something is null");
        }
        return new Transaction.Builder().setTransactionId(transactionId).setCustomer(customer).setSellDate(sellDate).setTransactionItems(transactionsItems).build();
    }
}
