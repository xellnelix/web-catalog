package otus.xellnelix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {
}
