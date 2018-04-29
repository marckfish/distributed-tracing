package fr.hm.index;

import fr.hm.index.model.entity.Index;
import fr.hm.index.model.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IndexApplication implements CommandLineRunner {

    @Autowired
    private IndexRepository indexRepository;

    public static void main(String [] args){
        SpringApplication.run(IndexApplication.class, args);
    }


    @Override
    public void run(String... strings){
        indexRepository.save(Index.builder().value("1;23;32;41;30;31").build());
        indexRepository.save(Index.builder().value("1;13;31;02;14;30").build());
        indexRepository.save(Index.builder().value("1;43;52;24;24;34").build());
        indexRepository.save(Index.builder().value("1;53;54;43;31;23").build());
        indexRepository.save(Index.builder().value("1;93;24;49;39;22").build());
        indexRepository.save(Index.builder().value("1;13;14;48;33;30").build());
        indexRepository.findAll().forEach(System.out::println);
    }
}
