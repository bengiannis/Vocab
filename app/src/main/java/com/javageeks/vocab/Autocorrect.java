package com.javageeks.vocab;

import java.util.ArrayList;

public class Autocorrect {
    /*
    * How to use this class:
    *
    * Autocorrect autocorrect = new Autocorrect( <String[] of words> );
    * String[] correctWords = autocorrect.autocorrectWords( <user input of word> )
    * //correctWords now holds the autocorrected words
    *
    * */

    private String[] words;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public Autocorrect(String[] words) {
        this.words = words;
    }

    public String[] autocorrectWords(String word) {
        ArrayList<String> correct = new ArrayList<String>();

        for (int i = 0; i < word.length() + 1; i++) {
            //looks for extra unnecessary letters: ie. "appkle" -> "apple"
            if (i < word.length()) {
                String autocorrectSubtract = word.substring(0, i) + word.substring(i + 1);
                if (this.contains(autocorrectSubtract.toLowerCase()) && !correct.contains(autocorrectSubtract.toLowerCase())) {
                    correct.add(autocorrectSubtract);
                }
            }

            //looks for swapped letters: ie. "appel" -> "apple"
            if (i < word.length() - 1) {
                String autocorrectSwap = word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i+1) + word.substring(i + 2);
                if (this.contains(autocorrectSwap.toLowerCase()) && !correct.contains(autocorrectSwap.toLowerCase())) {
                    correct.add(autocorrectSwap);
                }
            }

            for (int j = 0; j < this.alphabet.length(); j++) {
                //looks for missing letters: ie. "aple" -> "apple"
                String autocorrectAdd = word.substring(0, i) + this.alphabet.charAt(j) + word.substring(i);
                if (this.contains(autocorrectAdd.toLowerCase()) && !correct.contains(autocorrectAdd.toLowerCase())) {
                    correct.add(autocorrectAdd);
                }

                if (i < word.length()) {
                    //looks for mis-typed letters: ie. "spple" -> "apple"
                    String autocorrectReplace = word.substring(0, i) + this.alphabet.charAt(j) + word.substring(i + 1);
                    if (this.contains(autocorrectReplace.toLowerCase()) && !correct.contains(autocorrectReplace.toLowerCase())) {
                        correct.add(autocorrectReplace);
                    }
                }
            }
        }
        return correct.toArray(new String[0]);
    }

    public boolean contains(String word) {
        for (String wordWithDefinition : this.words) {
            if (wordWithDefinition.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
