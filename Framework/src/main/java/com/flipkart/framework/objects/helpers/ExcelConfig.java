package com.flipkart.framework.objects.helpers;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.objects.exceptions.ApplicationException;
import com.flipkart.framework.utils.ExcelUtils;

public class ExcelConfig {
	public static int rowCount;
	public static int failCount;
	
	@BeforeTest
	@Parameters({ "filePath", "fileName", "sheetName" })
	public static void setExcelFile(@Optional("E:\\TestData") String filePath, String fileName,
			@Optional("Sheet1") String sheetName) throws Exception {
		ScriptLogger.info();
		ExcelUtils.loadExcelFile(filePath, fileName, sheetName);
		System.out.println("before Test of excel config");
		
	}
	
	@AfterTest
	@Parameters({"filePath", "fileName"})
	public static void setStatusAndCloseExcel(@Optional("E:\\TestData") String filePath, String fileName) throws Exception {
		ScriptLogger.info();
		setStatus();
		evaluateStatus();
		ExcelUtils.excelTearDown(filePath, fileName);
		if(failCount > 0) {
			ScriptLogger.debug("Number of Failed Data sets: " +failCount);
			throw new ApplicationException("There are failed data sets. Please check Excel Sheet.");
		}
		System.out.println("After Test of excel config");
	}
	
	private static void setStatus() throws Exception {
		ScriptLogger.info();
		int expectedCol = ExcelUtils.getColIndexByColName("Expected Result"), 
				actualCol = ExcelUtils.getColIndexByColName("Actual Result"), 
				statusCol=ExcelUtils.getColIndexByColName("Status");
		rowCount = ExcelUtils.getRowCount();
		System.out.println("Number of rows setting final status to: "+rowCount);
		for(int row = 1; row <= rowCount; row++) {
			String expected = ExcelUtils.getCellData(row, expectedCol);
			String actual = ExcelUtils.getCellData(row, actualCol);
			if(expected.equalsIgnoreCase(actual)) {
				ExcelUtils.setCellData("PASS", row, statusCol);
				System.out.println("PASS was set in cell address: " +ExcelUtils.getCellAddress(row, statusCol));
			} else {
				ExcelUtils.setCellData("FAIL", row, statusCol);
				System.out.println("FAIL was set in cell address: " +ExcelUtils.getCellAddress(row, statusCol));
			}
		}
		
	}
	
	
	private static void evaluateStatus() throws Exception {
		ScriptLogger.info();
		failCount = 0;
		for(int row = 1; row <= rowCount; row++) {
			String status = ExcelUtils.getCellData(row, ExcelUtils.getColIndexByColName("Status"));
			if(status.equalsIgnoreCase("FAIL")) {
				failCount++;
			} 
		}		
	}
}
