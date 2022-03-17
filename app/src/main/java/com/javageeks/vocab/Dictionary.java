package com.javageeks.vocab;

import java.util.ArrayList;

public class Dictionary {
    private String category;
    private String[] words;
    private String[] definitions;

    public Dictionary(String category) {
        this.category = category;

        if (this.category.equals("School Supplies")) {
            this.words = new String[]{"Scissors", "Eraser"};
            this.definitions = new String[]{"Scissors cut things wow", "A tool that gets rid of mistakes, like you"};
        }
        //else if (...)
        //etc...
        else {
            this.words = new String[]{};
            this.definitions = new String[]{};
        }
    }


    public String definitionOf(String word) {
        for (int i = 0; i < this.words.length; i++) {
            if (this.words[i].equals(word)) {
                return this.definitions[i];
            }
        }
        return null;
    }

    public String[] autocorrectWords(String word) {
        Autocorrect autocorrect = new Autocorrect(this.words);
        return autocorrect.autocorrectWords(word);
    }
}
