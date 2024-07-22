package za.ac.cput.gameshop_2.factory;

import za.ac.cput.gameshop_2.domain.Customer;
import za.ac.cput.gameshop_2.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(int customerId, String customerName, String customerEmail, String customerPhone, String customerAddress) {
        if (Helper.isNullOrEmpty(customerName) || Helper.isNullOrEmpty(customerEmail) || Helper.isNullOrEmpty(customerPhone) || Helper.isNullOrEmpty(customerAddress)) {
            throw new IllegalArgumentException("customerName or customerEmail or customerPhone or customerAddress or Transactions is empty");
        }
        return new Customer.Builder().setCustomerName(customerName).setCustomerEmail(customerEmail).setCustomerPhone(customerPhone).setCustomerAddress(customerAddress).build();
    }
}