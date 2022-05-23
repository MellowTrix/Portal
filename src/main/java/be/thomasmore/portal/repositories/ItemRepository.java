package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Query("select v from Item v where " +
            "(:owner = v.owner) and " +
            "(:search is null or :search = '' or lower(v.name) like lower(concat('%', :search, '%'))) and " +
            "(coalesce(:color) is null or lower(v.color) in (:color))")
    List<Item> findFilterForUser (@Param("owner") User owner, @Param("search") String search, @Param("color") List<String> color);

    List<Item> findAllByOwner(@Param("owner") User owner);
    List<Item> findAll();

}
