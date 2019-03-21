package app.repository;

import app.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer>{
}
