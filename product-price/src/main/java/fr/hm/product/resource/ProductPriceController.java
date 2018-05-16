package fr.hm.product.resource;

import fr.hm.product.model.entity.ProductPrice;
import fr.hm.product.model.service.ProductPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPriceController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductPriceController.class);

    private ProductPriceService productPriceService;
    private Tracer tracer;

    public ProductPriceController(ProductPriceService productPriceService, Tracer tracer){
        this.productPriceService = productPriceService;
        this.tracer = tracer;
    }

    @GetMapping(path = "/price/products/{id}")
    public ProductPrice getProductPrice(@PathVariable("id") Long id){
        Span span = tracer.createSpan("Retrieve a product price");
        LOGGER.debug("In the productPriceController.getProductPrice() call");
        ProductPrice productPrice;
        try{
            productPrice = productPriceService.findOne(id);
        }finally {
            span.tag("peer.service", "productPriceService.findOne() h2");
            span.logEvent(Span.CLIENT_RECV);
            tracer.close(span);
        }
        LOGGER.info("End of the processing");
        return productPrice;
    }
}
