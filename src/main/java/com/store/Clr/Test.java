package com.store.Clr;

import com.store.Beans.Company;
import com.store.Beans.Customer;
import com.store.Beans.Product;
import com.store.Utils.LocalHost;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@RequiredArgsConstructor
public class Test implements CommandLineRunner {

    public void run(String... args) throws Exception {
        System.out.println(LocalHost.SERVER_INFO);

        Product product1= Product.builder().
                price(100).companyID(1)
                .title("Product1")
                .description("First product")
                .amount(5).
                build();
        Product product2= Product.builder().
                price(500).companyID(3)
                .title("Product2")
                .description("Second product")
                .amount(10).
                build();

        Product product3= Product.builder().
                price(50).companyID(2)
                .title("Product3")
                .description("Third product")
                .amount(20).
                build();

        Company company1= Company.builder()
                .name("Company1")
                .email("Company1@company.com")
                .password("company1")
                .build();
        Company company2= Company.builder()
                .name("Company2")
                .email("Company2@company.com")
                .password("company2")
                .build();
        Company company3= Company.builder()
                .name("Company3")
                .email("Company3@company.com")
                .password("company3")
                .build();

        Customer customer1 = Customer.builder()
                .firstName("Customer 1")
                .LastName("Last name 1")
                .email("customer1@customer.com")
                .password("customer1")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Customer 2")
                .LastName("Last name 2")
                .email("customer2@customer.com")
                .password("customer2")
                .build();

        Customer customer3 = Customer.builder()
                .firstName("Customer 3")
                .LastName("Last name 3")
                .email("customer3@customer.com")
                .password("customer3")
                .build();
    }
}
