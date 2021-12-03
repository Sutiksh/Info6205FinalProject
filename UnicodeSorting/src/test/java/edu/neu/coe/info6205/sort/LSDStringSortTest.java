package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LSDStringSortTest {

    private LSDStringSort lsdStringSort;

    @Test
    public void lsdSortTest1(){
        lsdStringSort = new LSDStringSort();
        String[] words = {"d", "c", "e", "a", "b", "a"};
        lsdStringSort.sort(words);
        String[] sortedWords = {"a", "a", "b", "c", "d", "e"};
        Assert.assertArrayEquals(sortedWords, words);
    }

    @Test
    public void lsdSortTest2(){
        lsdStringSort = new LSDStringSort();
        String[] words = {"d", "c", "e", "a", "b", "a"};
        lsdStringSort.sort(words, 0, words.length - 1);
        String[] sortedWords = {"a", "a", "b", "c", "d", "e"};
        Assert.assertArrayEquals(sortedWords, words);
    }
}
