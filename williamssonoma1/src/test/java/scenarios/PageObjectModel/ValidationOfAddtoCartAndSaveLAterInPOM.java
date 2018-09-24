package scenarios.PageObjectModel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.PageObjectModel.*;

public class ValidationOfAddtoCartAndSaveLAterInPOM {

		@BeforeClass
		public static void LaunchingBrowser() {
			UtilityFile.SetBrowser();
			UtilityFile.PopertyBaseFile();
			BaseActions.launchBrowser("https://www.williams-sonoma.com/account/login.html");
		}
	
	
		@Test
		public static void AddtoCartAndSaveLAter() {
			
			BaseActions.AuthenticatedLogin("vijaycseit@gmail.com", "vision2k123");
			SelectItems.MouseHoverAndSelectKettle();
			SelectItems.SelectDesiredItems();
			SelectItems.AddtoCart();
			SelectItems.CheckOutItem();
			SelectItems.SaveLater();
	
		}


		@AfterClass
		public static void quitbrowser()
		{
			UtilityFile.QuitBrowser();
			
		}




}
