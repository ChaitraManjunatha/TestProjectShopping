package SeleniumTest;



import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Verify;

/**
 * @author chaitra.manjunatha
 *
 */
public  class EbayShoppingTest {
	//private WebUIFunctions.driver UIFunctions.driver;
	private static String appUrl;
	private static String Search_Id;
	private static String Search_Value1;
	private static String Search_Btn;
	

	private static String browser;
	static UIFunctions functions = new UIFunctions();


	@BeforeClass
	public static void setUp() throws Exception {
		FileReader reader = new FileReader(UIFunctions.propertiesLocation);
		Properties properties = new Properties();
		properties.load(reader);
		browser = properties.getProperty("BROWSER").trim();	
		appUrl = properties.getProperty("APP_URL").trim();
		Search_Id = properties.getProperty("SEARCH_ID").trim();
		Search_Value1 = properties.getProperty("SEARCH_VALUE1").trim();
		Search_Btn = properties.getProperty("SEARCH_BTN").trim();
		functions.Initialise(browser);		
		UIFunctions.driver.get(appUrl.trim());

	}

	@AfterClass
	public static void tearDown() throws Exception {
		UIFunctions.driver.quit();
	}


	//Test to enter a search items for popular brands add to shipping cart and proceed to payment page
	@Test
	public void SearchandshopItems() throws InterruptedException {	
		functions.iWait(UIFunctions.driver, 10);
		functions.type(UIFunctions.driver,Search_Id, Search_Value1+Keys.ENTER);
		functions.iWait(UIFunctions.driver, 10);
		functions.click(UIFunctions.driver,Search_Btn);		
		}
		
	}

	
	
