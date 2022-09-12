package com.example.moviebookingbackend.controller;


import com.example.moviebookingbackend.model.Bookings;
import com.example.moviebookingbackend.model.Customer;
import com.example.moviebookingbackend.model.CustomerModel;
import com.example.moviebookingbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer")
    public Customer saveData(@RequestBody CustomerModel customerModel){
        Customer customer=new Customer(customerModel);
        return service.addData(customer);
    }
    @PostMapping("/registered")
    public int registerUser(@RequestBody CustomerModel customerModel) throws IllegalAccessException {
        Customer customer=new Customer(customerModel);
        String tempEmailId  = customerModel.getEmail();
        if(tempEmailId != null && !"".equals(tempEmailId)) {
            Customer userobj = service.fetchUserByEmail(tempEmailId);
            if(userobj != null) {
                throw new IllegalAccessException("user with "+tempEmailId+" is already exit");
            }
        }
        Customer userObj = null;
        userObj = service.saveUser(customer);
        return userObj.getCustomerid();
    }

    @PostMapping("/login")
    public int loginUser(@RequestBody CustomerModel customerModel) throws IllegalAccessException {
        Customer customer=new Customer(customerModel);
        String tempEmailId = customer.getEmail();
        String tempPass = customer.getPassword();
        Customer userObj = null;
        if(tempEmailId != null && tempPass != null) {
            userObj = service.fetchUserByEmailAndPassword(tempEmailId, tempPass);
        }
        if(userObj == null) {
            throw new IllegalAccessException("Bad credentials");
        }
        return userObj.getCustomerid();
    }

    @GetMapping("/getUserByid/{id}")
    public Customer getUserByid(@PathVariable int id){
        return service.getUser(id);
    }


    @GetMapping("getByCustomerId/{customerid}")
    public List<Bookings> getCustomer(@PathVariable int customerid){
        return service.findCustomer(customerid);
    }


}
