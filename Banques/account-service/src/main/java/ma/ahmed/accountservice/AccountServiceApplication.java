package ma.ahmed.accountservice;

import ma.ahmed.accountservice.clients.CustomerRestClient;
import ma.ahmed.accountservice.entities.BanckAcount;
import ma.ahmed.accountservice.enums.AccountType;
import ma.ahmed.accountservice.repository.BanckAcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BanckAcountRepository acountRepository, CustomerRestClient customerRestClient){
        return args->{
            customerRestClient.CUSTOMERS().forEach(c->{

            BanckAcount banckAcount=BanckAcount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(Math.random()*64343)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(c.getId()))
                    .build();

            BanckAcount banckAcount1=BanckAcount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(Math.random()*64343)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(c.getId()))
                    .build();

            acountRepository.save(banckAcount);
            acountRepository.save(banckAcount1);

            });

        };
    }

}
