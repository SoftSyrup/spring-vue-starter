package tr.com.softsyrup.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Locale;


@Document(collection = "words")
public class EnglishCard {

    @Id
    private String id;

    @Indexed(unique=true)
    private String originalWord;

    private String translateWord;
    private String status;

    public String getTranslateWord() {
        return translateWord.toUpperCase(Locale.ROOT);
    }

    public void setTranslateWord(String translateWord) {
        this.translateWord = translateWord.toUpperCase(Locale.ROOT);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalWord() {
        return originalWord.toUpperCase(Locale.ROOT);
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord.toUpperCase(Locale.ROOT);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EnglishCard{" +
                "id='" + id + '\'' +
                ", originalWord='" + originalWord + '\'' +
                ", translateWord=" + translateWord +
                ", status='" + status + '\'' +
                '}';
    }
}
