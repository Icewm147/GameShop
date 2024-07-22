package za.ac.cput.gameshop_2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    //@Column(name = "customerId", insertable = false, updatable = false)
    @Column(insertable = false, updatable = false)
    private int customerId;

    private Date sellDate;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<TransactionItem> transactionItems;

    public Transaction() {
    }

    private Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.customerId = builder.customerId;
        this.sellDate = builder.sellDate;
        this.amount = builder.amount;
        this.transactionItems = builder.transactionItems;
        this.customer = builder.customer;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<TransactionItem> getTransactionItems() {
        return transactionItems;
    }

    public Transaction setTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Transaction setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public Transaction setSellDate(Date sellDate) {
        this.sellDate = sellDate;
        return this;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Transaction setTransactionItems(List<TransactionItem> transactionItems) {
        this.transactionItems = transactionItems;
        return this;
    }

    public Transaction setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && customerId == that.customerId && Double.compare(amount, that.amount) == 0 && Objects.equals(sellDate, that.sellDate) && Objects.equals(customer, that.customer) && Objects.equals(transactionItems, that.transactionItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, customerId, sellDate, amount, customer, transactionItems);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customerId=" + (customer != null ? customer.getCustomerId() : "null") +
                ", sellDate=" + sellDate +
                ", amount=" + amount +
                ", transactionItems=" + (transactionItems != null ? transactionItems.size() : "null") +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Transaction{" +
//                "transactionId=" + transactionId +
//                ", customerId=" + customerId +
//                ", sellDate=" + sellDate +
//                ", amount=" + amount +
//                ", customer=" + customer +
//                ", transactionItems=" + transactionItems +
//                '}';
//    }

    public static class Builder{
        private int transactionId;
        private int customerId;
        private Date sellDate;
        private double amount;
        private Customer customer;
        private List<TransactionItem> transactionItems;

        public Builder setTransactionId(int transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setSellDate(Date sellDate) {
            this.sellDate = sellDate;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setTransactionItems(List<TransactionItem> transactionItems) {
            this.transactionItems = transactionItems;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(Transaction transaction) {
            this.transactionId = transaction.transactionId;
            this.customerId = transaction.customerId;
            this.sellDate = transaction.sellDate;
            this.amount = transaction.amount;
            this.transactionItems = transaction.transactionItems;
            this.customer = transaction.customer;
            return this;
        }

        public Transaction build() {return new Transaction(this);}
    }
}
