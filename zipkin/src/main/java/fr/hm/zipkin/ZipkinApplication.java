package fr.hm.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableZipkinStreamServer
@EnableDiscoveryClient
@SpringBootApplication
public class ZipkinApplication {

    public static void main(String [] args){
        SpringApplication.run(ZipkinApplication.class, args);
    }

}
