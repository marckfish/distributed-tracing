package fr.hm.product.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.StringJoiner;

@RestController
public class ProductController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/products/{id}")
    public String getProduct(@PathVariable("id") Long id){
        LOGGER.info("Product detail service call");
        String productDetail = restTemplate.getForObject("http://product-detail//detail/products/"+id, String.class);
        LOGGER.info("Product price service call");
        String productPrice = restTemplate.getForObject("http://product-price/price/products/"+id, String.class);
        return new StringJoiner(",", "[", "]")
                .add("productDetail:"+productDetail).add("productPrice:"+productPrice).toString();
    }
}
