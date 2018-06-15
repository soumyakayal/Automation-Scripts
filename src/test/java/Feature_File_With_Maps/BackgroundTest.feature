#Author: Soumya Kayal
Feature: Test Background Keyword

  Background: 
Given user opens browser

Then user is on login page

Then user logs into the website by entering username and password

   | username             | password      |
   | admin@adtheorent.com | AdTheorent155 |

Then validate the Dashboard page title

  @RegressionTest
  Scenario: Validate Tag sheet upload feature
  
When user selects a campaign by entering the CampaignID in the Search text box

  |         CampaignID          |
  |         Campaign:-162       |
               
Then user lands on the Campaign Properties page

Then user expands the Creative Library panel

Then user clicks on the Upload Tag Sheet button to navigate to the Upload Tag Sheet interface 

And  clicks on the Cancel button

Then user is redirected to the Campaign Properties page

When user again clicks on the Upload Tag Sheet button

Then user again navigates to the Upload Tag Sheet interface 

When user clicks on the Submit button without uploading any file

Then user accepts the system-generated alert
 
When user uploads the Tag sheet from the specified path

  |                          path                            |
  | /Users/soumyak/work/Upload Tag Sheet/INS External AdSafe |
  
  
And clicks on the Submit button  

Then user lands on the Draft Creative List page after the file upload


Then user logs out of the Draft Creative List page

	@SmokeTest 
  Scenario: Validate Audience Builder Geograpghy Targeting Factual interface
  
Then I navigate to Manage Retargeting Scripts

 

