package com.example.thymleaf.Demo.Controller;

import com.example.thymleaf.Demo.Entities.Customer;
import com.example.thymleaf.Demo.Services.IMPL.serviceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class customerController {

    @Autowired
    private serviceIMPL serviceIMPL;


    @GetMapping("/")
    public String index(){
        return "Home";
    }


    @GetMapping("/register")
    public String register(){

        return "Registration";
    }

    @PostMapping("/Save")
    public String Save(@ModelAttribute Customer customer){
        serviceIMPL.registration(customer);
        return "redirect:/register";
    }

    @GetMapping("/Login")
    public String Login(){
        return "Login";
    }

    @GetMapping("/Table")
    public String allCustomers(Model model){
        List<Customer> customers = serviceIMPL.getCustomers();
        model.addAttribute("customers",customers);
        return "Table";
    }

    @GetMapping("/getCustomer/{id}")
    public String getCustomer(@PathVariable int id,Model model){
        Customer customer = serviceIMPL.getCustomer(id);
        model.addAttribute("customer",customer);
        return "updateCustomer";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        System.out.println(customer.getId());
        Customer customer1 = serviceIMPL.updateCustomer(customer);
        return "redirect:/Table";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        Integer b = serviceIMPL.deleteCustomer(id);
        return "redirect:/Table";
    }

//    @PostMapping("/loginCustomer")
//    public String loginCustomer(@ModelAttribute Customer customer){
//        String cEmail = customer.getCEmail();
//        String cPassword = customer.getCPassword();
//        Customer customer1 = serviceIMPL.loginCustomer(cEmail, cPassword);
//        if(customer1!=null){
//            return "redirect:/Table";
//        }
//        return "redirect:/Login";
//    }
}
