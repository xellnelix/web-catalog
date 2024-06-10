package otus.xellnelix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
