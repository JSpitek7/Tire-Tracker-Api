package app;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Iterable<Product> findByCategory(String category);
    Iterable<Product> findBySupplier(String supplier);
    Iterable<Product> findByCategoryAndSupplier(String category, String supplier);
    @Query("select distinct u.category from #{#entityName} u")
    Iterable<String> findDistinctCategory();
    @Query("select distinct u.supplier from #{#entityName} u")
    Iterable<String> findDistinctSupplier();
}