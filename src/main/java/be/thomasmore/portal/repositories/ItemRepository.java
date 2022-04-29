package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Query("select v from Item v")
    List<Item> findFilter (@Param("min") Double smoll, @Param("max") Double large, @Param("fuel") List<String> fuel);

    List<Item> findAll();

}
