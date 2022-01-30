package com.store.Controller;

import com.store.Beans.Product;
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
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("purchaseProduct")
    public ResponseEntity<?> purchaseProduct(@RequestBody Product product) throws ProductException {
        return ResponseEntity.ok().body(customerService.purchaseProduct(product));

    }

    @GetMapping("allProduct")
    public ResponseEntity<?> getAllProduct(@RequestHeader(name = "Authorization") String token) throws CustomerException {
        return ResponseEntity.ok().body(customerService.getAllCustomerProducts());
        }

    @GetMapping("details")
    public ResponseEntity<?> getCustomerDetails() throws CustomerException {
        return ResponseEntity.ok().body(customerService.getCustomerDetails());
    }
}
    


    
    /*
    @GetMapping("oneProduct/{productID}")
    public ResponseEntity<?> getOneProduct(@PathVariable int customerID) throws CustomerException {
        return ResponseEntity.ok(customerService+.getAllCustomerProduct());
    }

    @GetMapping("allProduct/{companyID}")
    public ResponseEntity<?> getOneProduct(@PathVariable int productID) throws CustomerException {
        return ResponseEntity.ok(customerService.getAllCustomerProduct());
    }
    @PostMapping("addProduct") //http://localhost:8080/company/addProduct
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws ProductException {
        return new ResponseEntity<>((companyService.addProduct(product)) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }


}


     */