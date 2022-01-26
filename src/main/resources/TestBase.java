package main.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

    public static WebDriver driver ;   
    public static Properties prop;
    
    public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");	
			driver = new FirefoxDriver(); 
			
		}
		
	}
         
  

}
