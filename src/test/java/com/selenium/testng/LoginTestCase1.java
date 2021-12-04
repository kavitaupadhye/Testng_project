package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestCase1
{
	WebDriver w;
 
  @BeforeTest
  public void beforeTest()                                           // before test case means precondition
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
	  w=new ChromeDriver();
  }

  
  @Test (description="Verify login and logout functionality")
  public void loginLogout() throws Exception
  {
	  w.get("https://www.testyou.in/Login.aspx");
	  w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");	
	  w.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");
	  w.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
	  w.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();
	  Thread.sleep(2000);
	  //w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	 // Thread.sleep(2000);
	  
  }
  
  
  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
