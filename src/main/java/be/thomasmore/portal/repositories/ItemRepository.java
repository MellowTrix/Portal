package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Query("select v from Item v where " +
            "(:search is null or :search = '' or lower(v.name) like lower(concat('%', :search, '%'))) and " +
            "(:min is null or :min <= v.price) and " +
            "(:max is null or :max >= v.price) and " +
            "(:color is null or lower(v.color) in (lower(:color)))")
    List<Item> findFilter (@Param("search") String search, @Param("min") Double min, @Param("max") Double max, @Param("color") List<String> color);

    List<Item> findAll();

}
