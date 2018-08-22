package content.analysis.Service;


import content.analysis.dao.ModerateCommentsDao;
import content.analysis.model.ProductComment;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ModerateCommentService {
    private ModerateCommentsDao moderateCommentsDao = new ModerateCommentsDao();

    public void addComment(Long productId, String comment) {
        ProductComment productComment = new ProductComment(productId, comment);
        moderateCommentsDao.writeOutputToFile(productComment);
    }


}
