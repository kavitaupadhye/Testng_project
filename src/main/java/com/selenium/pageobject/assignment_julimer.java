package com.selenium.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment_julimer 
{
	
	WebDriver w;
	String url="https://juliemr.github.io/protractor-demo/";
	
	@FindBy(xpath="/html/body/div/div/form/input[1]")
	public WebElement num1_Textbox;
	
	@FindBy(xpath="/html/body/div/div/form/select")
	public WebElement sign_dropDownList;
	
	@FindBy(xpath="/html/body/div/div/form/input[2]")
	public WebElement num2_Textbox;
	
	@FindBy(id="gobutton")
	public WebElement go_Btn;
	
	
	public void openBrowser(String browser)
	{
	     if(browser.equalsIgnoreCase("chrome"))	
	     {
	    	 WebDriverManager.chromedriver().setup();
	    	 w=new ChromeDriver();
	    	 w.manage().window().maximize();
	    	 w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     }
	     else if(browser.equalsIgnoreCase("firefox"))
	     {
	    	 WebDriverManager.firefoxdriver().setup();
	    	 w=new FirefoxDriver();
	    	 w.manage().window().maximize();
	    	 w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    	 
	     }
	     
	}
	
	public void closeBrowser()
	{
		w.quit();
	}
	
	public void  openAppllicationUrl()
	{
		w.get(url);
	}
	
	public void  enterValueTextBox(WebElement we,String Value)
	{  
		we.clear();
		we.sendKeys(Value);
		
	}
	
	public void  clickButton(WebElement we)
	{
		we.click();
		
	}
	
	public void selectFromDropDownList(WebElement we,String Value)
	{
		Select sel=new Select(we);
		sel.selectByVisibleText(Value);
	}
	
	public void waitInSec(int sec) throws Exception
	{
		Thread.sleep(sec*1000);
	}
	
	public void callPageFactory_assignment_julimer ()
	{
		
		PageFactory.initElements(w,this);
	}
	
	
	

}
