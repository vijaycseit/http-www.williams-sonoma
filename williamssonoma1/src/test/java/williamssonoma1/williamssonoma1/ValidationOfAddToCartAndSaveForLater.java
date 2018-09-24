package williamssonoma1.williamssonoma1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Scenario: Validation of Add to Card and Save for Later

public class ValidationOfAddToCartAndSaveForLater {

public static WebDriver driver;
public static String ItemAddedInCart;
public static String ItemSaved;

	
//To Set properties, launch URL and Maximize the window
	@Test(priority = 0)
	public static void LaunchURL() {
		System.setProperty("webdriver.chrome.driver", "D://Project//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.williams-sonoma.com/account/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		


	
//prerequisite: has to register user Id in Application
//Login into williams-Sonoma application with valid user ID and password
		@Test(dependsOnMethods = "LaunchURL")	
		public static void LoginUrl(){
			driver.findElement(By.id("login-email")).sendKeys("vijaycseit@gmail.com");
			driver.findElement(By.id("login-password")).sendKeys("vision2k123");
		
				List<WebElement> signbutton = driver.findElements(By.xpath("//button [@id=\"btn-sign-in\"]"));
				int count = signbutton.size();
		
		//hence two sing-in buttons present on page looped to click second one 
					for(int i =0; i<count; i++) {
						if(i==1) {
						signbutton.get(1).click();
						break;
						}
					}
			
		}
	
		
//Mouse Hover to COOKWARE and select teakettles link	
		@Test(dependsOnMethods= "LoginUrl")
		public static void SelectTeaKettles() {
			WebElement cookware = driver.findElement(By.xpath("//a[@class=\"topnav-cookware \"]"));
			Actions act = new Actions(driver);
			act.moveToElement(cookware).build().perform();
						
			List<WebElement> teakettles = driver.findElements(By.xpath("//a[@href=\"https://www.williams-sonoma.com/shop/electrics/electrics-teakettles/?cm_type=gnav\"]"));
						
			//hence two sing-in buttons present on page looped to click second one 
				for(int j =0; j<teakettles.size(); j++) {
						
					if(j==0) 
					{
					teakettles.get(0).click();	
					break;
					}
				}
	
		}
				
		

//Add to Cart and save for Later
		@Test(dependsOnMethods="SelectTeaKettles")
		public static void SelectDesiredItems() {
		ItemAddedInCart = 	driver.findElement(By.xpath("//img [@alt=\"KitchenAid Precision Kettle\"]")).getText();	
		driver.findElement(By.xpath("//img [@alt=\"KitchenAid Precision Kettle\"]")).click();
		}
			
//Add to Cart and CheckOut
		@Test (dependsOnMethods="SelectDesiredItems")
		public static void AddtoCart() {
		driver.findElement(By.xpath("//button[@aria-label=\"Add to Cart\"]")).click();
		}
			
		
		@Test (dependsOnMethods="AddtoCart")
		public static void CheckOut() {
		driver.findElement(By.xpath("//a[@id=\"anchor-btn-checkout\"]")).click();
		}
			
		@Test	(dependsOnMethods="CheckOut")
		public static void SaveForLater() {
			driver.findElement(By.xpath("//a[@class=\"moveToSFL save-for-later-link\"]")).click();	
			ItemSaved = driver.findElement(By.xpath("//img [@class=\"cart-table-row-image-image\"]")).getText();
			

//validation of item added in the cart and  item actually saved.			
			SoftAssert assertion = new SoftAssert();
			assertion.assertEquals(ItemAddedInCart, ItemSaved);
			System.out.println("Test case execution is successful");
		}
		
		
		
//Sin-Out and quit Browser		
		@Test(dependsOnMethods="SelectDesiredItems")
		public static void quitbrowser() {
			//driver.findElement(By.xpath("//a[@class=\"sign-in-out\"]")).click();
			//driver.quit();
			
		}
		




}
	
