package com.agiloft.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class ExcelDataProvider {

	@DataProvider(name = "getExcelDataByKeys")
	public static Object[][] getData(Method method) {
		int iterationcount = 0;
		Object[][] data = null;
		try {
			//for reading initialization of Test Data sheet
			FileInputStream fis = new FileInputStream("./testData/TestDataSheet.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int fullRowCount = sheet.getLastRowNum();
			int fullColumnCount = 0;
			String name = method.getName();
			for(int i=0;i<=fullRowCount;i++){
				String testName = sheet.getRow(i).getCell(0).getStringCellValue();
				if(name.equals(testName)){
					fullColumnCount=sheet.getRow(i-1).getLastCellNum();
					break;
				}
			}
			System.out.println("Column Count: "+fullColumnCount);
			// To count number of iterations
			for (int i = 0; i <= fullRowCount; i++) {
				String testName = sheet.getRow(i).getCell(0).getStringCellValue();
				if (name.equals(testName)) {
					String testCondition = sheet.getRow(i).getCell(1).getStringCellValue();
					if (testCondition.equalsIgnoreCase("Yes")) {
						iterationcount = iterationcount + 1;
					}
				}
			}
			System.out.println("No of Iterations :"+iterationcount);
			data = new Object[iterationcount][1];
			// for generating keys
			ArrayList<Object> list = new ArrayList<Object>();
			for (int i = 0; i <= fullRowCount; i++) {
				String testName = sheet.getRow(i).getCell(0).getStringCellValue();
				if (name.equals(testName)) {
					String testCondition = sheet.getRow(i).getCell(1).getStringCellValue();
					if (testCondition.equalsIgnoreCase("Yes")) {
						for (int j = 2; j < fullColumnCount; j++) {
							String columnName = sheet.getRow(i - 1).getCell(j).getStringCellValue().trim();
							list.add(columnName);
						}
						break;
					}
				}
			}
			int limiter = 0;
			// loading values to map from excel
			for (int i = 0; i <= fullRowCount; i++) {
				HashMap<Object, Object> map = new HashMap<Object, Object>();
				String testName = sheet.getRow(i).getCell(0).getStringCellValue();
				if (name.equals(testName)) {
					String testCondition = sheet.getRow(i).getCell(1).getStringCellValue();
					if (testCondition.equalsIgnoreCase("Yes")) {
						for (int j = 2; j < fullColumnCount; j++) {
							try {
								String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
								map.put(list.get(j-2),cellData);
							} catch (NullPointerException e) {
								// TODO Auto-generated catch block
								System.err.println("unable to read the data from rownumber "+i+" and Column Number "+j);
							}
						}
						//assigning values to data provider
						data[limiter][0] = map;
						limiter = limiter + 1;
					}
				}
			}
			wb.close();
		} catch (FileNotFoundException e) {
		System.err.println("Unable to Find the specified file in the path");
		} catch (IOException e) {
		System.err.println("Error in reading the data");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Unable to fetch data");
		}
		
		if(data.equals(null)){
			System.err.println("No Test Data Found");
		}
		//returning data provider object
		return data;
	}	

}
