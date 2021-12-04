package com.selenium.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDeposit_PageObj extends TestBase{
	

	@FindBy(id = "principal")
	public WebElement principal_TextBox;

	@FindBy(name = "interest")
	public WebElement interest_TextBox;

	@FindBy(id = "tenure")
	public WebElement tenure_TextBox;

	@FindBy(name = "tenurePeriod")
	public WebElement tenurePeriod_dropDownList;

	@FindBy(id = "frequency")
	public WebElement frequency_dropDownList;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculate_Btn;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")
	public WebElement clear_Btn;

	@FindBy(xpath = "//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;

	
	public void callPageFactory_FixedDeposit() {

		PageFactory.initElements(w, this);

	}

}
