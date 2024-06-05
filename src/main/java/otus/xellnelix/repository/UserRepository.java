package otus.xellnelix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
