package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestCase
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
  
  @Test  (priority=0,description= "Test case to verify 'admin' login functionality",groups="Login",enabled=true)
  public void loginAdmin() throws Exception 
  {
	    w.get("http://www.altoromutual.com/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		Thread.sleep(2000);  //2000 milisec=2sec
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);  //2000 milisec=2sec
  }
  
  //invocationCount=2 means we run one test case for 2 times
  @Test  (priority=1,description= "Test case to verify 'tuser' login functionality",dependsOnMethods="loginAdmin",invocationCount=1)
  public void loginTestUser() throws Exception 
  {
	    w.get("http://www.altoromutual.com/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		
		Thread.sleep(2000);  //2000 milisec=2sec
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);  //2000 milisec=2sec
  }
  
  @Test  (priority=2,description= "Test case to verify 'sspeed' login functionality",dependsOnMethods="loginAdmin")
  public void loginSpeed() throws Exception 
  {
	    w.get("http://www.altoromutual.com/login.jsp");
		w.findElement(By.id("uid")).sendKeys("sspeed");
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		
		Thread.sleep(2000);  //2000 milisec=2sec
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);  //2000 milisec=2sec
  }

  @AfterTest
  public void afterTest()
  {
	  w.quit();
		
  }

}
