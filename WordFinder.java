package AnagramGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordFinder {
    public WordFinder() {
    }

    public String[] finder() {
        List<String> wordlist = new ArrayList();
        File wordfile = new File("/Users/laythhatif/Downloads/SoccerPlayers.txt");
        Scanner scnr = null;

        try {
            scnr = new Scanner(wordfile);
        } catch (FileNotFoundException var12) {
            throw new RuntimeException(var12);
        }

        while(scnr.hasNext()) {
            wordlist.add(scnr.nextLine());
        }

        Random rand = new Random();
        String randomWord = "";
        int listSize = wordlist.size();

        for(int i = 0; i < listSize; ++i) {
            randomWord = (String)wordlist.get(rand.nextInt(wordlist.size()));
        }

        ArrayList<Character> letters = new ArrayList(randomWord.length());
        char[] scrambledWord = randomWord.toCharArray();
        int i = scrambledWord.length;

        for(int var10 = 0; var10 < i; ++var10) {
            char c = scrambledWord[var10];
            letters.add(c);
        }

        Collections.shuffle(letters);
        scrambledWord = new char[letters.size()];

        for(i = 0; i < scrambledWord.length; ++i) {
            scrambledWord[i] = (Character)letters.get(i);
        }

        String anagramWord = new String(scrambledWord);
        if (anagramWord.equals(randomWord)) {
            Collections.shuffle(letters);
        }

        String[] names = new String[]{anagramWord, randomWord};
        return names;
    }
}

