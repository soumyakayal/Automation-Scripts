package com.qa.cucumber.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GeneralHooks extends TestBase{
	
	//1. Create the public method
	//2. Use the @Before & @After annotations with the methods
	//3. Specify the package in the runner
	//4. Inject the Scenario Object in the hook method
	
	TestUtil testutil;

	@Before
	public void Setup(Scenario name) {
		
		System.out.println("========Before Hook===========");
		
		System.out.println("Executing scenario : " + name.getName());
	}
	
	@After
	public void tearDown(Scenario name) throws InterruptedException{
		System.out.println("========After Hook===========");
		
		name.write("Finished successfully!!!");
		
		if(name.isFailed())
		{
			
			name.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
			
		}
		
		System.out.println("Status : " + name.getStatus());

		System.out.println("========***===========");


	}
	
}
