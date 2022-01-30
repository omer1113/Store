package com.store.Repository;

import com.store.Beans.Company;
import com.store.Beans.Customer;
import com.store.Beans.Product;
import com.store.Exception.CustomerException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findById(int companyID);
    Product getOneProduct(Product product);
    List<Product> findByName(String name);
    List<Customer> getAllCustomers() throws CustomerException;



}
