Feature: User Registration
	 I wants to check if he can register in the ecommerce website.
	
	Scenario Outline:

User Registrations
	Given the user in the home page
	When I click on the registeration link
	And I entered "<firstname>","<lastname>","<email>","<password>"
	Then the registeration page displayed successfully
	
Examples:
	|firstname|lastname|email|password|	
	|alia|mohamed|alia@test.com|123456|
	|bardl|mansour|bardawl@yahoo.com|654321|