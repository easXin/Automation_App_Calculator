@test
Feature: Testing of the basic arithematic operations
# add subtract multiply divide
Scenario Outline: Verification of sum of two numbers, addition
	Given Enter first value <a_num1> 
	And Enter second value <a_num2>
	When Press <btn>
	Then the result is <output>
	
	Examples:
		| a_num1 | a_num2 | btn | output |
		| 0      | 20     | add | 20.0   |
		| 99     | 11     | add | 110.0  |
		| 32     | 32     | add | 64.0   |
Scenario Outline: Verification of difference of two numbers, subtraction
	Given Enter first value <s_num1> 
	And Enter second value <s_num2>
	When Press <btn>
	Then the result is <output>
	
	Examples:
		| s_num1 | s_num2 | btn | output |
		| 40     | 20     | sub | 20.0   |
		| 99     | 11     | sub | 88.0   |
		| 32     | 32     | sub | 0.0    |
Scenario Outline: Verification of product of two numbers, multiplication
	Given Enter first value <m_num1> 
	And Enter second value <m_num2>
	When Press <btn>
	Then the result is <output>
	
	Examples:
		| m_num1 | m_num2 | btn | output |
		| 0      | 20     | mul | 0.0    |
		| 99     | 11     | mul | 1089   |
		| 32     | 32     | mul | 1024   |
		
Scenario Outline: Verification of quotient of two numbers, division
	Given Enter first value <d_num1> 
	And Enter second value <d_num2>
	When Press <btn>
	Then the result is <output>
	
	Examples:
		| d_num1 | d_num2 | btn | output |
		| 30     | 20     | div | 1.5    |
		| 99     | 11     | div | 9.0    |
		| 32     | 32     | div | 1.0    |		