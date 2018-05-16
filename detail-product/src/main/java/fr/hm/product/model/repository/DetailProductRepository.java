package fr.hm.product.model.repository;

import fr.hm.product.model.entity.DetailProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface DetailProductRepository extends JpaRepository<DetailProduct, Long>{
}
