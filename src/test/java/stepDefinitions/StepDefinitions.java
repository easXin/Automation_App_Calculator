package stepDefinitions;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.project1.calculator.Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;


public class StepDefinitions {
		private String d_num1 ="";
		private String d_num2 ="";
		private String btn ="";
		private Calculator cal = null;
	   @BeforeClass
	   public void init() {
		   cal = new Calculator();
	   }
	   @Given("^Enter first value \"([^\"]*)\"$")
	    public void enter_first_value(String str_num1) throws Throwable {
		   System.out.println("Second number you entered : "+str_num1);
		   assertTrue(cal.isNumeric(str_num1));
		   cal.setD_num1(Integer.parseInt(str_num1));
	    }

	    @And("^Enter second value \"([^\"]*)\"$")
	    public void enter_second_value(String str_num2) throws Throwable {
	    	System.out.println("Second number you entered : "+str_num2);
	 	    assertTrue(cal.isNumeric(str_num2));
		    cal.setD_num2(Integer.parseInt(str_num2));
	    }

	    @When("^Press \"[-+*\\/]$")
	    public void press(String btn) throws Throwable {
	        System.out.println("Operator :" +btn);
	        assertTrue(cal.isOperator(btn));
	        cal.setOperator(btn);
	    }

	    @Then("^the result is \"([^\"]*)\"$")
	    public void the_result_is(String output) throws Throwable {
	    	
	    	String operator = cal.getOperator();
	    	switch(operator) {
	    		case "+":
	    			cal.addition(String.valueOf(cal.getD_num1()), String.valueOf(cal.getD_num2()));
	    			break;
	    		case "-":
	    			cal.subtraction(String.valueOf(cal.getD_num1()), String.valueOf(cal.getD_num2()));
	    			break;
	    		case "*":
	    			cal.multiplication(String.valueOf(cal.getD_num1()), String.valueOf(cal.getD_num2()));
	    			break;
	    		case "/":
	    			cal.division(String.valueOf(cal.getD_num1()), String.valueOf(cal.getD_num2()));
	    			break;
	    		default:
	    			System.out.println("Please don't display");
	    			break;
	    	}
	    	assertTrue(cal.getD_result()==Double.parseDouble(output));
	    	System.out.println("Calculating ...\nResult :"+output);
	    }

		
}
