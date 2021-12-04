package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


/*
 * @Author AutomtionTest
 *  This class contain code for hard assert
 * 
 */
public class HardAssertTest 
{
	WebDriver w;
 
  @BeforeTest
  public void beforeTest()
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
	  w=new ChromeDriver();
  }
  
  
  @Test(priority=0,description="To verify home page functionality")
  public void homePageTest() throws Exception
  {
	  w.get("https://www.zoopla.co.uk/");
	  String pageTitle=w.getTitle();
	  System.out.println(pageTitle);
	  String pageUrl=w.getCurrentUrl();
	  System.out.println(pageUrl);
	  
      WebElement searchbutton = w.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button"));
		 
	  
	  Assert.assertTrue(pageTitle.contains("Zoopla") ,"Title does not contain Zoopla");
	  Assert.assertEquals(pageUrl,"https://www.zoopla.co.uk/");
	  Assert.assertTrue(searchbutton.isDisplayed() ,"search button is not present");
  }
  

  @Test(priority=1,description="To verify search functionality")
  public void verifySearchTest() throws Exception
  {
	 
	  w.findElement(By.id("header-location")).sendKeys("London");
	  w.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button")).click();
	  Thread.sleep(2000);
	  
	  String pageTitle=w.getTitle();
	  System.out.println(pageTitle);
	  WebElement pageLable=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[1]/h1"));
	  
	  Assert.assertTrue(pageTitle.contains("London"), "page title does not contains London");
	  Assert.assertEquals(pageLable.getText(), "Property for sale in London");
  }
  
  
  @Test(priority=2,description="To verify property detail functionality")
  public void propertyDetailTest() throws Exception
  {
	  String priceExpected=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[2]")).getText();
	  String houseExpexted=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[1]")).getText();
	  String locationExpected=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[3]")).getText();
	  
	  
	 
	  w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[1]")).click();
	  Thread.sleep(2000);
	  
	  
	  WebElement priceActual=w.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[1]/section[1]/div[1]/div[2]/span"));
	  WebElement houseActual=w.findElement(By.xpath("//*[@id=\"listing-summary-details-heading\"]/span[1]"));
	  WebElement locationActual=w.findElement(By.xpath("//*[@id=\"listing-summary-details-heading\"]/span[2]"));
	  
	  Assert.assertEquals(priceActual.getText().trim(), priceExpected);
	  Assert.assertEquals( houseActual.getText().trim(), houseExpexted);
	  Assert.assertEquals(locationActual.getText().trim(), locationExpected);
	  
	  System.out.println(priceActual.getText().trim()+" "+priceExpected);
	  System.out.println( houseActual.getText().trim()+" "+ houseExpexted);
	  System.out.println(locationActual.getText().trim()+" "+locationExpected);
	  
	  
	  
	  
  }
  
  

  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
