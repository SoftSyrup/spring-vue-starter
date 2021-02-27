package tr.com.softsyrup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.com.softsyrup.model.EnglishCard;

import java.util.List;

public interface EnglishCardRepository extends MongoRepository<EnglishCard, String> {

    public EnglishCard findByOriginalWord(String word);
    public List<EnglishCard> findEnglishCardByStatus(String status);

}
