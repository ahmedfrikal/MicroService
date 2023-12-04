package ma.ahmed.customerservice;

import ma.ahmed.customerservice.entities.Customer;
import ma.ahmed.customerservice.repository.CustolerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustolerRepository custolerRepository){
		return  args -> {
			List<Customer> customers=List.of(
					Customer.builder()
							.firstName("FRIKAL")
							.lastName("Ahmed")
							.email("Ahmed.frikal@gmail.com")
							.build(),
					Customer.builder()
							.firstName("ZIYECH")
							.lastName("HAKIM")
							.email("ziyech.Hakim@gmail.com")
							.build()
			);
           custolerRepository.saveAll(customers);
		};
	}

}
