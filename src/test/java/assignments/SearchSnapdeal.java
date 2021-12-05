package assignments;

//import java.util.concurrent.TimeUnit;

//1. Write Java……WebDriver test for the following using Chrome browser.
//a. Search for "Snapdeal" keyword on Google search engine.
//b. Click on "Wikipdedia" link from right.
//c. Under "Search Wikipdedia" -> Enter "News" and Click on search icon
//d. Click on "View history" link

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSnapdeal {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Hello Selenium 1");
	   String projectPath=System.getProperty("user.dir");
	   System.out.println(projectPath);
	   System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromeDriver.exe");
	   WebDriver driver=new ChromeDriver();
	//   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.get("https://www.google.com/");
	      // identify element
	     // WebElement p=driver.findElement(By.name("q"));
	      WebElement p=  driver.findElement(By.name("q"));
	      //enter text with sendKeys() then apply submit()
	      p.sendKeys("Snapdeal");
	      // Explicit wait condition for search results
	     // WebDriverWait w = new WebDriverWait(driver, 5);
	     // w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	     p.submit();
	      
	      driver.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div[1]/div/div/div/span[2]/a")).click();
	      driver.findElement(By.id("searchInput")).sendKeys("News");
	      driver.findElement(By.id("searchButton")).click();
	      driver.findElement(By.xpath("//*[@id=\"ca-history\"]/a/span")).click();
	      Thread.sleep(2000);
	      

	      driver.close();

	 
	   
	}

}
