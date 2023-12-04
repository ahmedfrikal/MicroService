package ma.ahmed.accountservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ahmed.accountservice.Model.Customer;
import ma.ahmed.accountservice.enums.AccountType;

import java.time.LocalDate;

@Data

@Entity @Builder @AllArgsConstructor @NoArgsConstructor
public class BanckAcount {
    @Id
    private String accountId;
    private  double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
