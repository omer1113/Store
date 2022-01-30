package com.store.Repository;

/*import com.store.store.Beans.Customer;
import com.store.store.Exception.CustomerException;

 */
import com.store.Beans.Customer;
import com.store.Exception.CustomerException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int customerID) throws CustomerException;


}
