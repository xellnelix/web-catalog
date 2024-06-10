package otus.xellnelix.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import otus.xellnelix.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select * from \"user\" where login = :login")
    User findByLogin(@Param("login") String login);
}
