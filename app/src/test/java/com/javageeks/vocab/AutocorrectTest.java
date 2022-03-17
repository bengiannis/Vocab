package com.javageeks.vocab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AutocorrectTest {
    @Test
    public void tooManyLetters_0() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("appkle");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"apple"}, result);
    }

    @Test
    public void tooManyLetters_1() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("oorange");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"orange"}, result);
    }

    @Test
    public void tooManyLetters_2() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("orangee");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"orange"}, result);
    }

    @Test
    public void swappedLetters_0() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("aplpe");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"apple"}, result);
    }

    @Test
    public void swappedLetters_1() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("abnana");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"banana"}, result);
    }

    @Test
    public void swappedLetters_2() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("oraneg");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"orange"}, result);
    }

    @Test
    public void missingLetters_0() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("aple");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"apple"}, result);
    }

    @Test
    public void missingLetters_1() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("anana");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"banana"}, result);
    }

    @Test
    public void missingLetters_2() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("orang");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"orange"}, result);
    }

    @Test
    public void mistypedLetters_0() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("apkle");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"apple"}, result);
    }

    @Test
    public void mistypedLetters_1() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("nanana");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"banana"}, result);
    }

    @Test
    public void mistypedLetters_3() {
        Autocorrect autocorrect = new Autocorrect(new String[]{"apple", "banana", "orange"});
        String[] result = autocorrect.autocorrectWords("orangw");
        System.out.println("Result:");
        for (String resultElement: result) {
            System.out.println("    " + resultElement);
        }

        assertArrayEquals(new String[]{"orange"}, result);
    }
}