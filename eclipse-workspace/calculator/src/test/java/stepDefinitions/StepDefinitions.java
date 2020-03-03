package stepDefinitions;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import org.junit.Assert;
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
		Calculator c = new Calculator();
	   @Given("^Enter first value \"([^\"]*)\"$")
	    public void enter_first_value(String str_num1) throws Throwable {
		   System.out.println("Second number you entered : "+str_num1);
		   setD_num1(str_num1);
	    }

	    @And("^Enter second value \"([^\"]*)\"$")
	    public void enter_second_value(String str_num2) throws Throwable {
	    	System.out.println("Second number you entered : "+str_num2);
	    	setD_num2(str_num2);
	    }

	    @When("^Press \"([^\"]*)\"$")
	    public void press(String btn) throws Throwable {
	        System.out.println("Operator :" +btn);
	    }

	    @Then("^the result is \"([^\"]*)\"$")
	    public void the_result_is(String output) throws Throwable {
	    	String operator = get_Btn().toLowerCase();
	    	switch(operator) {
	    		case "add":
	    			c.addition(getD_num1(), getD_num2());
	    			break;
	    		case "sub":
	    			c.subtraction(getD_num1(), getD_num2());
	    			break;
	    		case "mul":
	    			c.multiplication(getD_num1(), getD_num2());
	    			break;
	    		case "div":
	    			c.division(getD_num1(), getD_num2());
	    			break;
	    		default:
	    			System.out.println("Please don't display");
	    			break;
	    	}
	    	assertTrue(c.getD_result()==Double.parseDouble(output));
	    	System.out.println("Calculating ...\nResult :"+output);
	    }

		public String getD_num1() {
			return d_num1;
		}

		public void set_Btn(String btn) {
			this.btn = btn;
		}
		public String get_Btn() {
			return btn;
		}

		public void setD_num1(String d_num1) {
			this.d_num1 = d_num1;
		}

		public String getD_num2() {
			return d_num2;
		}

		public void setD_num2(String d_num2) {
			this.d_num2 = d_num2;
		}
	    
}
