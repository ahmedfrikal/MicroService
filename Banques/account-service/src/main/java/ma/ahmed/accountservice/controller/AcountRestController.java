package ma.ahmed.accountservice.controller;

import ma.ahmed.accountservice.entities.BanckAcount;
import ma.ahmed.accountservice.repository.BanckAcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Account")
public class AcountRestController  {
    @Autowired
    private BanckAcountRepository banckAcountRepository;
    @GetMapping
    public List<BanckAcount> banckAcounts(){
        return banckAcountRepository.findAll();
    }
    @GetMapping("/{id}")
    public BanckAcount banckAcount(@PathVariable String id){
        return banckAcountRepository.findById(id).get();
    }

}
