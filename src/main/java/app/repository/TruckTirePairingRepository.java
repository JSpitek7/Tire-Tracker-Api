package app.repository;

import app.domain.TruckTirePairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckTirePairingRepository extends JpaRepository<TruckTirePairing, Integer> {
}
