package assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Flipkart
{
	WebDriver w;
 
  @BeforeTest
  public void searchFlipkart() 
  {
	  String projectPath=System.getProperty("user.dir");
	  System.out.println(projectPath);
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromeDriver.exe");
	  w=new ChromeDriver();
  }
  
  @Test
  public void flipkart() throws Exception 
  {
	  w.get("https:\\www.google.com");
	  WebElement p=w.findElement(By.name("q"));
	  p.sendKeys("Flipkart");
	  p.submit();
	  w.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div[1]/div/div/div/span[2]/a")).click();
	  w.findElement(By.name("search")).sendKeys("Clothing in India");
	  w.findElement(By.name("go")).click();
	  Thread.sleep(2000);
	  
  }
  
  

  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
