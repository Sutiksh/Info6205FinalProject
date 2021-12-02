package edu.neu.coe.info6205;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:edu/neu/coe/info6205/sort/lsdsort/LSDStringSort.feature",
        glue = "classpath:edu.neu.coe.info6205.sort.LSDStringSortStepDefinition",
        plugin = "html:target/LSDStringSort-report"
)
public class LSDStringSortTestRunner {}
