package com.example.thymleaf.Demo.Repositories;

import com.example.thymleaf.Demo.Entities.Customer;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customer,Integer> {

    public Customer getCustomerById(Integer id);

    @Transactional
    public Integer deleteCustomerById(int id);

//    public Customer getCustomerByCEmailAndCPassword(String cEmail,String cPassword);
}
