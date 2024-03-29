package com.ok.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by OK on 11.08.2016.
 */
public class WebUtil {
    final static int WAIT_TIME_OUT = 30;

    public static <T> T goToPage(WebDriver driver, java.lang.Class<T> PageObject,  String pageURL) {
        driver.get(pageURL);
        return PageFactory.initElements(driver, PageObject);
    }
    
    public static <T> T navigateBack(WebDriver driver, java.lang.Class<T> PageObject){
    	driver.navigate().back();
    	return PageFactory.initElements(driver, PageObject);
    }

    public static void click(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    
    public static void clickWithOffset(WebDriver driver, By by){
		WebElement element = driver.findElement(by);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        int offset = 100;
        int position = element.getLocation().getY() - offset;
        js.executeScript("window.scrollTo(0, arguments[0])", position);
        element.click();
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 320);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 320);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean elementExists(WebDriver driver, By by) {
        return (driver.findElements(by).size() > 0);
    }

    public static void clearAndSendKeys(WebDriver driver, By by, String s) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(s);
    }

    public static String getElementText(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element.getText();
    }
    
    public static void closeBrowser(WebDriver driver){
    	driver.quit();
    }
}
