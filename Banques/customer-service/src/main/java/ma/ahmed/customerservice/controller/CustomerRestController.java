package ma.ahmed.customerservice.controller;


import ma.ahmed.customerservice.entities.Customer;
import ma.ahmed.customerservice.repository.CustolerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Customer")
public class CustomerRestController {
    @Autowired
    private CustolerRepository customerRepository;
    @GetMapping
    public List<Customer> customerList(){
     return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer customer(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}
