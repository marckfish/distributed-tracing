package fr.hm.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * Created by merzouk on 15/03/18.
 */
@EnableZipkinServer
@EnableDiscoveryClient
@SpringBootApplication
public class ZipkinApplication {

    public static void main(String [] args){
        SpringApplication.run(ZipkinApplication.class, args);
    }

}
