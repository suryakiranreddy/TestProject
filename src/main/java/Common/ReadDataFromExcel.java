package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
public String[][] getExcelData(String excellocation, String sheetName) {
try {
String dataSets[][] = null;
FileInputStream file = new FileInputStream(new File(excellocation));

// Create Workbook instance holding reference to .xlsx file
XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheet(sheetName);
// count number of active rows
int totalRow = sheet.getLastRowNum();
// count number of active columns in row
int totalColumn = sheet.getRow(0).getLastCellNum();
// Create array of rows and column
dataSets = new String[totalRow][totalColumn];
// Iterate through each rows one by one
Iterator<Row> rowIterator = sheet.iterator();
int i = 0;
while (rowIterator.hasNext()) {
System.out.println(i);
i = i++;
Row row = rowIterator.next();
// For each row, iterate through all the columns
Iterator<Cell> cellIterator = row.cellIterator();
int j = 0;
while (cellIterator.hasNext()) {
Cell cell = cellIterator.next();
if (cell.getStringCellValue().contains("visibleText")) {
//break;
}

// Check the cell type and format accordingly
switch (cell.getCellType()) {
case Cell.CELL_TYPE_STRING:
dataSets[i+1][j] = cell.getStringCellValue();
System.out.println(cell.getStringCellValue());
break;
case Cell.CELL_TYPE_BOOLEAN:
dataSets[i][j] = cell.getStringCellValue();
System.out.println(cell.getStringCellValue());
break;
case Cell.CELL_TYPE_FORMULA:
dataSets[i-1][j++] = cell.getStringCellValue();
System.out.println(cell.getStringCellValue());
break;
case Cell.CELL_TYPE_NUMERIC:
Double value = cell.getNumericCellValue();
Long longValue = value.longValue();
                  //dataSets[i][j++] = new String(longValue.toString());
dataSets[i-1][j++] = NumberToTextConverter.toText(longValue);
System.out.println(longValue);
break;
}

}
System.out.println("");
i++;
}
file.close();
return dataSets;
} catch (Exception e) {
e.printStackTrace();
}
return null;
}
public void updateResult(String repotExcellocation, String sheetName, String testCaseName, String testStatus) throws IOException {

try {
FileInputStream file = new FileInputStream(new File(repotExcellocation));

// Create Workbook instance holding reference to .xlsx file
XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheet(sheetName);
// count number of active tows
int totalRow = sheet.getLastRowNum() + 1;
// count number of active columns in row
for (int i = 0; i < totalRow; i++) {
XSSFRow r = sheet.getRow(i);
String ce = r.getCell(0).getStringCellValue();
if (ce.contains(testCaseName)) {
r.createCell(1).setCellValue(testStatus);
file.close();
System.out.println("resule updated");
FileOutputStream outFile = new FileOutputStream(new File(repotExcellocation));
workbook.write(outFile);
outFile.close();
break;
}

}
} catch (Exception e) {
e.printStackTrace();
}
}
public Object[][] getExcelDataBasedOnStartingPoint(String excellocation, String sheetName, String testName) {
try {
String dataSets[][] = null;
FileInputStream file = new FileInputStream(new File(excellocation));

// Create Workbook instance holding reference to .xlsx file
XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheet(sheetName);
// count number of active rows
int totalRow = sheet.getLastRowNum();
int totalColumn = 0;
// Iterate through each rows one by one
Iterator<Row> rowIterator = sheet.iterator();
int i = 0;
int count = 1;
while (rowIterator.hasNext() && count == 1 || count == 2) {
// System.out.println(i);

Row row = rowIterator.next();
// For each row, iterate through all the columns
Iterator<Cell> cellIterator = row.cellIterator();
int j = 0;
while (cellIterator.hasNext()) {

Cell cell = cellIterator.next();

if (cell.getStringCellValue().contains(testName + "end")) {
count = 0;
break;
}

// System.out.println(sheetName+"Start");
if (cell.getStringCellValue().contains(testName + "start")) {
// count number of active columns in row
totalColumn = row.getPhysicalNumberOfCells() - 1;
// Create array of rows and column
dataSets = new String[totalRow][totalColumn];
}
// System.out.println(sheetName+"Start");
if (cell.getStringCellValue().contains(testName + "start") || count == 2) {
System.out.println(sheetName + "start");
count = 2;
// Check the cell type and format accordingly

switch (cell.getCellType()) {
case Cell.CELL_TYPE_NUMERIC:
dataSets[i - 1][j++] = cell.getStringCellValue();
System.out.println(cell.getNumericCellValue());
break;
case Cell.CELL_TYPE_STRING:
if (!cell.getStringCellValue().contains(testName + "start")) {
dataSets[i - 1][j++] = cell.getStringCellValue();
System.out.println(cell.getStringCellValue());
}
break;
case Cell.CELL_TYPE_BOOLEAN:
dataSets[i - 1][j++] = cell.getStringCellValue();
System.out.println(cell.getStringCellValue());
break;
case Cell.CELL_TYPE_FORMULA:
dataSets[i - 1][j++] = cell.getStringCellValue();
System.out.println(cell.getStringCellValue());
break;
}

}
}

System.out.println("");
i++;
}
file.close();

//return parseData(dataSets, totalColumn);
} catch (Exception e) {
e.printStackTrace();
}
return null;
}
/* 
public String[][] getExcelData(String ){
String repotExcellocation= "./Reports/ExcelReport/TestData.xlsx";
ReadDataFromExcel re = new ReadDataFromExcel();
String[][] data = re.getExcelData("./src/test/resources/TestData/TestData.xlsx", "TestData");
System.out.println(data);
re.updateResult(repotExcellocation, "TestReport", "TC_001", "Pass");
re.updateResult(repotExcellocation, "TestReport", "TC_002", "Fails");
}*/
public static void main(String[] args) throws IOException {
String repotExcellocation= "./Reports/ExcelReport/TestData.xlsx";
ReadDataFromExcel re = new ReadDataFromExcel();
String[][] data = re.getExcelData("./src/test/resources/TestData/TestData.xlsx", "login");
System.out.println(data);
/*re.updateResult(repotExcellocation, "TestReport", "TC_001", "Pass");
re.updateResult(repotExcellocation, "TestReport", "TC_002", "Fails");*/
}

}

