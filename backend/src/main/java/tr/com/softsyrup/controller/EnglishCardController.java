package tr.com.softsyrup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.softsyrup.model.EnglishCard;
import tr.com.softsyrup.model.dto.EnglishCardDTO;
import tr.com.softsyrup.repository.EnglishCardRepository;

import java.util.Locale;

@RestController
public class EnglishCardController {

    private final Logger logger = LoggerFactory.getLogger(EnglishCardController.class);

    @Autowired
    private EnglishCardRepository englishCardRepository;

    @GetMapping("api/{word}")
    public EnglishCardDTO getEnglishCardByWord(@PathVariable String word) {
        logger.info("İngilizce kelime gönderildi : {}", word);

        EnglishCard englishCard = englishCardRepository.findByOriginalWord(word.toUpperCase(Locale.ROOT));
        EnglishCardDTO englishCardDTO = new EnglishCardDTO();

        englishCardDTO.setOriginalWord(englishCard.getOriginalWord());
        englishCardDTO.setTranslateWord(englishCard.getTranslateWord());
        englishCardDTO.setStatus(englishCard.getStatus());

        return englishCardDTO;
    }

    @PostMapping("api/create")
    public EnglishCard addEnglishCard(@RequestBody EnglishCardDTO englishCardDTO) {
        EnglishCard englishCard = new EnglishCard();

        englishCard.setOriginalWord(englishCardDTO.getOriginalWord());
        englishCard.setTranslateWord(englishCardDTO.getTranslateWord());
        englishCard.setStatus("1");

        logger.info("Yeni kelime kayıt edildi");
        return englishCardRepository.save(englishCard);
    }
}
