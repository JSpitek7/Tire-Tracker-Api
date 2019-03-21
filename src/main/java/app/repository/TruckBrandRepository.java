package app.repository;

import app.domain.TruckBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckBrandRepository extends JpaRepository<TruckBrand, Integer>{
}
