package app.repository;

import app.domain.TireStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TireStatusRepository extends JpaRepository<TireStatus, Integer> {
    Iterable<TireStatus> findAllByTireStatusIdBetween(Integer bottomLimit, Integer topLimit);
}
