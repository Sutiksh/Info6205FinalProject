package edu.neu.coe.info6205.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LSDStringSortTest {

    private LSDStringSort lsdStringSort;

    @Test
    public void lsdSortTest1(){
        lsdStringSort = new LSDStringSort();
        List<String> words = Arrays.asList("d", "c", "e", "a", "b", "a");
        lsdStringSort.sort(words);
        List<String> sortedWords = Arrays.asList("a", "a", "b", "c", "d", "e");
        assertEquals(sortedWords, words);
    }

    @Test
    public void lsdSortTest2(){
        lsdStringSort = new LSDStringSort();
        List<String> words = Arrays.asList("d", "c", "e", "a", "b", "a");
        lsdStringSort.sort(words, 0, words.size() - 1);
        List<String> sortedWords = Arrays.asList("a", "a", "b", "c", "d", "e");
        assertEquals(sortedWords, words);
    }
}
