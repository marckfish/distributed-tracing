package fr.hm.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplcation {

    public static void main(String [] args){
        SpringApplication.run(EurekaServerApplcation.class, args);
    }
}
