import java.util.*;

public class Main {

    public static void main(String[] args) {

        Users users = new Users();
        Words aliceWords = new Words();
        Words warpeaceWords = new Words();

//        do {
//        } while (!users.login());
//
//        System.out.println("Nu er vi logget ind ....... ");

        // Alice
        long start = System.nanoTime();
            aliceWords.readWordFile("alice.txt");
            long end = System.nanoTime();
        System.out.println("Tid: " + (end - start) / 1000000);

        System.out.println("Antal ord i Alice: " + aliceWords.getWordListSize());

        // War and Peace

        start = System.nanoTime();
            warpeaceWords.readWordFile("warpeace.txt");
            end = System.nanoTime();
        System.out.println("Tid: " + (end - start) / 1000000);

        System.out.println("Antal ord i War and Peace: " + warpeaceWords.getWordListSize());

        Set<String> aliceSet = new HashSet<String>();

        aliceSet.addAll(aliceWords.getWordList());

        System.out.println("Antal unikke ord i Alice: " + aliceSet.size());

        Set warpeaceSet = new HashSet<String>();

        warpeaceSet.addAll(warpeaceWords.getWordList());

        System.out.println("Antal unikke ord i War and Peace: " + warpeaceSet.size());

        Set<String> treeSet = new TreeSet<String>();

        start = System.nanoTime();
            treeSet.addAll(aliceWords.getWordList());
            end = System.nanoTime();
        System.out.println("Tid: " + (end - start) / 1000000);


      //  for (String wordEntry: treeSet) {
      //      System.out.println(wordEntry);
      //  }

        start = System.nanoTime();

            Map<String, Integer> wordCount = new HashMap<>();

            for (String wordEntry: aliceWords.getWordList()) {
                if (wordCount.containsKey(wordEntry)){
                int count = wordCount.get(wordEntry);
                count++;
                 wordCount.replace(wordEntry,count);
            } else {
                wordCount.put(wordEntry, 1);
            }
        }
            end = System.nanoTime();
        System.out.println("Tid for histogram: " + (end - start) / 1000000);

        start = System.nanoTime();
            List<Map.Entry<String, Integer>> sortedWordList = new LinkedList<Map.Entry<String, Integer>>(wordCount.entrySet());
            WordComparator wc = new WordComparator();
            Collections.sort(sortedWordList,wc);
            end = System.nanoTime();
        System.out.println("Tid for sortering: " + (end - start) / 1000000);

        for (Map.Entry<String, Integer> mapEntry: sortedWordList) {
              System.out.println(mapEntry.getKey() + " (" + mapEntry.getValue() + ")");
        }








    }

}
