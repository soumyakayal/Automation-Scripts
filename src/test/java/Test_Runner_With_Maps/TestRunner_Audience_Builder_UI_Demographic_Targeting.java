package Test_Runner_With_Maps;

import java.io.*;

import org.testng.annotations.*;

import cucumber.api.*;
import cucumber.api.testng.*;
import com.cucumber.listener.*;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/soumyak/Documents/workspace/BDD_CucumberProject_using_TestNG/src/test/java/Feature_File_With_Maps/Demographic_Targeting.feature",//path of feature files

glue={"StepDefinitions_With_Maps","com.qa.cucumber.hooks"},//path of step definition files
/*plugin= {"pretty","html:test-output/report.html", "com.cucumber.listener.ExtentCucumberFormatter:output/Test_Report.html",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports"
		},*/
		//to generate different type of reports
monochrome = true, //display the console output in a proper readable format
strict = true,//it will check if any step is not defined in a step definition file
dryRun = false,//to check the mapping is proper in between feature & step definition file
tags = {"@Gender, @Language, @HomeBiz"}, //execute all tests tagged as @SmokeTest or @RegressionTest
plugin = {"pretty", "html:test-output/report.html", 
		
          "com.cucumber.listener.ExtentCucumberFormatter:Reports/AdTheorent_Automation_Test_Report.html"})

//use '~' before the '@SmokeTest' to not execute the test suite



@Test
public class TestRunner_Audience_Builder_UI_Demographic_Targeting extends AbstractTestNGCucumberTests{

	@AfterClass
    public static void reportSetup() 
 	{
        Reporter.loadXMLConfig(new File("src/main/java/com/adth/config/extent-config.xml"));
        /*Properties p = System.getProperties();
        p.list(System.out);*/
        
        Reporter.setSystemInfo("User Name : ", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone : ", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Operating System Name : ", System.getProperty("os.name"));
        Reporter.setSystemInfo("Operating System Version : ", System.getProperty("os.version"));
        Reporter.setSystemInfo("Bit Type : ", System.getProperty("os.arch"));
        Reporter.setSystemInfo("Java Version : ", System.getProperty("java.specification.version"));
        Reporter.setTestRunnerOutput("AdTheorent Automation Test Runner");
 	}

	
}

