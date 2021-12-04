package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SearchSnapdeal 
{
	WebDriver w;
  
  @BeforeTest
  public void beforeTest()
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromeDriver.exe");
	  w= new ChromeDriver();
	  
  }
  
  @Test (description="Search Snapdeal in search button")
  public void snapdealSearch() throws Exception 
  {
	 w.get("https://www.google.com/");
	 WebElement p= w.findElement(By.name("q"));
	 p.sendKeys("Snapdeal");
	 p.submit();
	 w.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div[1]/div/div/div/span[2]/a")).click();
	 w.findElement(By.id("searchInput")).sendKeys("News");
	 w.findElement(By.id("searchButton")).click();
	 w.findElement(By.xpath("//*[@id=\"ca-history\"]/a/span")).click();
	 Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
