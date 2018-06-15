@FunctionalTest
Feature: Audience_Builder_UI_Demographic_Targeting Feature
 

@Gender
Scenario Outline: Validate the Gender section in the Audience Builder UI Demographic Targeting interface

Given user opens browser

Then user is on login page

Then user logs into the website by entering "<username>" and "<password>"

Then validate the Dashboard page title

Then user navigates to Manage Real Time Audiences interface
               
Then user selects an Audience name from the Manage Real Time Audiences interface

   | Audience name        |
   | Test_Audience_62     | 

Then user validates the Gender_All_Male feature

Then user validates the Gender_Skew_Male feature by enteing an "<outofrange>" data

#| out of range |
#| 101          |

Then user validates the Gender_Skew_Male feature by enteing a valid range data

| valid range |
| 50.45       |     

Then user validates the Gender_All_Female feature

Then user validates the Gender_Skew_Female feature by enteing an "<outofrange>" data

#| out of range |
#| 101          |

Then user validates the Gender_Skew_Female feature by enteing a valid range data

| valid range |
| 75.93       | 
    

Then user validates the Gender_No_Preference feature

Examples:

   | username             | password      | outofrange   |
   | admin@adtheorent.com | AdTheorent155 |  101         |

@Language
Scenario: Validate the Language section in the Audience Builder UI Demographic Targeting interface

Then user validates the Add All button functionality

Then user validates the search language functionality in the Chosen section

| search language     |
| Spanish             |

Then user validates the Remove All button functionality

Then user validates the search language functionality in the Available section

| search language    |
| Eng                |

Then user validates the Add Selected button functionality

Then user validates the Remove Selected button functionality

Then user closes the Modal Demographic Targeting pop-up


@HomeBiz
Scenario: Validate the HomeBiz section in the Audience Builder UI Demographic Targeting interface

Then user validates the Cancel Changes button functionality

Then user validates the the 'All' option functionality

Then user validates the the 'Home' option functionality

Then user validates the the 'Business' option functionality

Then user logs out of the Audience Properties page