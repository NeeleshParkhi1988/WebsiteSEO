
package com.NOVO_SEO.ExcelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public excelReader(String path)
	{
		this.path= path;
		try 
		{
			 fis = new FileInputStream(path);
			 workbook = new XSSFWorkbook(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String[][] getDataFromSheet(String sheetName, String ExcelName)
	{
		String dataSets[][] = null;
		 try
	    {
	    	sheet = workbook.getSheet(sheetName);
		    int totalrows = sheet.getLastRowNum()+1;
		    int totalcolumn = sheet.getRow(0).getLastCellNum();
		    dataSets = new String[totalrows-1][totalcolumn];
		    for(int i=1; i<totalrows; i++)
		    {
		    	XSSFRow row = sheet.getRow(i);
		    	for(int j=0; j<totalcolumn; j++)
		    	{
		    		XSSFCell cell = row.getCell(j);
		    		if(cell.getCellType()==CellType.STRING)
		    		{
		    			dataSets[i-1][j] = cell.getStringCellValue();
		    		}else if(cell.getCellType()==CellType.NUMERIC)
		    		{
		    			String value = String.valueOf(cell.getNumericCellValue());
		    			dataSets[i-1][j] = value;
		    		}else
		    		{
		    			dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
		    		}
		    	}
		    }
	    }catch(Exception e)
		 {
	    	System.out.println("Exception in reading xlsx file" +e.getMessage());
	    	e.printStackTrace();
		 }
		
		return dataSets;
	}

}