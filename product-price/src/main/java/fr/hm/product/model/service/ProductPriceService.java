package fr.hm.product.model.service;

import fr.hm.product.model.entity.ProductPrice;
import fr.hm.product.model.repository.ProductPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPriceService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductPriceService.class);

    private ProductPriceRepository priceProductRepository;

    public ProductPriceService(ProductPriceRepository priceProductRepository){
        this.priceProductRepository = priceProductRepository;
    }

    public List<ProductPrice> findAll(){
        return priceProductRepository.findAll();
    }

    public ProductPrice findOne(Long id){
        return priceProductRepository.findOne(id);
    }

}
