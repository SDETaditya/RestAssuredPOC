#Author: aditya.automationqa@gmail.com
Feature: validating req-res api

Scenario: Verify if user is successfully added
	Given Add User Payload with "<name>" "<job>"
	When  User calls "AddUserEndPoint" with POST http request
	Then  The API call is successful with status code 201 
	And   "name" in response body is "<name>"
	And   "job" in response body is "<job>" 
	
Examples:
	|name  |job      |
	|aditya|tester   |
	|nupur |developer|