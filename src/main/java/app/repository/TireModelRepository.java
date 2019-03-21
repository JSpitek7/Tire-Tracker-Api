package app.repository;

import app.domain.TireModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TireModelRepository extends JpaRepository<TireModel, Integer>{
    Iterable<TireModel> findAllByTireBrandId(Integer BrandId);
}
