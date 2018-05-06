package fr.hm.pmax.config;

import fr.hm.pmax.topic.MessageStream;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@EnableBinding(MessageStream.class)
@Configuration
@EnableJpaRepositories(basePackages = "fr.hm.pmax.model.*")
public class AppConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler(){
        return new AlwaysSampler();
    }
}
