package Datadrvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//output is that multiple windows will be opened with data from excel file.If two entries are there in excel,2 windows will get opened
public class Datadrv {

	WebDriver driver;
	@Test(dataProvider="testdata")//sheet name in the excel
	public void demoProject(String userName,String password) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mgakh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("pass")).sendKeys(password);	
	}
	
	@DataProvider(name="testdata")//sheet name in the excel
	public Object[][] testDataFeed(){
		ReadExcelFile config=new ReadExcelFile("C:\\Users\\mgakh\\OneDrive\\Documents\\datadrivenSample.xlsx");
		int rows=config.getRowCount(0);//sheet 0
		Object[][] credentials=new Object[rows][2];//Specifies the row & columns
		for(int i=0;i<rows;i++)
		{
			credentials[i][0]=config.getData(0,i,0);
			credentials[i][1]=config.getData(0,i,1);
		}
		return credentials;
	}
	
}
