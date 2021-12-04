package assignments;
//2. Write TestNG/WebDriver test for the following using Firefox:- Search for "Snapdeal" keyword on Google search engine.
//a. Verify page title is "Snapdeal - Google Search" .
//b. Verify on right panel "Snapdeal" name.
//c. Click on "Wikipdedia" and verify Page title "Snapdeal - Wikipedia"

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


/*
 * @Author AutomtionTest
 *  Assignment on Hard and Softassert
 * 
 */
public class GoogleSearch
{
	WebDriver w;
 
  @BeforeTest
  public void beforeTest()
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.gecko.driver",projectPath+"\\BrowserDriver\\geckodriver.exe");
	  w=new FirefoxDriver();
	 
  }
  
  
  @Test(priority=0,description="Verify home page of firefox browser and open google page ")
  public void homePage() throws Exception
  {
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
  }
  
  @Test(priority=1,description="Search for Snapdeal keyword on Google search engine")
  public void searchSnapdeal() throws Exception
  {
	  WebElement search= w.findElement(By.name("q"));
	  search.sendKeys("Snapdeal");
	  search.submit();
	  Thread.sleep(2000);
	  String pageTitle=w.getTitle();
	  System.out.println(pageTitle);
	  //Assert.assertTrue(pageTitle.contains("Snapdeal - Google Search"));
	  Assert.assertEquals(pageTitle,  "Snapdeal - Google Search");
	 
	  Thread.sleep(2000);
	  
	  WebElement rightPanel= w.findElement(By.xpath("//*[@id=\"mh_tsuid61\"]/div/div/div[2]/h2/span"));
	  Assert.assertEquals(rightPanel.getText(), "Snapdeal");
  }
  
  @Test(priority=2,description="Verify Wikipedia function ")
  public void wikipedia() throws Exception 
  {
	  w.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div[1]/div/div/div/span[2]/a")).click();
	  Thread.sleep(2000);
	  String pageTitle=w.getTitle();
	  
	  System.out.println(pageTitle);
	  Assert.assertTrue(pageTitle.contains("Snapdeal - Wikipedia"));
	  Thread.sleep(2000);
  }
  
  

  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
