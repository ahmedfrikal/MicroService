package ma.ahmed.accountservice;

import ma.ahmed.accountservice.entities.BanckAcount;
import ma.ahmed.accountservice.enums.AccountType;
import ma.ahmed.accountservice.repository.BanckAcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BanckAcountRepository acountRepository){
        return args->{
            BanckAcount banckAcount=BanckAcount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(98000)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();

            BanckAcount banckAcount1=BanckAcount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(98000)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();

            acountRepository.save(banckAcount);
            acountRepository.save(banckAcount1);


        };
    }

}
