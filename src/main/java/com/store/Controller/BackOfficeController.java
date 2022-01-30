package com.store.Controller;

import com.store.Beans.Product;
import com.store.Exception.CompanyException;
import com.store.Exception.ProductException;
import com.store.Repository.ProductRepository;
import com.store.Service.BackOfficeService;
import com.store.Service.CompanyService;
import com.store.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("BackOffice")
public class BackOfficeController {
    private final BackOfficeService backOfficeService;

    @PostMapping("addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws ProductException, CompanyException {
        return ResponseEntity.ok().body(backOfficeService.addProduct(product));
    }

    @DeleteMapping("deleteProduct/{productID}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) throws ProductException, CompanyException {
        return ResponseEntity.ok()
                .body(backOfficeService.deleteProduct(id));
    }

}
