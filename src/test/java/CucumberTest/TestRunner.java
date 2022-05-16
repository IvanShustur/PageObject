package CucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/resources/features/FirstTest.feature",
        glue = "CucumberTest")
public class TestRunner {
}
