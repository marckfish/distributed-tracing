package fr.hm.index.model.service;

import fr.hm.index.model.entity.Index;
import fr.hm.index.model.repository.IndexRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexService.class);

    private IndexRepository indexRepository;

    public IndexService(IndexRepository indexRepository){
        this.indexRepository = indexRepository;
    }

    public List<Index> findAll(){
        LOGGER.info("Réception de la requête");
        return indexRepository.findAll();
    }
}
