package com.project1.calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
	private Pattern reg_Num, reg_Operator;
	private double d_num1, d_num2, d_result;
	private Scanner sc;
	private boolean isRun,isTrue;
	private String operator, retVal;
	private boolean flag;
	public Calculator() {}
	public Calculator(boolean r) {
		String d_n1="",d_n2="";
		reg_Num = Pattern.compile("-?\\d+(\\.\\d+)?");
		reg_Operator = Pattern.compile("[!-+*\\/]");
		sc = new Scanner(System.in);
		isRun = true;
		operator="";
		retVal = "";
		d_result = 0.0;
		isTrue=false;
		
		
		while(isRun) {
			System.out.println("====================================="+
							   "\n           Calculator V1.0         "+
							   "\n=====================================");
			System.out.println("Enter any of following operators to start the calculator or enter ! to terminate program");
			System.out.println("Operator: +, -, *, /");
            operator = sc.nextLine().toLowerCase();
            if(!isOperator(operator)) {
            	System.out.print("Invalide input, program shutting down");
            	setRun(false);
            	break;
            }
            setOperator(operator);
            switch(operator) {
            
	            case "+":
	            	System.out.println("Enter first number: ");
	            	d_n1 = sc.nextLine();
	            	System.out.println("Enter second number: ");
	            	d_n2 = sc.nextLine();
	            	addition(d_n1,d_n2);
	            	printResult();
	            	break;
	            case "-":
	            	System.out.println("Enter first number: ");
	            	d_n1 = sc.nextLine();
	            	System.out.println("Enter second number: ");
	            	d_n2 = sc.nextLine();
	            	subtraction(d_n1,d_n2);
	            	printResult();
	            	break;
	            case "*":
	            	System.out.println("Enter first number: ");
	            	d_n1 = sc.nextLine();
	            	System.out.println("Enter second number: ");
	            	d_n2 = sc.nextLine();
	            	multiplication(d_n1,d_n2);
	            	printResult();
	            	break;
	            case "/":
	            	System.out.println("Enter first number: ");
	            	d_n1 = sc.nextLine();
	            	System.out.println("Enter second number: ");
	            	d_n2 = sc.nextLine();
	            	division(d_n1,d_n2);
	            	printResult();
	            	break;
	            case "!":
	            	System.out.println("Thank you for using my calculator!");
            		sc.close();
            		setRun(false);
	            	break;
            	default:
            		System.out.println("Invalid operation!");
            		break;
            		
            }
		}
	}


	public void addition(String d_n1, String d_n2) {
		isTrue = isNumeric(d_n1);
		retVal = d_n1;
		while(!isTrue) {
			System.out.println("Invalid input\nRe-enter first number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num1=Double.parseDouble(retVal);
		isTrue = isNumeric(d_n2);
		while(!isTrue) {
			System.out.println("Invalid input\nRe-enter second number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num2=Double.parseDouble(retVal);
		setD_result(d_num1+d_num2);
	}
	public void subtraction(String d_n1, String d_n2) {
		isTrue = isNumeric(d_n1);
		retVal = d_n1;
		while(!isTrue) {
			System.out.println("Invalid input\nEnter a new number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num1=Double.parseDouble(retVal);
		isTrue = isNumeric(d_n2);
		while(!isTrue) {
			System.out.println("Invalid input\nRe-enter second number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num2=Double.parseDouble(retVal);
		setD_result(d_num1-d_num2);
	}
	public void multiplication(String d_n1, String d_n2) {
		retVal = d_n1;
		isTrue = isNumeric(d_n1);
		while(!isTrue) {
			System.out.println("Invalid input\nRe-enter first number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num1=Double.parseDouble(retVal);
		isTrue = isNumeric(d_n2);
		while(!isTrue) {
			System.out.println("Invalid input\nRe-enter second number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num2=Double.parseDouble(retVal);
		setD_result(d_num1*d_num2);
	}
	
	public void division(String d_n1, String d_n2){
		retVal = d_n1;
		isTrue = isNumeric(d_n1);
		while(!isTrue) {
			System.out.println("Invalid input\nRe-enter first number :");
			retVal = sc.nextLine();
			isTrue= isNumeric(retVal);
		}
		d_num1=Double.parseDouble(retVal);
		isTrue = isNumeric(d_n2);
		boolean isFalse = true;
		while(isFalse) {
			if(isNumeric(retVal)&&Double.parseDouble(retVal)==0) {
				isFalse = false;
			}
			System.out.println("Invalid input\nRe-enter second number[not zero] :");
			retVal = sc.nextLine();
			isTrue = isNumeric(retVal);
			
		}
		d_num2=Double.parseDouble(retVal);
		setD_result(d_num1/d_num2);
	}


	private void printResult() {
		System.out.println("Result:"+getD_result());
	}
	
	/* Validate operators*/
	public void setD_num1(double d_num1) {
		this.d_num1 = d_num1;
	}
	public void setD_num2(double d_num2) {
		this.d_num2 = d_num2;
	}

	public boolean isOperator(String str_oper) {
		if(str_oper==null||str_oper.equals("")) {
			return false;
		}
		return reg_Operator.matcher(str_oper).matches();
	}
	/* Validate input*/
	public boolean isNumeric(String str_num) {
		if(str_num==null||str_num.equals("")) {
			return false;
		}
		return reg_Num.matcher(str_num).matches();
	}
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

	public Pattern getReg_Num() {
		return reg_Num;
	}
	public Pattern getReg_Operator() {
		return reg_Operator;
	}
	public double getD_num1() {
		return d_num1;
	}
	public double getD_num2() {
		return d_num2;
	}
	public double getD_result() {
		return d_result;
	}
	public void setD_result(double d_result) {
		this.d_result = d_result;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperator() {
		return operator;
	}
}
