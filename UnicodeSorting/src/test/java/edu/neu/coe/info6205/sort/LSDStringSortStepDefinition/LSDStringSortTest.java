package edu.neu.coe.info6205.sort.LSDStringSortStepDefinition;


import edu.neu.coe.info6205.sort.LSDStringSort;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LSDStringSortTest {

    private List<String> strArr;


    @Given("the {string} array of String {string}")
    public void the_array_of_String(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        strArr = Arrays.asList(string2.split(","));
    }

    @When("LSD Radix sort is performed within {int} and {int}")
    public void lsd_Radix_sort_is_performed_within_and(Integer rangeStart, Integer rangeEnd) {
        // Write code here that turns the phrase above into concrete actions
        LSDStringSort.sort(strArr, rangeStart, rangeEnd);
    }

    @Then("validate if the elements within {int} and {int} statisfy sorting invariance")
    public void validate_if_the_elements_within_and_statisfy_sorting_invariance(Integer rangeStart, Integer rangeEnd) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(stringSortingInvarianceCheck(rangeStart, rangeEnd));
    }

    public boolean stringSortingInvarianceCheck(int rangeStart, int rangeEnd) {
        for (int i = rangeStart + 1; i <= rangeEnd; i++) {
            if (strArr.get(i - 1).compareTo(strArr.get(i)) > 0) return false;
        }
        return true;
    }

}
