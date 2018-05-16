package fr.hm.product.resource;

import fr.hm.product.model.entity.DetailProduct;
import fr.hm.product.model.service.ProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailProductController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DetailProductController.class);

    private ProductDetailService productDetailService;
    private Tracer tracer;

    public DetailProductController(ProductDetailService productDetailService, Tracer tracer) {
        this.productDetailService = productDetailService;
        this.tracer = tracer;
    }

    @GetMapping(path = "/detail/products/{id}")
    public DetailProduct getDetailProduct(@PathVariable("id") Long id){
        addSpanId(tracer.createSpan("Reception of the request"), "Instantiation");
        Span span = tracer.createSpan("Retrieve a detailProduct");
        LOGGER.debug("In the DetailProductController.getDetailProduct() call");
        DetailProduct detailProduct;
        try{
            detailProduct = productDetailService.findOne(id);
        }finally {
            span.tag("peer.service", "productDetailService.findOne() h2");
            span.logEvent(Span.CLIENT_RECV);
            tracer.close(span);
        }
        LOGGER.info("End of the processing");
        return detailProduct;
    }

    private void addSpanId(Span span, String detailMessage) {
        span.tag("peer.service", detailMessage);
        span.logEvent(Span.INSTANCEID);
        tracer.close(span);
    }


}
