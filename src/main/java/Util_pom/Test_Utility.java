package Util_pom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import testbase_pom.TestBase;

public class Test_Utility extends TestBase{

	public Test_Utility() throws IOException {
		super();
	
	}

	public static long IMPLICTWAITTIMEOUT = 30;
	
	public static long PAGELOADTIMEOUT = 30;
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\java\\TestData_pom\\testdata.xlsx";
	
	public static Workbook book;
	
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName)
			throws EncryptedDocumentException,  IOException, InvalidFormatException {
		
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		
		book = WorkbookFactory.create(file);

		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}
	
}

