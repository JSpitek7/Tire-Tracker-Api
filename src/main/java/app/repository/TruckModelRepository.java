package app.repository;
import app.domain.TruckModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckModelRepository extends JpaRepository<TruckModel, Integer>{
}
