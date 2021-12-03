package edu.neu.coe.info6205.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InsertionTest {
    private Insertion insertion;

    @Test
    public void sortTest1() throws Exception{
        insertion = new Insertion();
        List<String> words = Arrays.asList("d", "c", "e", "a", "b", "a");
        insertion.sort(words, 0, words.size() - 1, 0);
        List<String> sortedWords = Arrays.asList("a", "a", "b", "c", "d", "e");
        assertEquals(sortedWords, words);
        throw new Exception("Array did not match!");
    }
}
