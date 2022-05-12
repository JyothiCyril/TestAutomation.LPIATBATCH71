package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	public static FileInputStream fileLoc;
	public static XSSFWorkbook wBook;
	public static XSSFSheet xSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	// 1. method that can get the row count
	
	public static int getRowCount(String xFile, String xSheetName) throws IOException {
		fileLoc = new FileInputStream(xFile);
		wBook = new XSSFWorkbook(fileLoc);
		xSheet = wBook.getSheet(xSheetName);
		int rowCount = xSheet.getLastRowNum();
		return rowCount;
		
	}
	
	// 2. method that can get the cell count
	
	public static int getCellCount(String xFile, String xSheetName,int rowNum) throws IOException {
		fileLoc = new FileInputStream(xFile);
		wBook = new XSSFWorkbook(fileLoc);
		xSheet = wBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}
	
	
	// 3. method to get the cell data from each cell in a String format.
	public static String getCellData(String xFile, String xSheetName,int rowNum, int cellNum) throws IOException {
		fileLoc = new FileInputStream(xFile);
		wBook = new XSSFWorkbook(fileLoc);
		xSheet = wBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		
		String cellData = format.formatCellValue(cell);
		
		fileLoc.close();
		wBook.close();
		
		return cellData;
		
	}

}
