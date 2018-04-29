package fr.hm.pmax.model.repository;

import fr.hm.pmax.model.entity.Pmax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PmaxRepository extends JpaRepository<Pmax, Long>{
}
