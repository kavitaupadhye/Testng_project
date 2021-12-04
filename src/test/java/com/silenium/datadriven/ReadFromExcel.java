package com.silenium.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static void main(String[] args) throws Exception
	{
        
		String excelFilePath= System.getProperty("user.dir")+"\\TestData\\testdata.xlsx";;
		
		
		FileInputStream fin=new FileInputStream(excelFilePath);
		
		
		 XSSFWorkbook wb=new XSSFWorkbook(fin);
	     XSSFSheet sheet=wb.getSheet("sheet1");
	     XSSFRow row=sheet.getRow(0);
	     XSSFCell cell=row.getCell(0);
	     System.out.println(cell);
	          
	                 //or
	   // System.out.println(sheet.getRow(0).getCell(0));
		         
	    
		
		
		fin.close();
		
	}

}
