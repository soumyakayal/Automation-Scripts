package StepDefinitions_With_Maps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.qa.pages.CampaignProperties;
import com.qa.pages.DashboardPage;
import com.qa.pages.DraftCreative;
import com.qa.pages.LoginPage;
import com.qa.pages.UploadTagSheet;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class Audience_Builder_UI_Demographic_Targeting extends TestBase{

LoginPage loginpage;
	
	DashboardPage dashboardpage;
	
	CampaignProperties camp_prop;
	
	UploadTagSheet upload_tag_sheet;
	
	DraftCreative draft_creative;
	
	TestUtil testutil;
	
	
	@Then("^user navigates to Manage Real Time Audiences interface$")
	public void user_navigates_to_Manage_Real_Time_Audiences_interface() throws Throwable {
	 
		System.out.println("Navigating to Manage Retargeting Scripts page");

 	    
 	    driver.findElement(By.cssSelector("li.nav-parent:nth-child(2) > a:nth-child(1)")).click();
 	    
 	    Thread.sleep(5000);
 	   
	    
 	    driver.findElement(By.xpath("//a[@href='/GeoContextualSegment']")).click();

 	    Thread.sleep(5000);
   	    
 	    String gettitle1 = driver.getTitle();
         try{     

 	    Assert.assertTrue(gettitle1.contains("Manage Retargeting Scripts"), "Title of the page is not matching");

 	    System.out.println("Title of the page is "+gettitle1);
 	    
 	    System.out.println("Successfully navigated to Manage Retargeting Scripts page");
         }
         catch (AssertionError e2) {
         	 System.out.println("Manage Retargeting Scripts page failed to load: "+e2.getMessage());
      		
         } 
	        
 	    Thread.sleep(5000);
	
		
	}

	@Then("^user selects an Audience name from the Manage Real Time Audiences interface$")
	public void user_selects_an_Audience_name_from_the_Manage_Real_Time_Audiences_interface(DataTable aud_name) throws Throwable {

		for(Map<String, String> data : aud_name.asMaps(String.class, String.class)) {
	
			 System.out.println("Scrolling down the Manage Retargeting Scripts page");

             //scroll down operation
		      JavascriptExecutor jse10 = (JavascriptExecutor) driver;
		      jse10.executeScript("window.scrollBy(0,20000)", "");
		      Thread.sleep(6000);
           
	    	    System.out.println("Expanding the MANAGE REAL-TIME AUDIENCES panel");
	    	    

	    	    WebElement element1 = driver.findElement(By.xpath("//a[@id='strCollapsable' and @onclick='InitAudienceSegmentList()']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//a[@id='strCollapsable' and @onclick='InitAudienceSegmentList()']")).click();
           
				Thread.sleep(12000);
				
				System.out.println("****************************************************************************************");

    			System.out.println("Searching for an Audience Name in the search text box");

                driver.findElement(By.xpath("//div[@id='tblAudienceSegment_filter']/label/input")).clear();

                Thread.sleep(2000);
            
    	  	    driver.findElement(By.xpath("//div[@id='tblAudienceSegment_filter']/label/input")).sendKeys(data.get("Audience name"));	 

                System.out.println("****************************************************************************************");

    		    System.out.println("Selecting an Audience from the Audience Segment webtable");

               Thread.sleep(9000);

    			   /* WebTable List Elements */ 
				int wt_rownumber;
				WebElement list_element1 = driver.findElement(By.xpath(".//*[@id='tblAudienceSegment']/tbody"));
				List<WebElement> tr_collection1 = driver.findElements(By.xpath(".//*[@id='tblAudienceSegment']/tbody/tr"));
			    wt_rownumber=tr_collection1.size();
			    System.out.println("Total " +wt_rownumber+ " Audience(s) present in the Page");
			    String audience=data.get("Audience name");
			 
			    for(int k=1;k< wt_rownumber+1;k++)
					{
						String element2=driver.findElement(By.xpath(".//*[@id='tblAudienceSegment']/tbody/tr["+k+"]/td[3]")).getText();
					
						if(audience.equals(element2))
							{
								System.out.println("Do you want to click on "+element2+" Audience Name?");
								Thread.sleep(4000);	
								WebElement element100 = driver.findElement(By.xpath("//table[@id='tblAudienceSegment']//tbody//tr//td//a[text()='Test_Audience_62']"));
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", element100);
						
								Thread.sleep(3000);	
								break;
							}	
					}
				Thread.sleep(7000);	

			    String gettitle221 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle221.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle221);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e321) {
	            	 System.out.println("Audience page failed to load: "+e321.getMessage());
	         		
	            } 
	            
    			Thread.sleep(7000);

			    //click on Demographic option
			      
	            System.out.println("Clicking on DEMOGRAPHIC Target Details section");

				driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
		      	            
			      Thread.sleep(6000); 
			      
		            System.out.println("Selecting the Gender option from the Demographic Targeting interface");


			      WebElement ele = driver.findElement(By.xpath("//li[@id='ligender']//a[text()='Gender']"));

		            Actions act = new Actions(driver);

		            act.moveToElement(ele).build().perform();

		            act.click();
		            
		            act.perform();
		            
		            System.out.println("Successfully navigated to Gender interface");

	    		      Thread.sleep(7000);   

	    		        System.out.println("****************************************************************************************");

		    			String statictext = driver.findElement(By.xpath("//p[@class='muted'][contains(text(),'Choose the gender that this audience will target.')]")).getText();

		    			System.out.println("System displays the following text at the top of the page: "+statictext);
		    			
		    			Thread.sleep(5000);
		    					                            
       				for(int r=1;r< 6;r++)
       					{
       						System.out.println("*************************************************************************");
       						String option1=driver.findElement(By.xpath(".//*[@id='dvGender']/div["+r+"]/label")).getText(); 
       						System.out.println("Clicking on option "+r+"::"+option1);
       						driver.findElement(By.xpath(".//*[@id='dvGender']/div["+r+"]/label")).click();
       						Thread.sleep(3000);
       						String strActualValue = driver.findElement(By.id("txtGenderSkewPercent")).getAttribute("value");
       						System.out.println("Validating AutoPopulated Gender Skew Percent Text field:");
       						System.out.println("True : TextField is Enable || False : TextField is Disable");
       						System.out.println("Textfield Status: " +driver.findElement(By.id("txtGenderSkewPercent")).isEnabled());
       						System.out.println("Gender Skew Percent Textfield value is = "+strActualValue +"");
       						Thread.sleep(5000);
       						
       					}	   
	    		      
       				Thread.sleep(3000);

       				System.out.println("****************************************************************************************");		
						
			            System.out.println("Clicking on All Male radio button option");

						driver.findElement(By.xpath(".//*[@id='dvGender']/div[1]/label")).click();
       				
       				System.out.println("****************************************************************************************");

       				Thread.sleep(5000);

						System.out.println("Clicking on Cancel Changes button");
						
       				Thread.sleep(3000);

						driver.findElement(By.xpath("//button[@value='Demograpgic' and @onclick='ClosePopup(this)']")).click();
						
						Thread.sleep(3000);
						
		              
		                String gettitle222 = driver.getTitle();
			            try{     

			    	    Assert.assertTrue(gettitle222.contains("Audience"), "Title of the page is not matching");

			    	    System.out.println("Title of the page is "+gettitle222);
			    	    
			    	    System.out.println("Successfully navigated to Audience page");
			            }
			            catch (AssertionError e322) {
			            	 System.out.println("Audience page failed to load: "+e322.getMessage());
			         		
			            } 
			            
		              
		      	        Thread.sleep(8000);
						
						
					    System.out.println("****************************************************************************************");
		
						String gendersummary1= driver.findElement(By.id("divDemographicSummary")).getText();

					    System.out.println("Following system-generated message is being displayed in the Demographic section: "+gendersummary1);
     	    
					    System.out.println("****************************************************************************************");

					      Thread.sleep(6000); 

					       
		}
		
		
	}

	@Then("^user validates the Gender_All_Male feature$")
	public void user_validates_the_Gender_All_Male_feature() throws Throwable {
	 
		 //click on Demographic option
	      
        System.out.println("Clicking on Demographic Targeting option");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 
	      
	    WebElement ele2 = driver.findElement(By.xpath("//li[@id='ligender']//a[text()='Gender']"));

        Actions act2 = new Actions(driver);

        act2.moveToElement(ele2).build().perform();

        act2.click();
        
        act2.perform();
        
        System.out.println("Successfully navigated to Gender interface");
        
	    Thread.sleep(8000); 

	    System.out.println("****************************************************************************************");		
		
        System.out.println("Clicking on All Male radio button option");

		    driver.findElement(By.xpath(".//*[@id='dvGender']/div[1]/label")).click();

		    System.out.println("****************************************************************************************");

	    Thread.sleep(4000); 

		System.out.println("Saving the changes");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(4000);

		System.out.println("****************************************************************************************");		
		
	    System.out.println("Capturing the system-generated message");

		String msg3= driver.findElement(By.id("dvAlert")).getText();
		
	    System.out.println("System-generated message is :"+ msg3);
	    
	    System.out.println("****************************************************************************************");
	
		Thread.sleep(3000);
		
          
          String gettitle223 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle223.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle223);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e323) {
	            	 System.out.println("Audience page failed to load: "+e323.getMessage());
	         		
	            } 
	            
          
  	        Thread.sleep(8000);
			
			
		    System.out.println("****************************************************************************************");

			String gendersummary2= driver.findElement(By.id("divDemographicSummary")).getText();

		    System.out.println("Following system-generated message is being displayed in the Demographic section: "+gendersummary2);
  
		    System.out.println("****************************************************************************************");

		      Thread.sleep(6000); 	
	
		
	}

	@Then("^user validates the Gender_Skew_Male feature by enteing an \"(.*)\" data$")
	public void user_validates_the_Gender_Skew_Male_feature_by_enteing_an_out_of_range_data(/*DataTable out_of_range*/String outofrange) throws Throwable {

/*		for(Map<String, String> data : out_of_range.asMaps(String.class, String.class)) {
*/
		//click on Demographic option
	      
        System.out.println("Clicking on Demographic Targeting option");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 

	    System.out.println("****************************************************************************************");

        System.out.println("Successfully navigated to Demographic Targeting interface with Gender tab in selected state");    

        System.out.println("Clicking on Skew Male radio button option");

		driver.findElement(By.xpath(".//*[@id='dvGender']/div[2]/label")).click();

		System.out.println("****************************************************************************************");

        System.out.println("Clicking on the tooltip on the right hand side of the Gender Skew Percent text box");    

		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#gender > div:nth-child(3) > div > div:nth-child(3) > i")).click();
	
		Thread.sleep(5000);
		
        System.out.println("****************************************************************************************");

        System.out.println("Clearing the Gender Skew Percent text box");    

		driver.findElement(By.id("txtGenderSkewPercent")).clear();
		
		Thread.sleep(3000);

        System.out.println("Saving the changes");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(2000);
		
		String required_1= driver.findElement(By.xpath("//span[@for='txtGenderSkewPercent']")).getText();

	    System.out.println("Following system-generated message is being displayed: "+required_1);
	    
        System.out.println("****************************************************************************************");

		Thread.sleep(5000);

		System.out.println("Entering an out of range Skew Male percentage value");

	    driver.findElement(By.id("txtGenderSkewPercent")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), /*data.get("out of range")*/ outofrange);

		Thread.sleep(5000); 

		System.out.println("Skew Male percentage value is successfully entered");
		
        System.out.println("Saving the changes");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(2000);
		
		System.out.println("****************************************************************************************");

		String invalid_range_1= driver.findElement(By.xpath("//span[@for='txtGenderSkewPercent']")).getText();

	    System.out.println("Following system-generated message is being displayed: "+invalid_range_1);
	    
		Thread.sleep(5000); 
		
		}
		
