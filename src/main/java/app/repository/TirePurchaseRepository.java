package app.repository;

import app.domain.TirePurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirePurchaseRepository extends JpaRepository<TirePurchase, Integer> {
}
