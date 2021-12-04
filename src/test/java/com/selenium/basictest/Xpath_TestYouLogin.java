package com.selenium.basictest;
//Open "http://www.testyou.in/Login.aspx" in Chrome using Java…..WebDriver script.
//a. Enter username "Selenium99" and password "Selenium99"
//b. Click on login button
//c. Click on logout button (using xpath)
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_TestYouLogin {

	public static void main(String[] args) throws Exception                                                                                     // Throws exception for thread
	{
		String projectPath=System.getProperty("user.dir");                                                                                      // To get project path        
		System.out.println(projectPath);                                                                                                        // Print project path
		System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");                                          // Set project path to chrome browser 
		WebDriver w=new ChromeDriver();                                                                                                         // Create interface object(Webdriver is interface)
		
		w.get("https://www.testyou.in/login.aspx");                                                                                              // Enter url
		w.findElement(By.xpath("/html/body/form/div[6]/div[1]/div/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/input")).sendKeys("Selenium99");   // Enter user name by using full xpath
		//w.findElement(By.xpath("//*[@id=\"ctl00_CPHContainer_txtUserLogin\"]")).sendKeys("Selenium99");                                       // Enter user name by using short xpath
		w.findElement(By.xpath("/html/body/form/div[6]/div[1]/div/div[3]/div/div[2]/div[1]/div[3]/div[2]/div[1]/input")).sendKeys("Selenium99");// Enter password by using full xpath
		//w.findElement(By.xpath("//*[@id=\"ctl00_CPHContainer_txtPassword\"]")).sendKeys("Selenium99");                                        // Enter password by using short xpath
		w.findElement(By.xpath("/html/body/form/div[6]/div[1]/div/div[3]/div/div[2]/div[1]/div[5]/div[1]/input")).click();                      // Click on login button (using full xpath)  
		//w.findElement(By.xpath("//*[@id=\"ctl00_CPHContainer_btnLoginn\"]")).click();                                                         // Click on login button (using short xpath) 
		Thread.sleep(2000);                                                                                                                     // Given sleep time(2000)
		w.findElement(By.xpath("/html/body/form/div[3]/div[1]/div/div/div[1]/div/div/div[2]/a")).click();                                       // Click on logout button (using full xpath) 
		//w.findElement(By.xpath("//*[@id=\"ctl00_headerTopStudent_lnkbtnSignout\"]")).click();                                                 // Click on logout button (using short xpath) 
		
		w.quit();                                                                                                                               // quit the window
		
	}

}
