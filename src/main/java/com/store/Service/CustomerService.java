package com.store.Service;

import com.store.Beans.Product;
import com.store.Repository.ProductRepository;
import com.store.Beans.Customer;
import com.store.Exception.CustomerException;
import com.store.Exception.ProductException;
import com.store.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService{
    private int customerID;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public List<Product> getAllCustomerProducts() throws CustomerException {
        Customer customer=customerRepository.getOne(customerID);
        if(customer.getProducts().isEmpty())
        {
            throw new CustomerException("No product were purchased by this customer");
        }
        return customer.getProducts();
    }

    public boolean purchaseProduct(Product product) throws ProductException {
        if (!(product.getAmount() > 0)) {
            throw new ProductException("The product " + product.getTitle() + " is unavailable- There are no products left at stock.");
        }
        Customer customer = customerRepository.getOne(customerID);
        List<Product> products = customer.getProducts();
        product.setAmount(product.getAmount() - 1);
        productRepository.saveAndFlush(product);
        products.add(product);
        customer.setProducts(products);
        customerRepository.saveAndFlush(customer);
        return true;
    }


    public Customer getCustomerDetails() throws CustomerException {
        return customerRepository.findById(customerID);
    }

}
