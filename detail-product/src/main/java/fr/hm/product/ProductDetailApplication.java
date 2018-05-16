package fr.hm.product;

import fr.hm.product.model.entity.DetailProduct;
import fr.hm.product.model.repository.DetailProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductDetailApplication implements CommandLineRunner {

    @Autowired
    private DetailProductRepository detailProductRepository;
    
    public static void main (String[] args){
        SpringApplication.run(ProductDetailApplication.class, args);
    }

    @Override
    public void run(String... strings) {

        detailProductRepository.save(DetailProduct.builder().description("HP 13-Y023CL ENVY X360 Convertible Laptop, 13.3" +
                " 4K Ultra-HD IPS Touchscreen, Intel Core i7-7500U 2.7GHz, " +
                "512GB PCIe Solid State Drive, 16GB DDR3, 802.11ac, Bluetooth, " +
                "Win10H (Certified Refurbished)").build());
        detailProductRepository.save(DetailProduct.builder().description("EcoSmart ECO 11 Electric Tankless Water Heater, " +
                "13KW at 240 Volts with Patented Self Modulating Technology").build());
        detailProductRepository.save(DetailProduct.builder().description("Casio Men's Solar Sport Combination Watch").build());
        detailProductRepository.save(DetailProduct.builder().description("Zinus Memory Foam 12 Inch Green Tea Mattress, Queen").build());
        detailProductRepository.findAll().forEach(System.out::println);
    }
}
