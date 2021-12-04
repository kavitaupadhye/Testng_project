package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject 
{
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
  }
  
  
  @Test(priority=0, description="Test case to handle textbox")
  public void handleTxtBox() throws Exception
  {
	  w.get("http://demo.automationtesting.in/Register.html");
	  Thread.sleep(2000);
	  
	  //first name
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).clear();
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Jonnes");
	  
	  
	  //last name
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).clear();
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Smith");
	  
	  
	  //Address
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).clear();
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Pune");
	  
	  
	  
	  //Email
	  w.findElement(By.xpath("//*[@id=\"eid\"]/input")).clear();
	  w.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("Testbox@gmail.com");
	  
	  
	  //phone
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).clear();
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("9898989898");
	  
	  //Gender
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")).click();
	  
	  
	  //hobbies
	  w.findElement(By.id("checkbox1")).click();
	  w.findElement(By.id("checkbox2")).click();
	  w.findElement(By.id("checkbox3")).click();
	  
  }
  
  @Test(priority=1, description="Test case to radio button")
  public void handleRadioButton() throws Exception
  {
	
	  
	  //Gender
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")).click();
	  
	  
	  //hobbies
	  w.findElement(By.id("checkbox1")).click();
	  w.findElement(By.id("checkbox2")).click();
	  w.findElement(By.id("checkbox3")).click();
	  
  }
  @Test(priority=2, description="Test case to checkbox")
  public void handleCheckBox() throws Exception
  {
	
	  
	  
	  //hobbies
	  w.findElement(By.id("checkbox1")).click();
	  w.findElement(By.id("checkbox2")).click();
	  w.findElement(By.id("checkbox3")).click();
	  
  }
  
  @Test(priority=3, description="Test case to haandle dropdown list")
  public void handleDropdownList() throws Exception
  {
	  
	  WebElement  skillsdropdown=w.findElement(By.id("Skills"));
	//Dropdown list
	  Select sel=new Select(skillsdropdown);
	  
	  // select By index
	  sel.selectByIndex(9);
	  
	  //select by value
	 // sel.selectByValue("Analytics");
	  
	  // select by visible text
	 // sel.selectByVisibleText("Java");
	  
	 
  }
  
  
  

  @AfterTest
  public void afterTest() {
  }

}
