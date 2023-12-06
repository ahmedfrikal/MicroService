package ma.ahmed.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.ahmed.accountservice.Model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/Customer")
    List<Customer> CUSTOMERS();
    @GetMapping("/Customer/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("Not Vailable");
        customer.setEmail("Not Vailable");
        customer.setLastName("Not Vailable");
        return  customer;
    }

}
