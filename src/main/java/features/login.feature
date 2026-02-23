Feature: Login

Scenario: Validate login with invalid credentials gives error message
Given User is on the login page
When User enters valid username
When User enter wrong password
Then User should see error message 
