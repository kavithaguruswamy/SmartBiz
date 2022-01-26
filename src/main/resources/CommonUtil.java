package main.resources;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class CommonUtil extends TestBase{	
	
	 
    public void scrollIntoView( WebElement ele) {
    	
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
    }
    
    public Boolean isElementDisplayed(WebElement webElement) {
    	this.scrollIntoView(webElement);
        return webElement.isDisplayed();
    }
    
    public Boolean isButtonDisabled(WebElement webElement) {
    	String submit = webElement.getAttribute("class");
    	boolean isDisabled = submit.contains("disabled");
        return isDisabled;
    }

    
    public String navigateToPage( String url) {
    	
    	driver.navigate().to(url);
    	String currentUrl=this.getUrl();
    	return currentUrl;
    	
    }
    
    public String getUrl() {
       return driver.getCurrentUrl();
    }
    
    public void click( WebElement webElement) {
    	this.scrollIntoView(webElement);
    	this.waitTillClickable(webElement, 2);
        webElement.click();
    }
    
    
    public void scrollClick( WebElement webElement) {
    	this.scrollIntoView(webElement);
    	this.waitTillClickable(webElement, 2);
        webElement.click();
    }
    
    public void hoverClick( WebElement webElement) {
    	
    	Actions actions = new Actions(driver);
    	actions.moveToElement(webElement);
    	actions.click().build().perform();
    }
    public void selectValue(WebElement webElement, String value) {
    	this.waitTillClickable(webElement, 2);
        Select select = new Select(webElement);
        select.selectByValue(value);
    }
    
    public void wait(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String getEmail() {
        Random rndNo = new Random();
        int number = rndNo.nextInt(99999999);
        String num=String.format("%06d", number);
        StringBuffer sf = new StringBuffer("test.automation");
        sf.append(number);
        sf.append("@smartbizloans.com");
        System.out.println(sf.toString());
        return sf.toString();
        
    }
    
    public void waitForElement( WebElement element, int timeout) {
    	
    	try {
    		int duration=timeout*1000;
    	WebDriverWait wait = new WebDriverWait(driver, duration);
    	wait.until(ExpectedConditions.visibilityOf(element));
    	} catch (      NoSuchElementException e) {
            e.printStackTrace();
        }
    }

public void waitTillClickable( WebElement element, int timeout) {
    	
    	try {
    		int duration=timeout*1000;
    	WebDriverWait wait = new WebDriverWait(driver, duration);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	} catch (      NoSuchElementException e) {
            e.printStackTrace();
        }
    }

   
}