package fr.hm.index.resource;

import fr.hm.index.model.entity.Index;
import fr.hm.index.model.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private IndexService indexService;
    private Tracer tracer;

    public IndexController(IndexService indexService, Tracer tracer){
        this.indexService = indexService;
        this.tracer = tracer;
    }

    @GetMapping(path = "/indexes")
    public List<Index> getIndexes(){
        Span span = tracer.createSpan("Retrieve all indexes");
        LOGGER.debug("In the indexController.getIndexes() call");
        List<Index> indices;
        try{
            indices = indexService.findAll();
        }finally {
            span.tag("peer.service", "indexService.findAll() h2");
            span.logEvent(Span.CLIENT_RECV);
            tracer.close(span);
        }
        LOGGER.info("End of the processing");
        return indices;
    }
}
