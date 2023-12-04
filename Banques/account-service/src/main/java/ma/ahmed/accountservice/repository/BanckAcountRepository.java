package ma.ahmed.accountservice.repository;

import ma.ahmed.accountservice.entities.BanckAcount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanckAcountRepository extends JpaRepository<BanckAcount,String> {

}
