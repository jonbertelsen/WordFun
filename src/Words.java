import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Words {

    private List<String> wordList = new LinkedList<String>();

    public List<String> getWordList() {
        return wordList;
    }

    public int getWordListSize(){
        return wordList.size();
    }

    public List<String> readWordFile(String fileName) {

        BufferedReader inputStream = null;
        String[] wordArray;
        int currentValue = 0;

        try {
            inputStream = new BufferedReader(new FileReader(fileName));
            String l;

            while ((l = inputStream.readLine()) != null) {
                l = l.toLowerCase();
                l = l.replaceAll("’", "");
                l = l.replaceAll("‘", "");
                l = l.replaceAll("!", "");
                l = l.replaceAll(":", "");
                l = l.replaceAll("~", "");
                l = l.replaceAll("\\(", "");

                l = l.replaceAll("\\)", "");
                l = l.replaceAll("\\?", "");
                l = l.replaceAll("'", "");
                l = l.replaceAll("--", " ");
                l = l.replaceAll(",", "");
                l = l.replaceAll(";", "");
                l = l.replaceAll("\\.", "");
                l = l.replaceAll("\"", "");
                wordArray = l.split(" ");
                for (String word : wordArray) {
                    // insert into list
                    if (word.length()>0)
                        wordList.add(word.replaceAll(" ", ""));
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            System.out.println("Hey makker - der mangler en fil");
        } catch (Exception e) {
            System.out.println("Der er opstået en generel fejl");
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return wordList;
    }

}
