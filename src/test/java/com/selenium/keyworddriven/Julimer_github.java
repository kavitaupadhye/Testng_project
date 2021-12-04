package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.assignment_julimer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Julimer_github 
{
	assignment_julimer aj=new assignment_julimer();
 
  @BeforeTest
  public void beforeTest()
  {
	 aj.openBrowser("chrome"); 
	 aj.callPageFactory_assignment_julimer();
  }

  
  @Test
  public void f() throws Exception 
  {
	  aj.openAppllicationUrl();
	  aj.enterValueTextBox(aj.num1_Textbox, "5");
	  aj.selectFromDropDownList(aj.sign_dropDownList, "+");
	  aj.enterValueTextBox(aj.num2_Textbox, "5");
	  aj.clickButton(aj.go_Btn);
	  aj.waitInSec(4);
	  
  }
  
  
  @AfterTest
  public void afterTest() 
  {
	  aj.closeBrowser();
  }

}
