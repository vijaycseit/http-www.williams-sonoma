package baseclass.PageObjectModel;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UtilityFile {
	
	public static WebDriver driver;
	public static Properties prop;
	public static File file;
	public static FileReader filereader;
	
		@Test
		public static void PopertyBaseFile() {
			try {
			prop = new Properties();
			file = new File("C:\\Users\\vardhan\\eclipse-workspace\\williamssonoma1\\config.properties");
			filereader = new FileReader(file);
			prop.load(filereader);	
			}
	
			catch(Exception e) {
			System.out.println(e.getMessage());
						}
			}
	
	
		@Test
		public static void SetBrowser() {
			System.setProperty("webdriver.chrome.driver", "D://Project//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
		
		
		
		@Test
		public static void QuitBrowser() {
			 driver.quit();
		}
		
		
		
		




}
