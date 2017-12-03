package SeleniumTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

/**
 * @author chaitra.manjunatha
 *
 */
public class UIFunctions {

	public static WebDriver driver;
	public static String chromeDriverExe;
	public static String FFDriverExe;
	public static String IEDriverExe;
	public static String propertiesLocation  = "C:/Users/chaitra.manjunatha/Desktop/Projects/Automation Testing/testtodos/src/SeleniumTest/elements.properties";
	
	public static void getDriverExe() throws Exception {
	 FileReader reader = new FileReader(UIFunctions.propertiesLocation);
	 Properties properties = new Properties();
	 properties.load(reader);
	 chromeDriverExe = properties.getProperty("CHROME_DRIVER").trim();	
	 FFDriverExe = properties.getProperty("FIREFOX_DRIVER").trim();
	 IEDriverExe = properties.getProperty("IE_DRIVER").trim();
	 }

	// click func can be used for any button link clicks
	public void click(WebDriver driver, String locator){
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			WebElement element  = driver.findElement(By.xpath(value));
			element.click();
		}else if(elementLoc.equalsIgnoreCase("id")){
			WebElement element  = driver.findElement(By.id(value));
			element.click();
		}else if(elementLoc.equalsIgnoreCase("name")){
			WebElement element  = driver.findElement(By.name(value));
			element.click();
		}
	}

	// type func can be used for any input text box
	public void type(WebDriver driver, String locator, String type){
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			WebElement element  = driver.findElement(By.xpath(value));
			element.sendKeys(type);
		}else if(elementLoc.equalsIgnoreCase("id")){
			WebElement element  = driver.findElement(By.id(value));
			element.sendKeys(type);
		}else if(elementLoc.equalsIgnoreCase("name")){
			WebElement element  = driver.findElement(By.name(value));
			element.sendKeys(type);
		}
	}

	// To enter keys
	public void type(WebDriver driver, String locator, Keys type){
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			WebElement element  = driver.findElement(By.xpath(value));
			element.sendKeys(type);
		}else if(elementLoc.equalsIgnoreCase("id")){
			WebElement element  = driver.findElement(By.id(value));
			element.sendKeys(type);
		}else if(elementLoc.equalsIgnoreCase("name")){
			WebElement element  = driver.findElement(By.name(value));
			element.sendKeys(type);
		}
	}


	// driver find element
	public void findElement(WebDriver driver, String locator){
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(value));			
		}else if(elementLoc.equalsIgnoreCase("id")){
			driver.findElement(By.id(value));			
		}else if(elementLoc.equalsIgnoreCase("name")){
			driver.findElement(By.name(value));				
		}
	}

	// driver get text of element
	public String getText(WebDriver driver, String locator){
		String getText = null;
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			getText = driver.findElement(By.xpath(value)).getText();			
		}else if(elementLoc.equalsIgnoreCase("id")){
			getText = driver.findElement(By.id(value)).getText();	
		}else if(elementLoc.equalsIgnoreCase("name")){
			getText = driver.findElement(By.name(value)).getText();			
		}
		return getText;
	}

	// check if element is displayed
	public void isDisplayed(WebDriver driver, String locator){
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(value)).isDisplayed();			
		}else if(elementLoc.equalsIgnoreCase("id")){
			driver.findElement(By.id(value)).isDisplayed();	
		}else if(elementLoc.equalsIgnoreCase("name")){
			driver.findElement(By.name(value)).isDisplayed();			
		}

	}

	//implicitly halt the browser till elements are available
	public void iWait(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	//explicitly wait till elements are available
	public void eWait(WebDriver driver, int time,  String locator){
		WebDriverWait wait = new WebDriverWait(driver, time);
		String[] findElement = locator.split("_");
		String elementLoc = findElement[0]; 
		String value = findElement[1]; 
		if (elementLoc.equalsIgnoreCase("xpath")){
			wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable((By.xpath(value))));		
		}else if(elementLoc.equalsIgnoreCase("id")){
			wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable((By.id(value))));	
		}else if(elementLoc.equalsIgnoreCase("name")){
			wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable((By.name(value))));				
		}
	}

	//Initialise different browser based on input
	public void Initialise(String browser) throws Exception{
		UIFunctions.getDriverExe();
		//DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("reuse.browser", "true");
		if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver",FFDriverExe);
			driver = new FirefoxDriver();	
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", chromeDriverExe);
			DesiredCapabilities caps=DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			driver= new ChromeDriver(caps);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}else if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://todomvc-socketstream.herokuapp.com");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			System.setProperty("webdriver.ie.driver",IEDriverExe );
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
		}
	}

}


