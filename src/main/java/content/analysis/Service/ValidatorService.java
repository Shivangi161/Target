package content.analysis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidatorService {

    @Autowired
    private ObjectionableWordService objectionableWordService;

    public boolean isObjectionableComment(String comment) {
        List<String> objectionableWords = objectionableWordService.getObjectionableWordList();
        String words[] = comment.split(" ");
        for (String word : words) {
            if (!word.isEmpty() && objectionableWords.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
