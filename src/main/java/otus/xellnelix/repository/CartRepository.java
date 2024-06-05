package otus.xellnelix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
