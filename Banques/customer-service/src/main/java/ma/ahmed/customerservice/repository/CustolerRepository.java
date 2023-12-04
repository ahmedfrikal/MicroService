package ma.ahmed.customerservice.repository;

import ma.ahmed.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustolerRepository extends JpaRepository<Customer,Long> {

}
