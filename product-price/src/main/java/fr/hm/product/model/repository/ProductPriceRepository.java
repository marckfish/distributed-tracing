package fr.hm.product.model.repository;

import fr.hm.product.model.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long>{
}
