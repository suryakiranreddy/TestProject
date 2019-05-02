package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataProvider {
	
	static XSSFWorkbook workbook;
	static FileInputStream file;
	static XSSFSheet sheet;
	 
	public static Object[][] excelReader(String Execlfilepath, String sheetName) throws Exception{
		
		try {
			
			 file = new FileInputStream(new File(Execlfilepath));
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
		 workbook = new XSSFWorkbook(file);
		 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet =workbook.getSheet(sheetName);
		System.out.println("sheet name" +sheet);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++){			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
}
