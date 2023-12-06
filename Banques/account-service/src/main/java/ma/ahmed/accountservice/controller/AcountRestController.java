package ma.ahmed.accountservice.controller;

import ma.ahmed.accountservice.Model.Customer;
import ma.ahmed.accountservice.clients.CustomerRestClient;
import ma.ahmed.accountservice.entities.BanckAcount;
import ma.ahmed.accountservice.repository.BanckAcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Account")
public class AcountRestController  {
    @Autowired
    private BanckAcountRepository banckAcountRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @GetMapping
    public List<BanckAcount> banckAcounts(){
        return banckAcountRepository.findAll()
                .stream()
                .peek(e->e.setCustomer(customerRestClient.findCustomerById(e.getCustomerId())))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public BanckAcount banckAcount(@PathVariable String id){
        BanckAcount banckAcount= banckAcountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(banckAcount.getCustomerId());
        banckAcount.setCustomer(customer);
        return banckAcount;
    }

}
