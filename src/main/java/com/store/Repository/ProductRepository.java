package com.store.Repository;

import com.store.Beans.Product;
import com.store.Exception.CustomerException;
import com.store.Exception.ProductException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Boolean existsById(int productID);
    Product findById(int ProductID);
    List<Product> findByCompanyID(int companyID);
    List<Product> findByCustomerID(int customerID);
    boolean existsByCompanyIDAndTitle(int companyID, String title);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `store`.`company_product` WHERE product_id=:productID", nativeQuery = true)
    void deleteCompanyProductsByCompanyID(int companyID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `store`.`company_product` WHERE product_id=:productID", nativeQuery = true)
    void deleteCompanyProductsByProductID(int ProductID) throws ProductException;
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `store`.`customer_product` WHERE product_id=:productID", nativeQuery = true)
    void deleteCustomerProductsByProductID(int ProductID) throws CustomerException;
}

