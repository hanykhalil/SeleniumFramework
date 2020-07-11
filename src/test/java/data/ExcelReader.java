package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static FileInputStream fis =null;
	public FileInputStream getFileData() throws FileNotFoundException {
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\dataExcel.xlsx";
		File srcFile= new File(filePath);
		fis= new FileInputStream(srcFile);
		return fis;
	}

public Object[][]getExcelData() throws IOException{
	fis=getFileData();
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet= wb.getSheetAt(0);
	int numberOfRows=(sheet.getLastRowNum()+1);
	int numberOfColumns=4;
	String[][] ArrayOfData= new String[numberOfRows][numberOfColumns];
	for (int i = 0; i < numberOfRows; i++) {
		for (int j = 0; j < numberOfColumns; j++) {
			XSSFRow row= sheet.getRow(i);
			ArrayOfData[i][j]=row.getCell(j).toString();
		}
	}
	wb.close();
	return ArrayOfData;
}	
}
