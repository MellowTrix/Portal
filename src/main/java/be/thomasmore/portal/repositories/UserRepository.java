package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {


    @Query("select u from User u where LOWER(:username) like LOWER(u.username)")
    Optional<User> findByUsername (@Param("username") String username);

    @Query("select u from User u where LOWER(:displayname) like LOWER(u.displayname)")
    Optional<User> findBydisplayname (@Param("displayname") String displayname);

    @Query("select u from User u where LOWER(:email) like LOWER(u.email)")
    Optional<User> findByEmail (@Param("email") String email);
}
