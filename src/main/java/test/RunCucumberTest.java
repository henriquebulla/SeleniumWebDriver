package test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "src/main/java/steps/StepsDefinitions.java")
public class RunCucumberTest  {
}