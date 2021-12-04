package com.selenium.basictest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestClass {

	public static void main(String[] args) 
	{
		
		
		
        //Get current project path
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		
		//Set Driver Property
		// 2 parameter    (which driver,path of driver)
		System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
		
		
		
		//Webdriver compiler to open chrome driver
		WebDriver w=new ChromeDriver();
		
		System.out.println("Blank Browser Opened");
		
		w.quit();
	}

}
