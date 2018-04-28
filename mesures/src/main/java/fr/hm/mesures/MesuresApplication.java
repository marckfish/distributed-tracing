package fr.hm.mesures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MesuresApplication {

    public static void main(String [] args){
        SpringApplication.run(MesuresApplication.class, args);
    }
}
