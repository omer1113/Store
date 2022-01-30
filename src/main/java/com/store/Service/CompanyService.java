package com.store.Service;

import com.store.Beans.Company;
import com.store.Beans.Product;
import com.store.Repository.ProductRepository;
import com.store.Exception.CompanyException;
import com.store.Exception.ProductException;
import com.store.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService{
    private int companyID;

    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;


    public boolean updateCompany(Company company) throws CompanyException {
     /*   if (!companyRepository.existsById(company.getId())) {
            throw new CompanyException("Company not found.");
        }*/
        companyRepository.saveAndFlush(company);
        return true;
    }

    public boolean addProduct(Product product) throws ProductException {
        if (productRepository.existsByCompanyIDAndTitle(product.getCompanyID(), product.getTitle())) {
            throw new ProductException("A product with that title already exists at the company");
        }else {
            product.setCompanyID(companyID);
            productRepository.save(product);
            Company company = companyRepository.getOne(companyID);
            company.getProducts().add(product);
            //companyRepository.updateCompany(company);
        }
        return true;
    }

    public Product getOneProduct(int productID) throws ProductException {
        if (!productRepository.existsById(productID)) {
            throw new ProductException("Could not find a product by that ID");
        }
        return productRepository.findById(productID);
    }

    public List<Product> getCompanyProducts() throws ProductException {
        if(productRepository.findByCompanyID(companyID)==null){
            throw new ProductException("The company does not own any product");
        }
        return productRepository.findByCompanyID(companyID);
    }

    public Company getCompanyDetails() throws CompanyException {
        return companyRepository.findById(companyID);
    }
}
