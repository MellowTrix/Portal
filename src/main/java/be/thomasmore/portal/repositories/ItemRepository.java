package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {



}
