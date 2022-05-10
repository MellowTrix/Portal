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
            "(:search is null or :search = '' or :search like v.name) and " +
            "(:min is null or :min <= v.price) and " +
            "(:max is null or :max >= v.price)" )
//            + "and (:color is null or v.color in (:color))")
    List<Item> findFilter (@Param("search") String search, @Param("min") Double min, @Param("max") Double max);

    List<Item> findAll();

    @Query("select i from Item i where :owner = i.owner")
    List<Item> findAllByOwner (@Param("owner") User owner);

}