/*	}*/

	@Then("^user validates the Gender_Skew_Male feature by enteing a valid range data$")
	public void user_validates_the_Gender_Skew_Male_feature_by_enteing_a_valid_range_data(DataTable valid_range) throws Throwable {

		for(Map<String, String> data : valid_range.asMaps(String.class, String.class)) {

		System.out.println("****************************************************************************************");
        
        System.out.println("Reentering a valid Skew Male percentage value");

	    driver.findElement(By.id("txtGenderSkewPercent")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), data.get("valid range"));

		Thread.sleep(5000); 

		System.out.println("Skew Male percentage value is successfully entered");
		
		System.out.println("****************************************************************************************");

		System.out.println("Saving the changes");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(4000);

		System.out.println("****************************************************************************************");		
		
	    System.out.println("Capturing the system-generated message");

		String msg4= driver.findElement(By.id("dvAlert")).getText();
		
	    System.out.println("System-generated message is :"+ msg4);
	    
	    System.out.println("****************************************************************************************");
	
		Thread.sleep(3000);
		
          
          String gettitle224 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle224.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle224);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e324) {
	            	 System.out.println("Audience page failed to load: "+e324.getMessage());
	         		
	            } 
	            
          
  	        Thread.sleep(8000);
			
			
		    System.out.println("****************************************************************************************");

			String gendersummary3= driver.findElement(By.id("divDemographicSummary")).getText();

		    System.out.println("Following system-generated message is being displayed in the Demographic section: "+gendersummary3);
  
		    System.out.println("****************************************************************************************");

		      Thread.sleep(6000); 
		
		}
		
	}

	@Then("^user validates the Gender_All_Female feature$")
	public void user_validates_the_Gender_All_Female_feature() throws Throwable {

		//click on Demographic option
	      
        System.out.println("Clicking on Demographic Targeting option");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 

	    System.out.println("****************************************************************************************");

        System.out.println("Successfully navigated to Demographic Targeting interface with Gender tab in selected state");    

        System.out.println("****************************************************************************************");		
		
        System.out.println("Clicking on All Female radio button option");

		driver.findElement(By.xpath(".//*[@id='dvGender']/div[3]/label")).click();

		System.out.println("****************************************************************************************");

	    Thread.sleep(7000); 

		System.out.println("Saving the changes");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(4000);

		System.out.println("****************************************************************************************");		
		
	    System.out.println("Capturing the system-generated message");

		String msg6= driver.findElement(By.id("dvAlert")).getText();
		
	    System.out.println("System-generated message is :"+ msg6);
	    
	    System.out.println("****************************************************************************************");
	
		Thread.sleep(3000);
		
          
          String gettitle225 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle225.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle225);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e325) {
	            	 System.out.println("Audience page failed to load: "+e325.getMessage());
	         		
	            } 
	            
          
  	        Thread.sleep(8000);
			
			
		    System.out.println("****************************************************************************************");

			String gendersummary6= driver.findElement(By.id("divDemographicSummary")).getText();

		    System.out.println("Following system-generated message is being displayed in the Demographic section: "+gendersummary6);
  
		    System.out.println("****************************************************************************************");

		      Thread.sleep(6000); 
		
		
	}

	@Then("^user validates the Gender_Skew_Female feature by enteing an \"(.*)\" data$")
	public void user_validates_the_Gender_Skew_Female_feature_by_enteing_an_out_of_range_data(/*DataTable out_of_range*/ String outofrange) throws Throwable {

/*		for(Map<String, String> data : out_of_range.asMaps(String.class, String.class)) {
*/

            //click on Demographic option
	      
            System.out.println("Clicking on Demographic Targeting option");

			driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
	            
		    Thread.sleep(4000); 

		    System.out.println("****************************************************************************************");

	        System.out.println("Successfully navigated to Demographic Targeting interface with Gender tab in selected state");    

	        System.out.println("Clicking on Skew Female radio button option");

			driver.findElement(By.xpath(".//*[@id='dvGender']/div[4]/label")).click();
			
			Thread.sleep(5000);
			
            System.out.println("****************************************************************************************");

	        System.out.println("Clearing the Gender Skew Percent text box");    

			driver.findElement(By.id("txtGenderSkewPercent")).clear();
			
			Thread.sleep(3000);

            System.out.println("Saving the changes");
			
			driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
				
			Thread.sleep(2000);
			
			String required_2= driver.findElement(By.xpath("//span[@for='txtGenderSkewPercent']")).getText();

		    System.out.println("Following system-generated message is being displayed: "+required_2);
		    
            System.out.println("****************************************************************************************");

			Thread.sleep(5000);

			System.out.println("Entering an out of range Skew Female percentage value");

		    driver.findElement(By.id("txtGenderSkewPercent")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), /*data.get("out of range")*/outofrange);

			Thread.sleep(5000); 

			System.out.println("Skew Female percentage value is successfully entered");
			
            System.out.println("Saving the changes");
			
			driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
				
			Thread.sleep(2000);
			
			System.out.println("****************************************************************************************");

			String invalid_range_2= driver.findElement(By.xpath("//span[@for='txtGenderSkewPercent']")).getText();

		    System.out.println("Following system-generated message is being displayed: "+invalid_range_2);
		    
			Thread.sleep(5000); 
	
		}
