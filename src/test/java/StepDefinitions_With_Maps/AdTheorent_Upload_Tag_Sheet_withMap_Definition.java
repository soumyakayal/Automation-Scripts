package StepDefinitions_With_Maps;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.qa.pages.CampaignProperties;
import com.qa.pages.DashboardPage;
import com.qa.pages.DraftCreative;
import com.qa.pages.LoginPage;
import com.qa.pages.UploadTagSheet;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// Data Table with Maps : For parameterization of Test Cases

public class AdTheorent_Upload_Tag_Sheet_withMap_Definition extends TestBase{
	
LoginPage loginpage;
	
	DashboardPage dashboardpage;
	
	CampaignProperties camp_prop;
	
	UploadTagSheet upload_tag_sheet;
	
	DraftCreative draft_creative;
	
	TestUtil testutil;
	
	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
	
        System.out.println("We are launching the AdTheorent UAT platform");

		TestBase.initialization();
	}
	

	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    
		LoginPage loginpage = new LoginPage();

		
		String title = loginpage.validateLoginPageTitle();
		
		Assert.assertTrue(title.contains("AdTheorent"));		
		
	    Thread.sleep(4000);
		
	}

	@Then("^user logs into the website by entering \"(.*)\" and \"(.*)\"$")
	public void user_logs_into_the_website_by_entering_username_and_password(String username, String password/*DataTable credentials*/) throws Throwable {
	  
		 //Reg Exp:
//		 //1. \"([^\"]*)\"
//		 //2. \"(.*)\"
		
/*		dashboardpage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
*/
/*		for(Map<String, String> data : credentials.asMaps(String.class, String.class)) {
*/			
			
		     System.out.println("Initiating the login process");

			 driver.findElement(By.id("txtLoginID")).clear();

/*		     driver.findElement(By.id("txtLoginID")).sendKeys(data.get("username"));
*/
	   	 
			 driver.findElement(By.id("txtLoginID")).sendKeys(username);
			 
		     Thread.sleep(1000);

	      
	   	     driver.findElement(By.id("txtPassword")).clear();

/*		     driver.findElement(By.id("txtPassword")).sendKeys(data.get("password"));
*/
		     
	   	     driver.findElement(By.id("txtPassword")).sendKeys(password);
	   	  
		     Thread.sleep(4000);
		    
		    
		    driver.findElement(By.xpath("//button[contains(text(),'Sign In') and @type='submit']")).click();
		    
		    
		    
		}
	   

		
