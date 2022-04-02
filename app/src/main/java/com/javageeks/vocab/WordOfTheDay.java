package com.javageeks.vocab;

import java.util.Calendar;

public class WordOfTheDay {
    private final Dictionary dictionary;
    private final String word;
    private final String definition;

    public WordOfTheDay() {
        int seed = seedForToday();
        String[] allCategories = Dictionary.allCategories();
        String category = allCategories[seed % allCategories.length];
        this.dictionary = new Dictionary(category);
        String[] words = this.dictionary.getWords();
        this.word = words[seed % words.length];
        this.definition = this.dictionary.definitionOf(this.word);
    }

    public int seedForToday() {
        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        return dayOfYear;
    }

    public String getWord() {
        return this.word;
    }

    public String getDefinition() {
        return this.definition;
    }
}
