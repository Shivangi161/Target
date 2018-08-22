package content.analysis.Service;

import content.analysis.dao.ObjectionableWordDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectionableWordService {
    private ObjectionableWordDao objectionableWordDao = new ObjectionableWordDao();

    public List<String> getObjectionableWordList(){
        return objectionableWordDao.getObjectionableWordsList();
    }


}
