package com.example.thymleaf.Demo.Services.IMPL;

import com.example.thymleaf.Demo.Entities.Customer;
import com.example.thymleaf.Demo.Repositories.customerRepository;
import com.example.thymleaf.Demo.Services.customerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceIMPL implements customerService {

    @Autowired
    private customerRepository customerRepository;

    @Override
    public Customer registration(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        return  customerRepository.getCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        int id= Integer.parseInt(String.valueOf(customer.getId()));
        String cName = customer.getCName();
        String cAddress = customer.getCAddress();
        String cGender = customer.getCGender();
        String cEmail = customer.getCEmail();
        String cPassword = customer.getCPassword();

        Customer customer1=new Customer();
        customer1.setId(id);
        customer1.setCName(cName);
        customer1.setCAddress(cAddress);
        customer1.setCGender(cGender);
        customer1.setCEmail(cEmail);
        customer1.setCPassword(cPassword);

        return customerRepository.save(customer1);
    }

    @Override
    public Integer deleteCustomer(int id) {
        return customerRepository.deleteCustomerById(id);
    }

    @Override
    public Customer loginCustomer(String cEmail, String cPassword) {
        return customerRepository.getCustomerByCEmailAndCPassword(cEmail,cPassword);
    }
}
