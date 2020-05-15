Feature: Login into application
Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://opensource-demo.orangehrmlive.com/" site
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close browsers

Examples:
|username				|password	|
|Admin					|admin123	|
|admin					|12345		|