package Test_Runner_With_Maps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/soumyak/Documents/workspace/BDD_CucumberProject_using_TestNG/src/test/java/Feature_File_With_Maps/Tag_Sheet_Upload.feature",//path of feature files

glue={"StepDefinitions_With_Maps","com.qa.cucumber.hooks"},//path of step definition files
plugin= {"pretty", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports"},
		//to generate different type of reports
monochrome = true, //display the console output in a proper readable format
strict = true,//it will check if any step is not defined in a step definition file
dryRun = false,//to check the mapping is proper in between feature & step definition file
tags = {"@FunctionalTest"} //execute all tests tagged as @SmokeTest & @RegressionTest

//use '~' before the '@SmokeTest' to not execute the test suite


)

public class TestRunner extends AbstractTestNGCucumberTests{





	
	
}
