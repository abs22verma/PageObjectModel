package com.demoqa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String[][] getExcelData(String fileName, String sheetName){
		
		String data[][] = null;
		try {
		FileInputStream file = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);
		int numOfRow = sheet.getPhysicalNumberOfRows();
		int numOfCols = row.getLastCellNum();
		
		Cell cell;
		
		data = new String[numOfRow-1][numOfCols];
		
		for(int i =1;i<numOfRow;i++) {
			for(int j=0;j<numOfCols;j++) {
				row = sheet.getRow(i);
				cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			}
			
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
