package otus.xellnelix.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select * from product where vendor_id = (select id from vendor where name = :name)")
    List<Product> findByVendorName(@Param("name") String name);
}
