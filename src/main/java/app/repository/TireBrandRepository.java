package app.repository;

import app.domain.TireBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TireBrandRepository extends JpaRepository<TireBrand, Integer>{
}
