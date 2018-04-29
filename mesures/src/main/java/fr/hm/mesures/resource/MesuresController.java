package fr.hm.mesures.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.StringJoiner;

@RestController
public class MesuresController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MesuresController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/mesures")
    public String getMesures(){
        LOGGER.info("Index service call");
        String indexes = restTemplate.getForObject("http://index-service/indexes", String.class);
        LOGGER.info("Pmax service call");
        String pmax = restTemplate.getForObject("http://pmax-service/pmaxs", String.class);
        return new StringJoiner(",", "[", "]")
                .add("index:"+indexes).add("pmax:"+pmax).toString();
    }
}
