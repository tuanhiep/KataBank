# KataBank
This is project Java for Kata Bank using Maven, Cucumber for BDD , Junit for TDD 

KataBank permit to realize the scenarios :

Feature: Bank Account 

Scenario: Deposit 1000 euros and Print the statement balance 
	Given I deposit 1000 euros 
	When I print the statement 
	Then My balance should be 1000 
	
Scenario: Deposit and Withdraw and Print the statement balance 
	Given I deposit 1000 euros 
	And I deposit 2000 euros 
	And I withdraw 500 euros 
	When I print the statement 
	Then My balance should be 2500 
	
Scenario: I withdraw 1500 and Print the statement balance 
	Given I withdraw 1500 euros 
	When I print the statement 
	Then My balance should be -1500 
    
