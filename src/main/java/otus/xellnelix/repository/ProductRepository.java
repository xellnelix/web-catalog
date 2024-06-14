package otus.xellnelix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
