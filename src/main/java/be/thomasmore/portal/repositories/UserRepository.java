package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {


    @Query("select u from User u where :username like LOWER(u.username) or :username like u.username")
    Optional<User> findByUsername (@Param("username") String username);

    @Query("select u from User u where :displayname like LOWER(u.displayname) or :displayname like u.displayname")
    Optional<User> findBydisplayname (@Param("displayname") String displayname);

    @Query("select u from User u where :email like LOWER(u.email)")
    Optional<User> findByEmail (@Param("email") String email);
}
