package fr.hm.product.model.service;

import fr.hm.product.model.entity.DetailProduct;
import fr.hm.product.model.repository.DetailProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductDetailService.class);

    private DetailProductRepository detailProductRepository;

    public ProductDetailService(DetailProductRepository detailProductRepository){
        this.detailProductRepository = detailProductRepository;
    }

    public List<DetailProduct> findAll(){
        return detailProductRepository.findAll();
    }

    public DetailProduct findOne(Long id){
        return detailProductRepository.findOne(id);
    }

}
