package fr.hm.pmax;

import fr.hm.pmax.model.entity.Pmax;
import fr.hm.pmax.model.repository.PmaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PmaxApplication implements CommandLineRunner {

    @Autowired
    private PmaxRepository pmaxRepository;
    
    public static void main (String[] args){
        SpringApplication.run(PmaxApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        pmaxRepository.save(Pmax.builder().value(1L).build());
        pmaxRepository.save(Pmax.builder().value(9L).build());
        pmaxRepository.save(Pmax.builder().value(20L).build());
        pmaxRepository.save(Pmax.builder().value(23L).build());
        pmaxRepository.save(Pmax.builder().value(12L).build());
        pmaxRepository.save(Pmax.builder().value(3L).build());
        pmaxRepository.findAll().forEach(System.out::println);
    }
}
