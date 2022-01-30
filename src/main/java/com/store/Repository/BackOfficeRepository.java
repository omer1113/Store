package com.store.Repository;

import com.store.Beans.BackOffice;
import com.store.Beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackOfficeRepository extends JpaRepository<BackOffice,Integer> {
    /*Company findById(int companyID);

    Company getOneByEmailAndPassword(String email,String password);
    boolean existsByEmail(String email);
    boolean existsByName(String name);

     */
}
