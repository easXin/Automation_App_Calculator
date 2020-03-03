@test
Feature: Testing of the Login page

Scenario: Verification of the login to Expedia.com with valid credential
	Given the user inputs valid username and password
	When user clicks Submit button
	Then the user is redirected to the flight page

Scenario Outline: Verification of login comninations for Expedia.com with valid credential
	Given the user inputs valid "<username>" and "<password>"
	When user clicks Submit button
	Then the user is redirected to the flight page	
	
	Examples:
		|username|password|
		|user|123|
		|admin|syspass|
		|mike|pass12|

Scenario Outline: Verification of flight reservation on Expedia.com with valid dates
	Given the user inputs departure date "<departure>" and "<arrival>"
	When user clicks Submit button
	Then the user is redirected to the flight result page	
	Examples:
		|departure|arrival|
		|02-10-2021|02-20-2021|
		
#		