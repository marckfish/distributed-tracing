package fr.hm.pmax.model.service;

import fr.hm.pmax.model.entity.Pmax;
import fr.hm.pmax.model.repository.PmaxRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmaxService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PmaxService.class);

    private PmaxRepository pmaxRepository;

    public PmaxService(PmaxRepository pmaxRepository){
        this.pmaxRepository = pmaxRepository;
    }

    public List<Pmax> findAll(){
        LOGGER.info("Réception de la requête");
        return pmaxRepository.findAll();
    }
}
