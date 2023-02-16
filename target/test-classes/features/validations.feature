#Author: aditya.automationqa@gmail.com
Feature: validating req-res api

Scenario: Verify if user is successfully added
	Given Add User Payload
	When  User calls "AddUserResource" with POST http request
	Then  The API call is successful with status code 201 
	And   "name" in response body is "aditya" 
	