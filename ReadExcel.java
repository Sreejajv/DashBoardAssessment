package utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static Object[][] readExcel(String excelSheetPath, ArrayList<Integer> dateInExcel) throws IOException, ParseException {
		XSSFWorkbook wb = new XSSFWorkbook(excelSheetPath);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		int lastColumn = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastColumn];
		//iterate through each row and column in excel
		for(int i=1; i<lastRow+1;i++) {
			for(int j=0;j<lastColumn;j++) {
				//extract date from excel as date field also returns type as Numeric
				
				if(dateInExcel!=null && dateInExcel.contains(j)) {
					if(dateInExcel.size()>0 && dateInExcel.contains(j)&& (i!=0)) {
						DateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
						Date date = (Date)format.parse(sheet.getRow(i).getCell(j).getDateCellValue().toString());
						//System.out.println(date);        
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						data[i-1][j] = (cal.get(Calendar.MONTH) + 1)+"/" + cal.get(Calendar.DATE) + "/" +    cal.get(Calendar.YEAR);
										
					}}
				else {
					XSSFCell cell = sheet.getRow(i).getCell(j);
					System.out.println(i+":i"+j+":j"+"="+cell.getCellType());
					//get the cell type and use the appropriate get function.
					switch(cell.getCellType()) {
					case NUMERIC: 
						if(cell.getNumericCellValue()== (int)cell.getNumericCellValue()) {
							data[i-1][j]= (int) sheet.getRow(i).getCell(j).getNumericCellValue();
						}
						else {data[i-1][j]= sheet.getRow(i).getCell(j).getNumericCellValue();}
						break;
					case STRING:
						data[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					case BOOLEAN:
						data[i-1][j]= sheet.getRow(i).getCell(j).getBooleanCellValue();
						break;
					case FORMULA:
						data[i-1][j]= sheet.getRow(i).getCell(j).getCellFormula();
						break;
					}
				}
			}
		}
		//System.out.println(data);
		//System.out.println(data.length);
		//System.out.println(data[0].length);
		return data;
		}
}
