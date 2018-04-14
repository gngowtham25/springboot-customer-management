package com.perpule.customer.controller;

import com.perpule.customer.exception.ResourceNotFoundException;
import com.perpule.customer.model.Customer;
import com.perpule.customer.model.User;
import com.perpule.customer.repository.CustomerRepository;
import com.perpule.customer.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Gowtham on 13/04/18.
 */
@RestController
@RequestMapping("/api")
public class CustomerController {

    private static Logger logger = Logger.getLogger("CustomerController.class");

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        System.out.println(customerRepository.findAll());
        return customerRepository.findAll();
    }

    @PostMapping("/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long cust_id){
        return customerRepository.findById(cust_id)
                .orElseThrow(() -> new ResourceNotFoundException("Note","id",cust_id));
    }
}
