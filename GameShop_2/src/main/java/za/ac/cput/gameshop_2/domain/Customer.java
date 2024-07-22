package za.ac.cput.gameshop_2.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Transaction> transactions;

    public Customer() {
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.customerEmail = builder.customerEmail;
        this.customerPhone = builder.customerPhone;
        this.customerAddress = builder.customerAddress;
        this.transactions = builder.transactions;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Customer setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public Customer setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Customer setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public Customer setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public Customer setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public Customer setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(customerName, customer.customerName) && Objects.equals(customerEmail, customer.customerEmail) && Objects.equals(customerPhone, customer.customerPhone) && Objects.equals(customerAddress, customer.customerAddress) && Objects.equals(transactions, customer.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerEmail, customerPhone, customerAddress, transactions);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId=" + customerId +
//                ", customerName='" + customerName + '\'' +
//                ", customerEmail='" + customerEmail + '\'' +
//                ", customerPhone='" + customerPhone + '\'' +
//                ", customerAddress='" + customerAddress + '\'' +
//                ", transactions=" + transactions +
//                '}';
//    }

    public static class Builder{
        private int customerId;
        private String customerName;
        private String customerEmail;
        private String customerPhone;
        private String customerAddress;
        private List<Transaction> transactions;

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
            return this;
        }

        public Builder setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.customerName = customer.customerName;
            this.customerEmail = customer.customerEmail;
            this.customerPhone = customer.customerPhone;
            this.customerAddress = customer.customerAddress;
            this.transactions = customer.transactions;
            return this;
        }

        public Customer build() {return new Customer(this);}
    }
}
