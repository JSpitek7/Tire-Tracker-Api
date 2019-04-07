package app.repository;

import app.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer>{
    Optional<Truck> findByTruckLicensePlateNumber(String licensePlateNumber);
}
