package com.store.Service;

import com.store.Beans.Company;
import com.store.Beans.Product;
import com.store.Repository.ProductRepository;
import com.store.Exception.ProductException;
import com.store.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BackOfficeService{
    private int companyID;

    private final CompanyRepository companyRepository;

    private final ProductRepository productRepository;

    public boolean addProduct(Product product) throws ProductException {
        if (productRepository.existsByCompanyIDAndTitle(product.getCompanyID(), product.getTitle())) {
            throw new ProductException("A product with that title already exists at the company");
        }else {
            product.setCompanyID(companyID);
            productRepository.save(product);
            Company company = companyRepository.getOne(companyID);
            company.getProducts().add(product);
        }
        return true;
    }

    public boolean deleteProduct(int productID) throws ProductException {
        if (!productRepository.existsById(productID)) {
            throw new ProductException("Product not found");
        }
        else if (productRepository.findById(productID).getCompanyID() != this.companyID) {
            productRepository.deleteCompanyProductsByProductID(productID);
            return true;
        }
        return false;

    }

}
