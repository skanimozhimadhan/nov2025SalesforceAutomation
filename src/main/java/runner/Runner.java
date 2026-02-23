package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(features = "src/main/java/features"
, glue = "stepdefinition", plugin = {"pretty", "html:src/main/resources/reports/cu.html"})
@RunWith(Cucumber.class)

public class Runner {

}
