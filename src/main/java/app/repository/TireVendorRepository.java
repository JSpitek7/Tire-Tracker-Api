package app.repository;

import app.domain.TireVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TireVendorRepository extends JpaRepository<TireVendor, Integer> {
}
