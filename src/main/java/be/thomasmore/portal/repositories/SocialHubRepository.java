package be.thomasmore.portal.repositories;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.SocialPost;
import be.thomasmore.portal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SocialHubRepository extends CrudRepository<SocialPost, Integer> {

    @Query("select sp from SocialPost sp where :subject like LOWER(sp.subject) or :subject like sp.subject")
    Optional<SocialPost> findBySubject (@Param("subject") String subject);

    @Query("select sp from SocialPost sp where :message like LOWER(sp.message) or :message like sp.message")
    Optional<SocialPost> findByMessage (@Param("message") String message);

    List<SocialPost> findAll();
}
