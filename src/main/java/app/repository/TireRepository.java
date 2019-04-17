package app.repository;

import app.domain.Tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TireRepository extends JpaRepository<Tire, Integer> {
    @Query("select distinct tire.tireModelId from #{#entityName} tire where tire.tireStatusId = 8")
    Iterable<Integer> findInStockTireModelIds();
    Tire findFirstByTireModelIdAndTireStatusId(Integer tireModelId, Integer tireStatusId);
}
