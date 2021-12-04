package com.silenium.datadriven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FD_DataProvider {
	
	WebDriver w;
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {" 100000", "7", "4" },
      new Object[] { "200000", "8", "3" },
      new Object[] { "400000", "6", "1" },
    };
  }
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
	 
	  
	
	  
  }

  
  @Test(dataProvider = "dp")
  public void f(String principal,String rate_of_interest,String period) throws Exception
  
  {
	 
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html\n");
	  w.findElement(By.id("principal")).sendKeys(principal);
	  w.findElement(By.name("interest")).sendKeys(rate_of_interest);
	  w.findElement(By.id("tenure")).sendKeys(period);
	  Thread.sleep(3000);
	  
	  w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
	  
	  Thread.sleep(3000);
  }
  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
