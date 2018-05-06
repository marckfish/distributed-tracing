package fr.hm.pmax.resource;

import fr.hm.pmax.model.entity.Pmax;
import fr.hm.pmax.model.service.PmaxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PmaxController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PmaxController.class);

    private PmaxService pmaxService;
    private Tracer tracer;

    public PmaxController(PmaxService pmaxService, Tracer tracer) {
        this.pmaxService = pmaxService;
        this.tracer = tracer;
    }

    @GetMapping(path = "/pmaxs")
    public List<Pmax> getPmaxs(){
        addSpanId(tracer.createSpan("Reception of the request"), "Instantiation");
        Span span = tracer.createSpan("Retrieve all pmax");
        LOGGER.debug("In the pmaxController.getPmaxs() call");
        List<Pmax> pmaxs;
        try{
            pmaxs = pmaxService.findAll("h2");
        }finally {
            span.tag("peer.service", "pmaxService.findAll() h2");
            span.logEvent(Span.CLIENT_RECV);
            tracer.close(span);
        }
        LOGGER.info("End of the processing");
        return pmaxs;
    }

    private void addSpanId(Span span, String detailMessage) {
        span.tag("peer.service", detailMessage);
        span.logEvent(Span.INSTANCEID);
        tracer.close(span);
    }


}
