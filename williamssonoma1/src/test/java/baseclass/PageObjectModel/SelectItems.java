package baseclass.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectItems extends BaseActions{

	public static By Item = By.xpath("//img [@alt=\"KitchenAid Precision Kettle\"]");
	public static By AddCart = By.xpath("//button[@aria-label=\"Add to Cart\"]");
	public static By CheckOut = By.xpath("//a[@id=\"anchor-btn-checkout\"]");
	public static By SaveLater = By.xpath("//a[@class=\"moveToSFL save-for-later-link\"]");

		@Test
		public static void MouseHoverAndSelectKettle() {
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
	
	
			@Test
			public static void SelectDesiredItems() {
				driver.findElement(By.xpath("//img [@alt=\"KitchenAid Precision Kettle\"]")).click();
			}
	
			
			
			@Test
			public static void AddtoCart() {
				driver.findElement(AddCart).click();
			}
			
			
			@Test
			public static void CheckOutItem() {
				driver.findElement(CheckOut).click();
			}
			

			@Test
			public static void SaveLater(){
				driver.findElement(SaveLater).click();
			}
			
}
