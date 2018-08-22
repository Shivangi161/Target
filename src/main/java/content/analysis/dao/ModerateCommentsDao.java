package content.analysis.dao;

import content.analysis.Service.ModerateCommentService;
import content.analysis.model.ProductComment;

import java.io.*;

public class ModerateCommentsDao {

    public void writeOutputToFile(ProductComment productComment) {
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(new File(ModerateCommentService.class.getClassLoader().getResource("product-objectionable-comments.txt")
                    .getPath()),true));

            br.write(productComment.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.flush();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
