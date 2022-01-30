package com.store.Controller;

import com.store.Beans.Company;
import com.store.Beans.Customer;
import com.store.Beans.Product;
import com.store.Exception.CompanyException;
import com.store.Exception.CustomerException;
import com.store.Exception.ProductException;
import com.store.Repository.ProductRepository;
import com.store.Service.CompanyService;
import com.store.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {
    private final ProductRepository productRepository;
    private final CompanyService companyService;

    @PutMapping("update")
    public ResponseEntity<?> updateCompany(@RequestBody Company company) throws ProductException, CompanyException {
        return ResponseEntity.ok().body(companyService.updateCompany(company));
    }


    @PostMapping("addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws ProductException, CompanyException {
            return ResponseEntity.ok().body(companyService.addProduct(product));
        }


    @GetMapping("{productID}")
    public ResponseEntity<?> getOneProduct(@PathVariable int id) throws ProductException {
        return ResponseEntity.ok().body(companyService.getOneProduct(id));
    }

    @GetMapping("allProduct")
    public ResponseEntity<?> getAllProduct(@RequestHeader(name = "Authorization") String token) throws ProductException {
        return ResponseEntity.ok()
                .body(companyService.getCompanyProducts());

    }


    @GetMapping("details")
    public ResponseEntity<?> getCompanyDetails() throws CompanyException {
        return ResponseEntity.ok().body(companyService.getCompanyDetails());
    }

/*
    @GetMapping("oneProduct/{productID}")
    public ResponseEntity<?> getOneProduct(@PathVariable int productID) {
        return ResponseEntity.ok(productRepository.findById(productID));
    }

    @GetMapping("allProduct/{companyID}")
    public ResponseEntity<?> getAllCompanyProduct(@PathVariable int companyID) {
        return ResponseEntity.ok(productRepository.findByCompanyID(companyID));
    }
    @PostMapping("addProduct") //http://localhost:8080/company/addProduct
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws ProductException {
        return new ResponseEntity<>((companyService.addProduct(product)) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }



 */
}
