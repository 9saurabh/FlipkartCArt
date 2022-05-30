package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromExcel(int rowindex,int cellindex) throws Exception
	{
		String value;
		String path = "src\\main\\resources\\TestData\\flipkart.xlsx";
        FileInputStream file = new FileInputStream(path);
        Workbook book = WorkbookFactory.create(file);
        value = book.getSheet("Sheet1").getRow(rowindex).getCell(cellindex).getStringCellValue();

		return value;		
	}
	
	public static void captureScreenshot(WebDriver driver,int testID) throws Exception
	{
		//DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy//mm//ss");
		Date date = new Date();
		String date1=date.toString().replace(" ", "-").replace(":", " ");
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("test-output\\Screenshot\\test"+date1+testID+".png");
		FileHandler.copy(source, dest);
		//FileUtils.copyFile(source,dest);
		System.out.println("Screenshot Taken");
	}
}

