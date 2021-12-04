package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class BrowserCode 
{
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() throws Exception
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
	  w=new ChromeDriver();
	  Thread.sleep(2000);
	  w.quit();
  }

  @Test(priority=0,description="Test firefox browser")
  public void firefoxBrowser() throws Exception
  {
	  String projectPath=System.getProperty("user.dir");
      System.out.println(projectPath);
	  System.setProperty("webdriver.gecko.driver",projectPath+"\\BrowserDriver\\geckodriver.exe");
	  w=new FirefoxDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  w.quit();
	  
  }
  @Test(priority=1,description="Test edge browser")
  public void edgeBrowser() throws InterruptedException
  {
	  String projectPath=System.getProperty("user.dir");
      System.out.println(projectPath);
	  System.setProperty("webdriver.edge.driver",projectPath+"\\BrowserDriver\\msedgedriver.exe");
	  w=new EdgeDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	 
	  
  }
  
  
  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
