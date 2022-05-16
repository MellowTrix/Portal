package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.ContactMessage;
import be.thomasmore.portal.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ContactMessageRepository extends CrudRepository<ContactMessage, Integer> {
}
