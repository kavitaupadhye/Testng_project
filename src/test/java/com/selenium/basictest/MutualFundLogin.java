package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MutualFundLogin {

	public static void main(String[] args) throws Exception
	{
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
		WebDriver w=new ChromeDriver();
		
		w.get("http://www.altoromutual.com/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		Thread.sleep(2000);  //2000 milisec=2sec
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);  //2000 milisec=2sec
		
		w.quit();
		
		

	}

}
