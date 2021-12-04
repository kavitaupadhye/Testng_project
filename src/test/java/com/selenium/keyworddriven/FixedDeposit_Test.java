package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDeposit_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageobject.ListenerCode.class)

public class FixedDeposit_Test {

	FixedDeposit_PageObj fd;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd = new FixedDeposit_PageObj();
		
		fd.openBrowser(fd.readPropertiesFile_Value("browser"));
		
		
		fd.callPageFactory_FixedDeposit();
	}

	@Test(priority = 0,description = "Fixed depost for 10000")
	public void FixedDeposit_10000() throws Exception {

		fd.openApplicationURL(fd.readPropertiesFile_Value("url"));
		
		fd.enterValueTextBox(fd.principal_TextBox, "100000");
		fd.enterValueTextBox(fd.interest_TextBox, "6");
		fd.enterValueTextBox(fd.tenure_TextBox, "3");

		fd.selectFromDropDown(fd.tenurePeriod_dropDownList, "year(s)");
		fd.selectFromDropDown(fd.frequency_dropDownList, "Simple Interest");

		fd.clickButton(fd.calculate_Btn);

		fd.waitInSec(4);

	}
	
	
	@Test(priority = 1,description = "Fixed depost for 20000")
	public void FixedDeposit_20000() throws Exception {

		fd.openApplicationURL(fd.readPropertiesFile_Value("url"));
		
		fd.enterValueTextBox(fd.principal_TextBox, "200000");
		fd.enterValueTextBox(fd.interest_TextBox, "4");
		fd.enterValueTextBox(fd.tenure_TextBox, "1");

		fd.selectFromDropDown(fd.tenurePeriod_dropDownList, "year(s)");
		fd.selectFromDropDown(fd.frequency_dropDownList, "Simple Interest");

		fd.clickButton(fd.calculate_Btn);

		fd.waitInSec(4);
		
		//Assert.fail();

	}


	@AfterTest
	public void afterTest() {

		fd.closeBrowser();
	}

}
