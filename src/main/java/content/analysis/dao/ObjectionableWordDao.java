package content.analysis.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectionableWordDao {

    public List<String> getObjectionableWordsList(){
        List<String> objectionableWords = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            File file = new File(ObjectionableWordDao.class.getClassLoader().getResource("badwords.txt")
                    .getPath());
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    objectionableWords.add(line.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Please check the file location");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return objectionableWords;
    }
}
