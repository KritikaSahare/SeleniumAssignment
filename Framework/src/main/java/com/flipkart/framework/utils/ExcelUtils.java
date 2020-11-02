package com.flipkart.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.objects.exceptions.ScriptException;

public class ExcelUtils {
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static Map<String, Integer> dict = new HashMap<String, Integer>();
	private static FileInputStream excelFile;
	
	/**
     * Get Excel Workbook, Sheet objects to get Data using location on local drive, and sheet name under scanner.
     *
     * @param filePath location of the file in local system
     * @param fileName name of the .xlsx file.
     * @param sheetName name of the sheet that we want to access in the .xlsx file
	 * 
     * 
     */
	
	public static void loadExcelFile(String filePath,String fileName,String sheetName) throws Exception
	{
		try {
			excelFile = new FileInputStream(filePath+"\\"+fileName);
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			for(int col=0;col<ExcelWSheet.getRow(0).getLastCellNum();col++)
				try {
					dict.put(ExcelUtils.getCellData(0, col), col);
				} catch (Exception e) {
					throw new Exception(e);
				}
		} catch (FileNotFoundException e) {
			throw new ScriptException("File wasn't found in given path.");
		}
		catch (Exception e) {
			throw new ScriptException("Failed to load the Excel file, create Workbook and blank sheet.");
		} 
	}

	
	/**
     * Get Cell contents by location of cell in sheet. Location determined by Row Number & Column Number.
     *
     * @param rowNum which determines the row at which the cell is located.
     * @param colNum which determines the column at which the cell is located.
	 * @throws Exception 
     * 
     */
	
	public static String getCellData(int rowNum,int colNum) throws Exception 
	{
		try {
			Row = ExcelWSheet.getRow(rowNum);
			DataFormatter format = new DataFormatter();
			Cell = Row.getCell(colNum);
			String cellData = format.formatCellValue(Cell);
			return cellData;
		} catch (Exception e) {
			throw new ScriptException("Unable to fetch data from "+rowNum+1+"th row, and "+colNum+1+"th column.");
		}
	}
	
	/**
     * Returns the Column number with the column Name colName.
     *
     * @param colName Name of the Column/Column header.
     * 
     */
	public static int getColIndexByColName(String colName) throws Exception {
		int value;
		try {
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (Exception e) {
			throw new ScriptException("Unable to get Column index with colum name header: "+colName+". It's possible no such column exists.");
		}
	}
	
	/**
     * Returns total number of Rows in the sheet.
     * 
     */
	public static int getRowCount() throws Exception {
		try {
			return ExcelWSheet.getLastRowNum();
		} catch (Exception e) {
			throw new ScriptException("Unable to fetch total number of rows in the sheet.");
		}
	}
	
	/**
     * Get Cell Address. Returns in the form of 'A3' format.
     *
     * @param rowNum which determines the row at which the cell is located.
     * @param colNum which determines the column at which the cell is located.
     */
	public static String getCellAddress(int rowNum, int colNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(rowNum);
			Cell = Row.getCell(colNum);
			return Cell.getAddress().toString();
		} catch (Exception e) {
			throw new ScriptException("Unable to get Cell address of "+rowNum+1+"th row, and "+colNum+"th column.");
		}
	}
		
	/**
     * Set data in cell whose address is determined by corresponding row number and column number.
     *
     * @param value which we want to input into the Cell
     * @param rowNum which determines the row at which the cell is located.
     * @param colNum which determines the column at which the cell is located.
     */
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public static void setCellData(String value, int rowNum, int colNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(rowNum);
			Cell = Row.getCell(colNum);
			if(Cell == null) {
				Cell = ExcelWSheet.getRow(rowNum).createCell(colNum);
				Cell.setCellType(Cell.CELL_TYPE_STRING);
				Cell.setCellValue(value);
			} else {
				Cell.setCellValue(value);
			}
		} catch (Exception e) {
			throw new ScriptException("Unable to set '"+value+"' in "+rowNum+1+"th row's"+colNum+"th column.");
		}
	}
	
	/**
     * Writes data into the sheet, and closes all Excel instances.
     *
     * @param filePath location of the file in local system
     * @param fileName name of the .xlsx file.
     * 
     */
	public static void excelTearDown(String filePath, String fileName) throws Exception{
		ScriptLogger.info();
		try {
			excelFile.close();
			FileOutputStream fileOut = new FileOutputStream(filePath+"\\"+fileName);
			ExcelWBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			throw new ScriptException("Unable to close Excel file instances, and write data into the same.");
		}	
	}

}