/*	}*/

	@Then("^user validates the Gender_Skew_Female feature by enteing a valid range data$")
	public void user_validates_the_Gender_Skew_Female_feature_by_enteing_a_valid_range_data(DataTable valid_range) throws Throwable {

		for(Map<String, String> data : valid_range.asMaps(String.class, String.class)) {

			 System.out.println("****************************************************************************************");
		      
             System.out.println("Reentering a valid Skew Female percentage value");

			    driver.findElement(By.id("txtGenderSkewPercent")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), data.get("valid range"));

				Thread.sleep(5000); 

				System.out.println("Skew Female percentage value is successfully entered");
				
				System.out.println("****************************************************************************************");
	
				System.out.println("Saving the changes");
				
				driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
					
				Thread.sleep(4000);

				System.out.println("****************************************************************************************");		
				
			    System.out.println("Capturing the system-generated message");

				String msg8= driver.findElement(By.id("dvAlert")).getText();
				
			    System.out.println("System-generated message is :"+ msg8);
			    
			    System.out.println("****************************************************************************************");
			
				Thread.sleep(3000);
				
	              
	              String gettitle227 = driver.getTitle();
		            try{     

		    	    Assert.assertTrue(gettitle227.contains("Audience"), "Title of the page is not matching");

		    	    System.out.println("Title of the page is "+gettitle227);
		    	    
		    	    System.out.println("Successfully navigated to Audience page");
		            }
		            catch (AssertionError e327) {
		            	 System.out.println("Audience page failed to load: "+e327.getMessage());
		         		
		            } 
		            
	              
	      	        Thread.sleep(8000);
					
					
				    System.out.println("****************************************************************************************");
	
					String gendersummary7= driver.findElement(By.id("divDemographicSummary")).getText();

				    System.out.println("Following system-generated message is being displayed in the Demographic section: "+gendersummary7);
	    
				    System.out.println("****************************************************************************************");

				      Thread.sleep(6000); 	

			
		}
		
	}

	@Then("^user validates the Gender_No_Preference feature$")
	public void user_validates_the_Gender_No_Preference_feature() throws Throwable {

		  //click on Demographic option
	      
        System.out.println("Clicking on Demographic Targeting option");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 

	    System.out.println("****************************************************************************************");

        System.out.println("Successfully navigated to Demographic Targeting interface with Gender tab in selected state");    

        System.out.println("****************************************************************************************");		


        System.out.println("Clicking on No Preference radio button option");

		driver.findElement(By.xpath(".//*[@id='dvGender']/div[5]/label")).click();

		System.out.println("****************************************************************************************");

	    Thread.sleep(7000); 

		System.out.println("Saving the changes");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(4000);

		System.out.println("****************************************************************************************");		
		
	    System.out.println("Capturing the system-generated message");

		String msg9= driver.findElement(By.id("dvAlert")).getText();
		
	    System.out.println("System-generated message is :"+ msg9);
	    
	    System.out.println("****************************************************************************************");
	
		Thread.sleep(3000);
		
          
          String gettitle229 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle229.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle229);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e329) {
	            	 System.out.println("Audience page failed to load: "+e329.getMessage());
	         		
	            } 
	            
          
  	        Thread.sleep(8000);
			
			
		    System.out.println("****************************************************************************************");

			String gendersummary9= driver.findElement(By.id("divDemographicSummary")).getText();

		    System.out.println("Following system-generated message is being displayed in the Demographic section: "+gendersummary9);
  
		    System.out.println("****************************************************************************************");
		    
  	        Thread.sleep(8000);
	
	}

	@Then("^user validates the Add All button functionality$")
	public void user_validates_the_Add_All_button_functionality() throws Throwable {
	 

			 //click on Demographic option
	      
       System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
	      	            
		      Thread.sleep(6000); 
		      
	          System.out.println("Selecting the Language option from the Demographic Targeting interface");

		      WebElement ele = driver.findElement(By.xpath("//li[@id='lilanguage']//a[text()='Language']"));

	            Actions act = new Actions(driver);

	            act.moveToElement(ele).build().perform();

	            act.click();
	            
	            act.perform();
	            
	            System.out.println("Successfully navigated to Language interface");

   		        Thread.sleep(7000);   

				System.out.println("****************************************************************************************");

				System.out.println("Clicking on Add All button");

				driver.findElement(By.xpath("//div[@id='language']//div[@class='row']//div[@class='col-sm-2 text-center multiselect-controls']//p//a[@id='AddAllData']")).click();

				Thread.sleep(6000);
 
				System.out.println("****************************************************************************************");

   		      System.out.println("Scrolling down the web table");
   		      
   		      EventFiringWebDriver eventFiringWebDriver2 = new EventFiringWebDriver(driver);
   		      
   		      eventFiringWebDriver2.executeScript("document.querySelector('#languageSelect1').scrollTop = 90000");
   		      
			      Thread.sleep(6000); 

            /* EventFiringWebDriver eventFiringWebDriver4 = new EventFiringWebDriver(driver);
   		      
   		      eventFiringWebDriver4.executeScript("document.querySelector('#countrySelect1').scrollTop = 90000");
   		      
   		      Thread.sleep(2000); 
   		  	
             EventFiringWebDriver eventFiringWebDriver10 = new EventFiringWebDriver(driver);
   		      
   		      eventFiringWebDriver10.executeScript("document.querySelector('#countrySelect1').scrollTop = 90000");
   		      
   		      Thread.sleep(2000); 
	    		  	
             EventFiringWebDriver eventFiringWebDriver11 = new EventFiringWebDriver(driver);
   		      
   		      eventFiringWebDriver11.executeScript("document.querySelector('#countrySelect1').scrollTop = 90000"); */
   		      
			     System.out.println("****************************************************************************************");

					System.out.println("Saving the changes after adding the languages from the Available section");
					
					driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
						
					Thread.sleep(4000);

					System.out.println("****************************************************************************************");		
					
				    System.out.println("Capturing the system-generated message");

					String msg3= driver.findElement(By.id("dvAlert")).getText();
					
				    System.out.println("System-generated message is :"+ msg3);
				    
				    System.out.println("****************************************************************************************");
					
					Thread.sleep(3000);
		
	                String gettitle222 = driver.getTitle();
		            try{     

		    	    Assert.assertTrue(gettitle222.contains("Audience"), "Title of the page is not matching");

		    	    System.out.println("Title of the page is "+gettitle222);
		    	    
		    	    System.out.println("Successfully navigated to Audience page");
		            }
		            catch (AssertionError e322) {
		            	 System.out.println("Audience page failed to load: "+e322.getMessage());
		         		
		            } 
		      
	      	        Thread.sleep(8000);
				
				    System.out.println("****************************************************************************************");
	
					String demosummary1= driver.findElement(By.id("divDemographicSummary")).getText();

				    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+demosummary1);
 	    
				    System.out.println("****************************************************************************************");

				      Thread.sleep(6000); 

	}

	@Then("^user validates the search language functionality in the Chosen section$")
	public void user_validates_the_search_language_functionality_in_the_Chosen_section(DataTable search_language) throws Throwable {

		for(Map<String, String> data : search_language.asMaps(String.class, String.class)) {
	
			   //click on Demographic option
		      
            System.out.println("Clicking on DEMOGRAPHIC Target Details section");

			driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 
	      
/*							        System.out.println("Successfully navigated to Geography Targeting interface with Language tab in selected state");
*/							            
	    System.out.println("****************************************************************************************");
     
	    System.out.println("Selecting the Language option from the Demographic Targeting interface");

	    WebElement ele2 = driver.findElement(By.xpath("//li[@id='lilanguage']//a[text()='Language']"));

        Actions act2 = new Actions(driver);

        act2.moveToElement(ele2).build().perform();

        act2.click();
        
        act2.perform();
        
        System.out.println("Successfully navigated to Language interface");

	      Thread.sleep(7000);  

	    System.out.println("Performing search operation in the Chosen section");

        
        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).clear();

	       	    Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys(data.get("search language"));	
      
   	    Thread.sleep(2000);

      
/*						            driver.findElement(By.xpath("//input[@id='countrytxtSearch2']")).sendKeys(Keys.CONTROL,"a");
*/						            
   	    Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");
      
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");
        
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");
      
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch2']")).sendKeys("\b");
        
        Thread.sleep(8000); 	
		
		}
	}

	@Then("^user validates the Remove All button functionality$")
	public void user_validates_the_Remove_All_button_functionality() throws Throwable {
	 
		System.out.println("Clicking on Remove All button");

		driver.findElement(By.xpath("//div[@id='language']//div[@class='row']//div[@class='col-sm-2 text-center multiselect-controls']//p//a[@id='RemoveAllData']")).click();

		Thread.sleep(6000);   
				    
		  System.out.println("***************************************************************************************"); 

	      System.out.println("Scrolling down the web table");

	      EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
	      
	      eventFiringWebDriver.executeScript("document.querySelector('#languageSelect').scrollTop = 90000");

	      Thread.sleep(6000); 
	  	
          /*EventFiringWebDriver eventFiringWebDriver3 = new EventFiringWebDriver(driver);
	      
	      eventFiringWebDriver3.executeScript("document.querySelector('#countrySelect').scrollTop = 90000");

	      Thread.sleep(2000); 
		  	
          EventFiringWebDriver eventFiringWebDriver12 = new EventFiringWebDriver(driver);
	      
	      eventFiringWebDriver12.executeScript("document.querySelector('#countrySelect').scrollTop = 90000");
	      
	      Thread.sleep(2000); 
		  	
          EventFiringWebDriver eventFiringWebDriver13 = new EventFiringWebDriver(driver);
	      
	      eventFiringWebDriver13.executeScript("document.querySelector('#countrySelect').scrollTop = 90000");	   */ 
				    
				    
	        System.out.println("****************************************************************************************");

			System.out.println("Saving the changes after removing the languages from the Chosen section");
			
			driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
				
			Thread.sleep(4000);

			System.out.println("****************************************************************************************");		
			
		    System.out.println("Capturing the system-generated message");

			String msg= driver.findElement(By.id("dvAlert")).getText();
			
		    System.out.println("System-generated message is :"+ msg);
		    
		    System.out.println("****************************************************************************************");
			
			Thread.sleep(3000);

              
              String gettitle223 = driver.getTitle();
		            try{     

		    	    Assert.assertTrue(gettitle223.contains("Audience"), "Title of the page is not matching");

		    	    System.out.println("Title of the page is "+gettitle223);
		    	    
		    	    System.out.println("Successfully navigated to Audience page");
		            }
		            catch (AssertionError e323) {
		            	 System.out.println("Audience page failed to load: "+e323.getMessage());
		         		
		            }  

      	    Thread.sleep(8000);	
		
	}

	@Then("^user validates the search language functionality in the Available section$")
	public void user_validates_the_search_language_functionality_in_the_Available_section(DataTable search_language) throws Throwable {

		for(Map<String, String> data : search_language.asMaps(String.class, String.class)) {	
		
		 //click on Demographic option
	      
        System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 
	     
	    System.out.println("Selecting the Language option from the Demographic Targeting interface");


	      WebElement ele3 = driver.findElement(By.xpath("//li[@id='lilanguage']//a[text()='Language']"));

            Actions act3 = new Actions(driver);

            act3.moveToElement(ele3).build().perform();

            act3.click();
            
            act3.perform();
            
            System.out.println("Successfully navigated to Language interface");
            
		    Thread.sleep(7000); 

	    System.out.println("****************************************************************************************");
          
        System.out.println("Performing search operation in the Available section");
        
        driver.findElement(By.xpath("//input[@id='languagetxtSearch1']")).clear();

	       	    Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='languagetxtSearch1']")).sendKeys(data.get("search language"));
      
        Thread.sleep(4000); 

		}
	}

	@Then("^user validates the Add Selected button functionality$")
	public void user_validates_the_Add_Selected_button_functionality() throws Throwable {
	
		System.out.println("Selecting the Language name from the Available section");
		 
		/*List<WebElement> Rows = driver.findElements((By.xpath(".//table[@id='tblRealTimeAudience']//tbody/tr/td/span[contains(text(),'Bulk')]")));
		System.out.println("No of rows = "+Rows.size());
		int z=Rows.size();
		int i =0; 
		for(i=0;i<z;i++)
		  {
		    for (int j = 0; j < Rows.size(); j++ )
		     {
		        driver.findElement(By.xpath(".//table[@id='tblRealTimeAudience']//tbody/tr/td/span[contains(text(),'Bulk')]")).click();
		     }
		  }*/

	      Thread.sleep(2000); 

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.SHIFT)
		   .click(driver.findElement(By.xpath("//option[contains(text(),'en-English')]")))
		   .keyUp(Keys.SHIFT);                

		Action selectMultiple = builder.build();
		selectMultiple.perform();
		
	      Thread.sleep(7000); 

		System.out.println("****************************************************************************************");

		System.out.println("Clicking on Add Selected button");

		driver.findElement(By.xpath("//div[@id='language']//div[@class='row']//div[@class='col-sm-2 text-center multiselect-controls']//p//a[@id='AddSelectedData']//i[@class='fa fa-chevron-right']")).click();

	      Thread.sleep(6000); 

		System.out.println("****************************************************************************************");

		System.out.println("Saving the changes after adding the selected language from the Available section");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(4000);

        System.out.println("****************************************************************************************");		
		
	    System.out.println("Capturing the system-generated message");

		String msg2= driver.findElement(By.id("dvAlert")).getText();
		
	    System.out.println("System-generated message is :"+ msg2);
	    
	    System.out.println("****************************************************************************************");
		
		Thread.sleep(3000);
		
          String gettitle224 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle224.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle224);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e324) {
	            	 System.out.println("Audience page failed to load: "+e324.getMessage());
	         		
	            } 

          
  	    Thread.sleep(8000);
		
		
	    System.out.println("****************************************************************************************");

		String demosummary2= driver.findElement(By.id("divDemographicSummary")).getText();

	    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+demosummary2);

	    System.out.println("****************************************************************************************");

	      Thread.sleep(6000); 
	      
	}

	@Then("^user validates the Remove Selected button functionality$")
	public void user_validates_the_Remove_Selected_button_functionality() throws Throwable {

		  //click on Demographic option
	      
        System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
      
    Thread.sleep(4000); 
      
/*								        System.out.println("Successfully navigated to Demographic Targeting interface with Language tab in selected state");
*/								            
    System.out.println("Selecting the Language option from the Demographic Targeting interface");

    WebElement ele4 = driver.findElement(By.xpath("//li[@id='lilanguage']//a[text()='Language']"));

    Actions act4 = new Actions(driver);

    act4.moveToElement(ele4).build().perform();

    act4.click();
    
    act4.perform();
    
    System.out.println("Successfully navigated to Language interface");

    System.out.println("Selecting the language from the Chosen section");

      Thread.sleep(7000); 

		Actions builder2 = new Actions(driver);
		builder2.keyDown(Keys.SHIFT)
		   .click(driver.findElement(By.xpath("//option[contains(text(),'en-English')]")))
		   .keyUp(Keys.SHIFT);                

		Action selectMultiple2 = builder2.build();
		selectMultiple2.perform();
	    
		Thread.sleep(7000);
		
	    System.out.println("****************************************************************************************");

	    System.out.println("Clicking on Remove Selected button");

		driver.findElement(By.xpath("//div[@id='language']//div[@class='row']//div[@class='col-sm-2 text-center multiselect-controls']//p//a[@id='RemoveSelectedData']//i[@class='fa fa-chevron-left']")).click();		    
    
		Thread.sleep(6000);

		System.out.println("****************************************************************************************");

		System.out.println("Clicking on Cancel Changes button after removing the selected language name from the Chosen section");
		
		driver.findElement(By.xpath("//button[@value='Demograpgic' and @onclick='ClosePopup(this)']")).click();
			
		Thread.sleep(5000);
        
          String gettitle225 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle225.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle225);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e325) {
	            	 System.out.println("Audience page failed to load: "+e325.getMessage());
	         		
	            } 
          

  	    Thread.sleep(8000);
		
		
	}

	@Then("^user closes the Modal Demographic Targeting pop-up$")
	public void user_closes_the_Modal_Demographic_Targeting_pop_up() throws Throwable {

		 //click on Demographic option
	      
        System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 
	      
/*									        System.out.println("Successfully navigated to Demographic Targeting interface with Language tab in selected state");    
*/									    
        System.out.println("Selecting the Language option from the Demographic Targeting interface");

	    WebElement ele5 = driver.findElement(By.xpath("//li[@id='lilanguage']//a[text()='Language']"));

        Actions act5 = new Actions(driver);

        act5.moveToElement(ele5).build().perform();

        act5.click();
        
        act5.perform();
        
        System.out.println("Successfully navigated to Language interface");

        System.out.println("****************************************************************************************");
    	
		System.out.println("Closing the Modal Geography Targeting pop-up by clicking on Cancel Changes button");

	    Thread.sleep(7000); 

		driver.findElement(By.xpath("//button[@value='Demograpgic' and @onclick='ClosePopup(this)']")).click();
		
		System.out.println("Modal Demographic Targeting pop-up has been successfully closed");

	    System.out.println("****************************************************************************************");

		    
	    Thread.sleep(5000); 
	    
	    String gettitle226 = driver.getTitle();
         try{     

 	    Assert.assertTrue(gettitle226.contains("Audience"), "Title of the page is not matching");

 	    System.out.println("Title of the page is "+gettitle226);
 	    
 	    System.out.println("Successfully navigated to Audience page");
         }
         catch (AssertionError e326) {
         	 System.out.println("Audience page failed to load: "+e326.getMessage());
      		
         }   
         
	    Thread.sleep(8000); 
	    
	}
	
	@Then("^user validates the Cancel Changes button functionality$")
	public void user_validates_the_Cancel_Changes_button_functionality() throws Throwable {
	   
		  System.out.println("Clicking on DEMOGRAPHIC Target Details section");

			driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
		      	            
			      Thread.sleep(6000); 
			      
		          System.out.println("Selecting the HomeBiz option from the Demographic Targeting interface");

			      WebElement ele = driver.findElement(By.xpath("//li[@id='lihomeorbusiness']//a[text()='Home/Business']"));

		            Actions act = new Actions(driver);

		            act.moveToElement(ele).build().perform();

		            act.click();
		            
		            act.perform();
		            
		            System.out.println("Successfully navigated to HomeBiz interface");

	    		      Thread.sleep(7000);   
		 
	    		        System.out.println("****************************************************************************************");
						
						String introduction= driver.findElement(By.xpath("//p[@class='muted' and contains(text(),'Choose the location (based off IP address) of the ')]")).getText();

					    System.out.println("Following system-generated introductory message is being displayed in the HomeBiz section: "+introduction);
    	    
					    System.out.println("****************************************************************************************");
					    
	    		        System.out.println("Clicking on 'All' option");
     
	    		       			WebElement radio1 = driver.findElement(By.xpath("//label//input[@value='0' and @data-val='All']"));

	    		      			radio1.click();
	    		      			    
	    		      	 				// Intentional pause for 4 seconds.
	    		      	 				Thread.sleep(4000);
	    		             
	    		      			System.out.println("Successfully selected the location (based off IP address) of the users this audience will target");

								System.out.println("****************************************************************************************");

								System.out.println("Clicking on Cancel Changes button");
								
								driver.findElement(By.xpath("//button[@value='Demograpgic' and @onclick='ClosePopup(this)']")).click();
									
								Thread.sleep(5000);
					            
					              String gettitle225 = driver.getTitle();
		     			            try{     

		     			    	    Assert.assertTrue(gettitle225.contains("Audience"), "Title of the page is not matching");

		     			    	    System.out.println("Title of the page is "+gettitle225);
		     			    	    
		     			    	    System.out.println("Successfully navigated to Audience page");
		     			            }
		     			            catch (AssertionError e325) {
		     			            	 System.out.println("Audience page failed to load: "+e325.getMessage());
		     			         		
		     			            } 

					      	    Thread.sleep(8000);
									
		
	}

	@Then("^user validates the the 'All' option functionality$")
	public void user_validates_the_the_All_option_functionality() throws Throwable {
	
		  //click on Demographic option
	      
        System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 
	      									    
        System.out.println("Selecting the HomeBiz option from the Demographic Targeting interface");

	    WebElement ele5 = driver.findElement(By.xpath("//li[@id='lihomeorbusiness']//a[text()='Home/Business']"));

        Actions act5 = new Actions(driver);

        act5.moveToElement(ele5).build().perform();

        act5.click();
        
        act5.perform();
        
        System.out.println("Successfully navigated to HomeBiz interface");

        System.out.println("****************************************************************************************");

	      Thread.sleep(7000);   

        System.out.println("Clicking on 'All' option");
 	      
			WebElement radio2 = driver.findElement(By.xpath("//label//input[@value='0' and @data-val='All']"));

			radio2.click();
			    
	 				// Intentional pause for 4 seconds.
	 				Thread.sleep(4000);
     
			System.out.println("Successfully selected the location (based off IP address) of the users this audience will target");

		System.out.println("****************************************************************************************");

		System.out.println("Saving the changes by clicking on Save Changes button");
		
		driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
			
		Thread.sleep(4000);

        System.out.println("****************************************************************************************");		
		
	    System.out.println("Capturing the system-generated message");

		String msg2= driver.findElement(By.id("dvAlert")).getText();
		
	    System.out.println("System-generated message is :"+ msg2);
	    
	    System.out.println("****************************************************************************************");
		
		Thread.sleep(3000);
		
          String gettitle224 = driver.getTitle();
	            try{     

	    	    Assert.assertTrue(gettitle224.contains("Audience"), "Title of the page is not matching");

	    	    System.out.println("Title of the page is "+gettitle224);
	    	    
	    	    System.out.println("Successfully navigated to Audience page");
	            }
	            catch (AssertionError e324) {
	            	 System.out.println("Audience page failed to load: "+e324.getMessage());
	         		
	            } 

  	    Thread.sleep(8000);

	    System.out.println("****************************************************************************************");

		String demosummary2= driver.findElement(By.id("divDemographicSummary")).getText();

	    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+demosummary2);

	    System.out.println("****************************************************************************************");

  	    Thread.sleep(5000);
		
	}

	@Then("^user validates the the 'Home' option functionality$")
	public void user_validates_the_the_Home_option_functionality() throws Throwable {

		  //click on Demographic option
	      
        System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
      
    Thread.sleep(4000); 
      							            
    System.out.println("Selecting the HomeBiz option from the Demographic Targeting interface");

    WebElement ele4 = driver.findElement(By.xpath("//li[@id='lihomeorbusiness']//a[text()='Home/Business']"));

    Actions act4 = new Actions(driver);

    act4.moveToElement(ele4).build().perform();

    act4.click();
    
    act4.perform();
    
    System.out.println("Successfully navigated to HomeBiz interface");

      Thread.sleep(7000);   

    System.out.println("Clicking on 'Home' option");
	      
		WebElement radio3 = driver.findElement(By.xpath("//label//input[@value='1' and @data-val='Home']"));

		radio3.click();
		    
				// Intentional pause for 4 seconds.
				Thread.sleep(4000);
 
		System.out.println("Successfully selected the location (based off IP address) of the users this audience will target");

	System.out.println("****************************************************************************************");

	System.out.println("Saving the changes by clicking on Save Changes button");
	
	driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
		
	Thread.sleep(4000);

    System.out.println("****************************************************************************************");		
	
    System.out.println("Capturing the system-generated message");

	String msg3= driver.findElement(By.id("dvAlert")).getText();
	
    System.out.println("System-generated message is :"+ msg3);
    
    System.out.println("****************************************************************************************");
	
	Thread.sleep(3000);
	
      String gettitle228 = driver.getTitle();
         try{     

 	    Assert.assertTrue(gettitle228.contains("Audience"), "Title of the page is not matching");

 	    System.out.println("Title of the page is "+gettitle228);
 	    
 	    System.out.println("Successfully navigated to Audience page");
         }
         catch (AssertionError e325) {
         	 System.out.println("Audience page failed to load: "+e325.getMessage());
      		
         } 

	    Thread.sleep(8000);

	    System.out.println("****************************************************************************************");
	
	String demosummary3= driver.findElement(By.id("divDemographicSummary")).getText();

    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+demosummary3);

    System.out.println("****************************************************************************************");

	    Thread.sleep(5000);
		
		
	}

	@Then("^user validates the the 'Business' option functionality$")
	public void user_validates_the_the_Business_option_functionality() throws Throwable {
	
		 //click on Demographic option
	      
        System.out.println("Clicking on DEMOGRAPHIC Target Details section");

		driver.findElement(By.xpath(".//*[@id='lnkDemographic']")).click();
          
	    Thread.sleep(4000); 
	      									    
        System.out.println("Selecting the HomeBiz option from the Demographic Targeting interface");

	    WebElement ele6 = driver.findElement(By.xpath("//li[@id='lihomeorbusiness']//a[text()='Home/Business']"));

        Actions act6 = new Actions(driver);

        act6.moveToElement(ele6).build().perform();

        act6.click();
        
        act6.perform();
        
        System.out.println("Successfully navigated to HomeBiz interface");

        System.out.println("****************************************************************************************");

	      Thread.sleep(7000);   

	       System.out.println("Clicking on 'Business' option");
 	      
   			WebElement radio4 = driver.findElement(By.xpath("//label//input[@value='2' and @data-val='Business']"));

  			radio4.click();
  			    
  	 				// Intentional pause for 4 seconds.
  	 				Thread.sleep(4000);
         
  			System.out.println("Successfully selected the location (based off IP address) of the users this audience will target");

			System.out.println("****************************************************************************************");

			System.out.println("Saving the changes by clicking on Save Changes button");
			
			driver.findElement(By.xpath("//button[@id='btnSaveDemographicTargeting' and @type='button']")).click();
				
			Thread.sleep(4000);

            System.out.println("****************************************************************************************");		
			
		    System.out.println("Capturing the system-generated message");

			String msg4= driver.findElement(By.id("dvAlert")).getText();
			
		    System.out.println("System-generated message is :"+ msg4);
		    
		    System.out.println("****************************************************************************************");
			
			Thread.sleep(3000);
			
              String gettitle229 = driver.getTitle();
		            try{     

		    	    Assert.assertTrue(gettitle229.contains("Audience"), "Title of the page is not matching");

		    	    System.out.println("Title of the page is "+gettitle229);
		    	    
		    	    System.out.println("Successfully navigated to Audience page");
		            }
		            catch (AssertionError e329) {
		            	 System.out.println("Audience page failed to load: "+e329.getMessage());
		         		
		            } 

      	    Thread.sleep(8000);

      	    System.out.println("****************************************************************************************");
			
			String demosummary4= driver.findElement(By.id("divDemographicSummary")).getText();

		    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+demosummary4);
  
		    System.out.println("****************************************************************************************");	
		
	}
	
	@Then("^user logs out of the Audience Properties page$")
	public void user_logs_out_of_the_Audience_Properties_page() throws Throwable {
	
		  //Logout operation

	    Thread.sleep(12000); 

	    testutil= new TestUtil();
	    
	    testutil.Logout_AdTheorent();
	      		
        System.out.println("We are logging out of the AdTheorent UAT platform");

		
		
	}
}
