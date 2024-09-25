package com.example.thymleaf.Demo.Services;

import com.example.thymleaf.Demo.Entities.Customer;
import org.apache.catalina.User;

import java.util.List;

public interface customerService {

    public Customer registration(Customer customer);

    public List<Customer> getCustomers();

    public Customer getCustomer(Integer id);

    public Customer updateCustomer(Customer customer);

    public Integer deleteCustomer(int id);

//    public Customer loginCustomer(String cEmail,String cPassword);

}
