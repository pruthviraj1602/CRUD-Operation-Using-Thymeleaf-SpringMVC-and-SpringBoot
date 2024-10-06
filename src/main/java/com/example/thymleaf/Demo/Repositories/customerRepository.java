package com.example.thymleaf.Demo.Repositories;

import com.example.thymleaf.Demo.Entities.Customer;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;

public interface customerRepository extends JpaRepository<Customer,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM customer WHERE c_email = ?")
    public Customer findByEmail(String cEmail);

    public Customer getCustomerById(Integer id);

    @Transactional
    public Integer deleteCustomerById(int id);

    @Query(nativeQuery = true,value = "SELECT * FROM customer WHERE c_email=? AND c_password=?")
    public Customer getCustomerByCEmailAndCPassword(String cEmail,String cPassword);
}
