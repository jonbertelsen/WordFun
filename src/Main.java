import java.util.*;

public class Main {

    public static void main(String[] args) {

        Users users = new Users();
        Words aliceWords = new Words();
        Words warpeaceWords = new Words();

        // Her er vores login eksempel. Fjern kommentarer for at aktivere login
//        do {
//        } while (!users.login());
//
//        System.out.println("Nu er vi logget ind ....... ");

        // Alice in Wonderland: indlæs alle ord og gem i linkedList
        long start = System.nanoTime();
            aliceWords.readWordFile("alice.txt");
            long end = System.nanoTime();
        System.out.println("Tid: " + (end - start) / 1000000);

        System.out.println("Antal ord i Alice: " + aliceWords.getWordListSize());

        // War and Peace: indlæs alle ord og gem i linkedList

        start = System.nanoTime();
            warpeaceWords.readWordFile("warpeace.txt");
            end = System.nanoTime();
        System.out.println("Tid: " + (end - start) / 1000000);

        System.out.println("Antal ord i War and Peace: " + warpeaceWords.getWordListSize());

        // Find antal unikke ord i Alice ved at indlæse alle ord i et Set:

        Set<String> aliceSet = new HashSet<String>();
        aliceSet.addAll(aliceWords.getWordList());
        System.out.println("Antal unikke ord i Alice: " + aliceSet.size());

        // Find antal unikke ord i Krig og Fred ved at indlæse alle ord i et Set:

        Set warpeaceSet = new HashSet<String>();
        warpeaceSet.addAll(warpeaceWords.getWordList());
        System.out.println("Antal unikke ord i War and Peace: " + warpeaceSet.size());

        // Indlæs alle ord fra en linkedList og gem i TreeList. Skal bruges til at sortere ordene:

        Set<String> treeSet = new TreeSet<String>();

        start = System.nanoTime();
            treeSet.addAll(aliceWords.getWordList());
            end = System.nanoTime();
        System.out.println("Tid: " + (end - start) / 1000000);

      // Fjern udkommenteringen nedenfor for at udskrive alle ordene sorteret
      //  for (String wordEntry: treeSet) {
      //      System.out.println(wordEntry);
      //  }

        // Lav en optælling af alle forekomster af ord i Alice ved hjælp af et hashmap:

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

        // Udskriv alle ord sorteret efter forekomster. Dvs, at de ord som forekommer hyppigst udskrives sidst
        // Strategien er at gemme alle ord fra vores HashMap og antal forekomster <K,V> i en LinkedList og
        // bagefter sortere denne liste. Der anvendes en såkaldt comparator til at sortere på V.

        start = System.nanoTime();
            List<Map.Entry<String, Integer>> sortedWordList = new LinkedList<>();
            sortedWordList.addAll(wordCount.entrySet());
            WordComparator wc = new WordComparator();
            Collections.sort(sortedWordList,wc);
            end = System.nanoTime();
        System.out.println("Tid for sortering: " + (end - start) / 1000000);

        for (Map.Entry<String, Integer> mapEntry: sortedWordList) {
              System.out.println(mapEntry.getKey() + " (" + mapEntry.getValue() + ")");
        }








    }

}
