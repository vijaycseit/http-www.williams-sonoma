package baseclass.PageObjectModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BaseActions extends UtilityFile{

	public static By Username = By.id("login-email");
	public static By Password = By.id("login-password");
	public static By LoginButton = By.xpath("//button [@id=\"btn-sign-in\"]");
	
		@Test
		public static void launchBrowser(String Url) {
			driver.get(Url);
		}
	
		
		
		@Test
		public static void AuthenticatedLogin(String UName, String Pwd){
			driver.findElement(Username).sendKeys(UName);
			driver.findElement(Password).sendKeys(Pwd);
			
			List<WebElement> signbutton = driver.findElements(LoginButton);
			int count = signbutton.size();
	
	//hence two sing-in buttons present on page looped to click second one 
				for(int i =0; i<count; i++) {
					if(i==1) {
					signbutton.get(1).click();
					break;
					}
				}
		
		}
		
		
		
		
		
		
		
}