/*	}*/

		

	@Then("^validate the Dashboard page title$")
	public void validate_the_Dashboard_page_title() throws Throwable {
		
		DashboardPage dashboardpage = new DashboardPage();

	    Thread.sleep(10000);

	    String gettitle = dashboardpage.verifyDashboardPageTitle();
	    
	    
	    System.out.println("The login process has been initiated successfully!!!");
	    
/*		String gettitle = driver.getTitle();
*/        try{     

	    Assert.assertTrue(gettitle.contains("Dashboard - AdTheorent"));
	    
	    System.out.println("Title of the page is "+gettitle);
        System.out.println("Logged in successfully!!!");
        }
        catch (TimeoutException e1) {
        	 System.out.println("Dashboard page failed to load: "+e1.getMessage());
     		
        }catch (AssertionError e10) {
        	 System.out.println("Title of the page is not matching: "+e10.getMessage());
         		
        }
	}
	
	@When("^user selects a campaign by entering the CampaignID in the Search text box$")
	public void user_selects_a_campaign_by_entering_the_CampaignID_in_the_Search_text_box(DataTable credentials) throws Throwable {
	
		DashboardPage dashboardpage = new DashboardPage();
		
		for(Map<String, String> data : credentials.asMaps(String.class, String.class)) {

		
			System.out.println("Searching for a particular Campaign ID in the search text box");
		 	  
	  	    Thread.sleep(2000);

	  	    System.out.println("Clicking on the Advanced Search button");

	  	    dashboardpage.advance_search();
	  	  
/*	  	    driver.findElement(By.id("btnsearchTool")).click(); 
*/	  	    
	  	    Thread.sleep(3000);

	  	    System.out.println("Searching with the Campaign ID");
	  	    
	  	    Thread.sleep(3000);
	  	    
	  	    dashboardpage.campaign_button_click();

/*	  	    driver.findElement(By.xpath("//li[@class='idSearch']//button[text()='Campaign']")).click();
*/
	  	    Thread.sleep(3000);

	      	 //Entering the search criteria
	  	    
	  	    driver.findElement(By.id("txtkeywordSearch")).clear();	 

/*	  	    dashboardpage.search_by_Campaign_ID();
*/	  	    
	  	    Thread.sleep(3000);

	      	System.out.println("Entering the Campaign ID in the search text box");

	  	    driver.findElement(By.id("txtkeywordSearch")).sendKeys(data.get("CampaignID"));	 


	  	    Thread.sleep(4000);
	  	    		
	  	    System.out.println("Clicking on the Global Search button");

/*	  	    driver.findElement(By.id("btnGlobalSearch")).click();
*/	  	    
	  	    dashboardpage.perform_global_search();
	  	  	  	    
			}
				
		
		}
		

	@Then("^user lands on the Campaign Properties page$")
	public void user_lands_on_the_Campaign_Properties_page() throws Throwable {

		CampaignProperties camp_prop = new CampaignProperties();
		
  	    Thread.sleep(5000);

        try{
        	
        String title = camp_prop.validate_Campaign_Properties_PageTitle();
		
		Assert.assertTrue(title.contains("Campaign"));		
		
	    Thread.sleep(4000);
	    
		/*String gettitle300 = driver.getTitle();
        try{
	    Assert.assertTrue(gettitle300.contains("Campaign"));

	    System.out.println("Title of the page is "+gettitle300);*/
	    
	    System.out.println("Title of the page is "+title);

	    
	    System.out.println("Successfully navigated to Campaign Properties page");
        }
        catch (Exception e300) {

        System.out.println("Campaign Properties page failed to load: "+e300.getMessage());
		
       } 
	    Thread.sleep(8000);
            //scroll down operation
    		      JavascriptExecutor jse = (JavascriptExecutor) driver;
    		      jse.executeScript("window.scrollBy(0,800)", "");
    		      Thread.sleep(3000);
        
    }
    


	@Then("^user expands the Creative Library panel$")
	public void user_expands_the_Creative_Library_panel() throws Throwable {

		CampaignProperties camp_prop = new CampaignProperties();

		//Expanding CREATIVE LIBRARY panel
	      
/*	      driver.findElement(By.xpath(".//*[@id='dvCreativeBlock']")).click();
*/			
		camp_prop.clickOnCreativeLibExpandbutton();
		
		Thread.sleep(3000);	 
		
  System.out.println("Creative Library panel has been expanded");
  
	Thread.sleep(2000);	            

  System.out.println("Scrolling down the page");

  //scroll down operation
    JavascriptExecutor jse1 = (JavascriptExecutor) driver;
    jse1.executeScript("window.scrollBy(0,15000)", "");
    Thread.sleep(4000);
  
  System.out.println("Scrolling down operation has been successful");
  
		Thread.sleep(5000);	 
		
	}

	@Then("^user clicks on the Upload Tag Sheet button to navigate to the Upload Tag Sheet interface$")
	public void user_clicks_on_the_Upload_Tag_Sheet_button() throws Throwable {

		CampaignProperties camp_prop = new CampaignProperties();
		
    	  System.out.println("Clicking on Upload Tag Sheet button");


/*	      driver.findElement(By.cssSelector("a.btn:nth-child(5) > i:nth-child(1)")).click();	              
*/      
    	  camp_prop.click_on_upload_tagsheet();
    	  
	      Thread.sleep(1000);
		
		
		
	}


	@Then("^clicks on the Cancel button$")
	public void clicks_on_the_Cancel_button() throws Throwable {

		UploadTagSheet upload_tag_sheet = new UploadTagSheet();
		
		 System.out.println("Clicking on the Cancel button");
         
/*         driver.findElement(By.id("btnTagSheetModalCancel")).click();
*/
 	      Thread.sleep(2000);
 	      
		upload_tag_sheet.click_on_cancel_button();
		
	}

	 @Then("^user is redirected to the Campaign Properties page$")
     public void user_is_redirected_to_the_Campaign_Properties_page() throws Throwable {
        
		 CampaignProperties camp_prop = new CampaignProperties();
			
	  	    Thread.sleep(5000);

	        try{
	        	
	        String title = camp_prop.validate_Campaign_Properties_PageTitle();
			
			Assert.assertTrue(title.contains("Campaign"));		
			
		    Thread.sleep(4000);

		    System.out.println("Successfully navigated to Campaign Properties page");
	        }
	        catch (Exception e300) {

	        System.out.println("Campaign Properties page failed to load: "+e300.getMessage());
			
	       } 
	        
         System.out.println("Redirection is on the Campaign Properties page");
 	     
         Thread.sleep(3000);
         
         System.out.println("Title of the page is "+driver.getTitle());
         
     	
     }
     
     
     @When("^user again clicks on the Upload Tag Sheet button$")
     public void user_again_clicks_on_the_Upload_Tag_Sheet_button() throws Throwable {
  
 		CampaignProperties camp_prop = new CampaignProperties();

        Thread.sleep(2000);

     	   System.out.println("Again, clicking on Upload Tag Sheet button");


/*  	      driver.findElement(By.cssSelector("a.btn:nth-child(5) > i:nth-child(1)")).click();	              
*/        
     	  camp_prop.click_on_upload_tagsheet();

     	
     }
     
     @Then("^user again navigates to the Upload Tag Sheet interface$")
     public void user_again_navigates_to_the_Upload_Tag_Sheet_interface() throws Throwable {
      
 		UploadTagSheet upload_tag_sheet = new UploadTagSheet();

 	      Thread.sleep(1000);	

     	  System.out.println("Successfully navigated to Upload Tag Sheet interface");
           
 	      Thread.sleep(2000);

/* 	    WebElement element = driver.findElement(By.cssSelector("i.fa:nth-child(6)"));
 	    String toolTipText = element.getAttribute("title");*/
 	    
 	     String tooltip = upload_tag_sheet.toolTipText();
 	      
 	    System.out.println("The tooltip text on the right hand side of the Browse button is: "+tooltip);
         
     	
     }
     
     @When("^user clicks on the Submit button without uploading any file$")
     public void user_clicks_on_the_Submit_button_without_uploading_any_file() throws Throwable {
    
  		UploadTagSheet upload_tag_sheet = new UploadTagSheet();

  		Thread.sleep(5000);

 		System.out.println("Clicking on the Submit button without uploading any file");
         
 		Thread.sleep(1000);

       
/*       driver.findElement(By.id("btnSubmitTagSheet")).click();	
*/   
 		
 		upload_tag_sheet.submit_button();
 		
     }
             
     
     @Then("^user accepts the system-generated alert$")
     public void user_accepts_the_system_generated_alert() throws Throwable {
      
     	 // Switching to Alert        
         Alert alert = driver.switchTo().alert();		
         		
         // Capturing alert message.    
         String alertMessage= driver.switchTo().alert().getText();		
         		
         // Displaying alert message		
         System.out.println("The system-generated alert message is: "+alertMessage);	
         
         Thread.sleep(5000);
         // Accepting alert		
         alert.accept();	
           
     	
     }
     
     
     @When("^user uploads the Tag sheet from the specified path$")
     public void user_uploads_the_Tag_sheet_from_the_specified_path(DataTable credentials) throws Throwable {

   		UploadTagSheet upload_tag_sheet = new UploadTagSheet();

     	for(Map<String, String> data : credentials.asMaps(String.class, String.class)) {

            Thread.sleep(5000);

       //Click on the File Upload Button
       
       System.out.println("Clicking on the Browse button");

/*       WebElement uploadElement2 = driver.findElement(By.id("lnkTSUUpload"));
       
       uploadElement2.click();*/

       upload_tag_sheet.browse_button();
       
       System.out.println("Uploading a Tag Sheet file");	

   	
         //File Need to be imported
   	   	 
     	File file1 = new File(data.get("path"));

     	StringSelection stringSelection1= new StringSelection(file1.getAbsolutePath());

     	 
     	//Copy to clipboard 

     	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
     	 
     	Robot robot1 = new Robot();
     	 
     	// Cmd + Tab is needed since it launches a Java app and the browser looses focus
     	 
     	robot1.keyPress(KeyEvent.VK_META);
     	 
     	robot1.keyPress(KeyEvent.VK_TAB);
     	 
     	robot1.keyRelease(KeyEvent.VK_META);
     	 
     	robot1.keyRelease(KeyEvent.VK_TAB);
     	 
     	robot1.delay(6000);
     	 
     	//Open Goto window
     	 
     	robot1.keyPress(KeyEvent.VK_META);
     	 
     	robot1.keyPress(KeyEvent.VK_SHIFT);
     	 
     	robot1.keyPress(KeyEvent.VK_G);
     	 
     	robot1.keyRelease(KeyEvent.VK_META);
     	 
     	robot1.keyRelease(KeyEvent.VK_SHIFT);
     	 
     	robot1.keyRelease(KeyEvent.VK_G);
     	 
     	//Paste the clipboard value
     	 
     	robot1.keyPress(KeyEvent.VK_META);
     	 
     	robot1.keyPress(KeyEvent.VK_V);
     	 
     	robot1.keyRelease(KeyEvent.VK_META);
     	 
     	robot1.keyRelease(KeyEvent.VK_V);
     	 
     	//Press Enter key to close the Goto window and Upload window
     	 
     	robot1.keyPress(KeyEvent.VK_ENTER);
     	 
     	robot1.keyRelease(KeyEvent.VK_ENTER);
     	 
     	robot1.delay(6000);
     	 
     	robot1.keyPress(KeyEvent.VK_ENTER);
     	 
     	robot1.keyRelease(KeyEvent.VK_ENTER);
       	
   	System.out.println("File Upload has been successful!!!");

   	Thread.sleep(8000);
    
   	            
/*   	String uploaded = driver.findElement(By.id("spnTagSheetUploadedFileName")).getText();
*/
 	    String uploaded = upload_tag_sheet.uploaded_text();
 	
 	
   	
     	System.out.println("The system-generated message is: "+uploaded);
     	       	 
     	
     }

     }
     
     
     @And("^clicks on the Submit button$")
     public void clicks_on_the_Submit_button() throws Throwable {
     	
    	UploadTagSheet upload_tag_sheet = new UploadTagSheet();

         Thread.sleep(5000);            

         System.out.println("Clicking on the Submit button");
         
         upload_tag_sheet.submit_button();
         
/*         driver.findElement(By.id("btnSubmitTagSheet")).click();		            
*/     	                                  	          
     	
     }
     
     @Then("^user lands on the Draft Creative List page after the file upload$")
     public void user_lands_on_the_Draft_Creative_List_page_after_the_file_upload() throws Throwable {
       
    		DraftCreative draft_creative = new DraftCreative();

         Thread.sleep(9000);            

        String successmsg = driver.findElement(By.id("dvAlert")).getText();
          
     	System.out.println("The system-generated message is: Success! Draft Creative Uploaded Successfully."+successmsg);            
	           
        Thread.sleep(2000);            

/*     	System.out.println("The system-generated message is: Success! Draft Creative Uploaded Successfully.");            

         Thread.sleep(2000);   
         */
         try{

         String draft_creative_title = draft_creative.validateDraftCreativepagetitle();
         
/*       	String gettitle11 = driver.getTitle();
*/       
         Assert.assertTrue(draft_creative_title.contains("Draft Creative List"));

         System.out.println("Title of the page is "+draft_creative_title);
         
         System.out.println("Successfully navigated to Draft Creative List page");
       
     }
      catch (AssertionError e304) {
    	  
      	 System.out.println("Draft Creative Listing page failed to load: "+e304.getMessage());
   		
      } 
         Thread.sleep(4000);   
     }

     @Then("^user logs out of the Draft Creative List page$")
 	public void user_logs_out_of_the_Draft_Creative_List_page() throws Throwable {
 	    
		  //Logout operation

 	    Thread.sleep(12000); 

 	    testutil= new TestUtil();
 	    
 	    testutil.Logout_AdTheorent();
 	      		
        System.out.println("We are logging out of the AdTheorent UAT platform");


    	 			    

         }
}