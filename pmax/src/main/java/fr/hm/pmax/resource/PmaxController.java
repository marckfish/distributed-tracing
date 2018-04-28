package fr.hm.pmax.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PmaxController {

    Logger logger = LoggerFactory.getLogger(PmaxController.class);

    @GetMapping(path = "/pmax")
    public String getPmax(){
        logger.info("Pmax trouvés: 120");
        return "120";
    }
}
