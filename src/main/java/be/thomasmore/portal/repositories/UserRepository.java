package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {


    @Query("select u from User u where :username like u.username")
    Optional<User> findByUsername (@Param("username") String username);
}
