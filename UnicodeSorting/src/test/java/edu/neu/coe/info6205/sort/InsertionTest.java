package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InsertionTest {
    private Insertion insertion;

    @Test
    public void sortTest1() throws Exception{
        insertion = new Insertion();
        String[] words = {"d", "c", "e", "a", "b", "a"};
        insertion.sort(words, 0, words.length - 1, 0);
        String[] sortedWords = {"a", "a", "b", "c", "d", "e"};
        Assert.assertArrayEquals(sortedWords, words);
    }
}
