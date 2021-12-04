package com.silenium.datadriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDeposit_PageObj;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class FD_DataDriven {
	FixedDeposit_PageObj fd;
	
	 FileInputStream fin;
	 XSSFWorkbook wb;
	 XSSFSheet sheet;
	 XSSFRow row;
	 XSSFCell cell_principle,cell_ROI,cell_period,cell_frequency;
	 
	 
	 
	 @BeforeTest
	  public void beforeTest() throws Exception 
	  {
		  fd=new  FixedDeposit_PageObj();
		  fd.openBrowser(fd.readPropertiesFile_Value("browser"));		  
		  fd.callPageFactory_FixedDeposit();
		 
		  String excelFilePath= System.getProperty("user.dir")+"\\TestData\\FDCal.xlsx";;
			
			
		 fin=new FileInputStream(excelFilePath);
		 
		 wb=new XSSFWorkbook(excelFilePath);
		 sheet=wb.getSheet("Sheet1");
		  
		  
		  
		  
	  }
	  
	  
	  @Test(priority=0,description="Validate Fixed Deposite Functionality")
	  public void FixedDeposite_DataDriven() throws Exception
	  {
		  
		  int rowCount=sheet.getLastRowNum(); // last number of row
		  
		  
		  for(int i=1;i<=rowCount;i++)  //i=rows
		  {
			  
			  DataFormatter df=new DataFormatter();
			  
			  row=sheet.getRow(i);
			 // int j=0; // j=column
			  
			  cell_principle=row.getCell(0);
			  cell_ROI=row.getCell(1);
			  cell_period=row.getCell(2);
			  cell_frequency=row.getCell(3);
			  
			  
			  
		  
		  fd.openApplicationURL(fd.readPropertiesFile_Value("url"));
		  
		  fd.enterValueTextBox(fd.principal_TextBox,df.formatCellValue(cell_principle).toString());
		  fd.enterValueTextBox(fd.interest_TextBox,df.formatCellValue(cell_ROI).toString());
		  fd.enterValueTextBox(fd.tenure_TextBox,df.formatCellValue(cell_period).toString());
		  
		  fd.selectFromDropDown(fd.tenurePeriod_dropDownList,"year(s)");
		  fd.selectFromDropDown( fd.frequency_dropDownList,df.formatCellValue(cell_frequency).toString());
		 
		  fd.clickButton(fd.calculate_Btn);
		 
		  fd.waitInSec(4);
		  
		  
		  }
		  
	  }
	  

	  @AfterTest
	  public void afterTest() 
	  {
		  fd.closeBrowser();
	  }

}
