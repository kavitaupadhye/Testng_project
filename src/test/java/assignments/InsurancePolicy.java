package assignments;
//1. Open "https://www.policyx.com/" in Chrome using TestNG /WebDriver script.
//a. Verify Label on page is equal to "India's Most Trusted Insurance Portal"
//b. Verify page title contains "Insurance" text .
//c. On-clicking "Claim", and verify Page label is “CLAIM ASSISTANCE”
//d . Verify page title contains "Claim Process"


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



/*
 * @Author AutomtionTest
 *  Assignment on Hard and Softassert
 * 
 */
public class InsurancePolicy
{
  
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() 
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe" );
	  w=new ChromeDriver();
	  
  }
  
  @Test(priority=0,description="To verify home page functionality")
  public void homePage() throws Exception 
  {
	  w.get("https://www.policyx.com/");
	  WebElement pageLabel=w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/h1"));
	  Assert.assertEquals(pageLabel.getText(), "India's Most Trusted Insurance Portal");
	  String pageTitle=w.getTitle();
	  System.out.println(pageTitle);
	  Assert.assertTrue(pageTitle.contains("Insurance"),"Title does not contain Insurance");
	  Thread.sleep(2000);
	 
	  
  }
  
  @Test(priority=1,description="To verify Claim functionality")
  public void claim() throws Exception 
  {
	w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a")).click();
	Thread.sleep(2000);
	WebElement pageLabel=w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1"));
    Assert.assertEquals(pageLabel.getText(), "CLAIM ASSISTANCE");
    String pageTitle=w.getTitle();
    System.out.println(pageTitle);
    Assert.assertTrue(pageTitle.contains("Claim Process"),"Title does not contain Claim Process");
	
  }
  

  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
