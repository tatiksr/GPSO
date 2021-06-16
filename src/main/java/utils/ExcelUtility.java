package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] readExcel(String fileName) throws IOException {

		BufferedReader reader;
		Properties pro = null;

		try {

			reader = new BufferedReader(new FileReader("config//configuration.properties"));
			pro = new Properties();
			pro.load(reader);
			reader.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		@SuppressWarnings("resource")
		XSSFWorkbook wBook = new XSSFWorkbook("./data/" + fileName + ".xlsx");
		XSSFSheet sheet = wBook.getSheetAt(0);
		
		int rowNum = sheet.getLastRowNum();
		short cellNum = sheet.getRow(0).getLastCellNum();
		
		DataFormatter formatter = new DataFormatter();
		
		Map<String, String> pswUser = new HashMap<>();

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < cellNum; j++) {

				pswUser.put(formatter.formatCellValue(sheet.getRow(0).getCell(j)),
						formatter.formatCellValue(sheet.getRow(i).getCell(j)));
			}
			
			if(pswUser.get("Loc").equals(pro.getProperty("Loc"))) {
				
				break;
			}
			
		}
		

		return new Object[][] { new Object[] { pswUser } };

	}

}