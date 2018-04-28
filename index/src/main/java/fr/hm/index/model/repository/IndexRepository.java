package fr.hm.index.model.repository;

import fr.hm.index.model.entity.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IndexRepository extends JpaRepository<Index, Long>{
}
