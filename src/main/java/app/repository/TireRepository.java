package app.repository;

import app.domain.Tire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TireRepository extends JpaRepository<Tire, Integer> {
}
