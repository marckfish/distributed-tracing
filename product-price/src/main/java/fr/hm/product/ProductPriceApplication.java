package fr.hm.product;

import fr.hm.product.model.entity.ProductPrice;
import fr.hm.product.model.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.stream.LongStream;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductPriceApplication implements CommandLineRunner {

    @Autowired
    private ProductPriceRepository productPriceRepository;

    public static void main(String [] args){
        SpringApplication.run(ProductPriceApplication.class, args);
    }


    @Override
    public void run(String... strings){
        LongStream.rangeClosed(1, 4)
                .mapToObj(i -> ProductPrice.builder().price(i*50).build())
                .forEach(productPriceRepository::save);
        productPriceRepository.findAll().forEach(System.out::println);
    }
}
