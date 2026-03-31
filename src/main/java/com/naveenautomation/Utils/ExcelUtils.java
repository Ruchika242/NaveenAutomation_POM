package com.naveenautomation.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomation.testbase.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi;// This fi is the variable through which we are reading the excel file
	public static XSSFWorkbook wb;// This wb is the object for workbook
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String fileName, String sheet) throws Exception {
		int rowCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}

	public static int getCellCount(String fileName, String sheet, int rowCount) throws Exception {
		int cellCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCount);
		cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;

	}
	
	public static String getCellData(String fileName, String sheet, int rowCount, int cellCount) throws Exception {
		String data=null;
		
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCount);
		cell = row.getCell(cellCount);
		data = String.valueOf(cell);
		wb.close();
		fi.close();
		return data;
		
		
	}
	
	
		
		
		
	}
	
	

