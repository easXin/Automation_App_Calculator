package com.project1.calculator;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



@TestInstance(Lifecycle.PER_CLASS)
class CalculatorTest {
	private final Calculator cal = new Calculator();
	@DisplayName("Validate operators")
	@ParameterizedTest
	@ValueSource(strings = {"+","-","*","/"}) 
	void isValidBtn(String btn) {
	    assertTrue(cal.isOperator(btn));
	   
	}
	
	@DisplayName("Validate operands")
	@ParameterizedTest
	@ValueSource(strings = {"1.2","3.2","1.2","-21","0.9","-1.1"}) 
	void isValidInput(String val) {
	    assertTrue(cal.isNumeric(val));
	}
	
	@Test
	void validateInvalidInput() {
		assertFalse(cal.isNumeric("1.1f"));
		assertFalse(cal.isNumeric("123l"));
	}
	
//	@DisplayName("Test math function")
	
	@Test
	void validateAddF() {
		cal.addition(true,"2.1","6.2");
		assertEquals(8.3,cal.getD_result());
		cal.addition(true,"-2.1","-6.2");
		assertEquals(-8.3,cal.getD_result());
		cal.addition(true,"-2.1","-7.2");
		assertNotEquals(9.8, cal.getD_result());
	}

	@Test
	void validateSubF() {
		cal.subtraction(true,"2.1","6.2");
		assertEquals(-4.1,cal.getD_result());
		cal.subtraction(true,"-2.1","-6.2");
		assertEquals(4.1,cal.getD_result());
	}

	@Test
	void validateMulF() {
		cal.multiplication(true,"2.1","3");
		assertEquals(6.300000000000001,cal.getD_result());
	}

	@Test
	void validateDivF() throws Exception {
		cal.division(true,"2.1","6.2");
		assertEquals(0.33870967741935487,cal.getD_result());
	}

}
