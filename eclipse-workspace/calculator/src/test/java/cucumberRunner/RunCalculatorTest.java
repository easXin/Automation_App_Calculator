package cucumberRunner;

import org.junit.runner.RunWith;

import com.project1.calculator.Calculator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/", 
    glue = "stepDefinitions",
    tags = "@test")

public class RunCalculatorTest {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
	}
}
