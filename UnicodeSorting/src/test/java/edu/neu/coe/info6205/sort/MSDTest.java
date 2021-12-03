package edu.neu.coe.info6205.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MSDTest {

    private MSD msd;

    @Test
    public void msdSortTest1(){
        msd = new MSD();
        String[] words = {"d", "c", "e", "a", "b", "a"};
        MSD.sort(words);
        String[] sortedWords = {"a", "a", "b", "c", "d", "e"};
        Assert.assertArrayEquals(sortedWords, words);

    }
}
