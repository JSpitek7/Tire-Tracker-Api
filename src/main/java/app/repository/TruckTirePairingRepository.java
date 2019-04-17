package app.repository;

import app.domain.TruckTirePairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruckTirePairingRepository extends JpaRepository<TruckTirePairing, Integer> {
    Optional<TruckTirePairing> findTruckTirePairingByTruckIdAndAndTirePositionIndex(Integer truckId, Integer tirePositionIndex);
}
