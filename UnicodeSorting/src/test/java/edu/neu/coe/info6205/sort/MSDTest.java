package edu.neu.coe.info6205.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MSDTest {

    private MSD msd;

    @Test
    public void msdSortTest1(){
        msd = new MSD();
        List<String> words = Arrays.asList("d", "c", "e", "a", "b", "a");
        msd.sort(words);
        List<String> sortedWords = Arrays.asList("a", "a", "b", "c", "d", "e");
        assertEquals(sortedWords, words);

    }
}
