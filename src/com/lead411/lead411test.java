package com.lead411;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class lead411test {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeMethod
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.lead411.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLead() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("login_search_textbox")).clear();
	    driver.findElement(By.id("login_search_textbox")).sendKeys("il, ceo");
	    driver.findElement(By.cssSelector("a.login_search_a")).click();
	    wait(10);
	    driver.findElement(By.cssSelector("img.comp")).click();
	    driver.findElement(By.cssSelector("img.comp")).click();
	    
	    if(isElementPresent(By.id("example")) == true)
        { 
            WebElement table_element =  driver.findElement(By.id("example"));
            List<WebElement> tr_collection=table_element.findElements(By.xpath("id('example')/tbody/tr"));

            System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
            int row_num,col_num;
            row_num=1;
            for(WebElement trElement : tr_collection)
            {
                List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
                System.out.println("NUMBER OF COLUMNS="+td_collection.size());
                col_num=1;
                for(WebElement tdElement : td_collection)
                {
                    System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
                    col_num++;
                }
                row_num++;
            }
	    
	    driver.findElement(By.xpath("//tr[@id='sizcache05446284917049621']/td[4]")).click();
	    driver.findElement(By.xpath("//tr[@id='sizcache05446284917049621']/td[4]")).click();
	    
	    
	    driver.findElement(By.linkText("John Walker")).click();
	  }
	  }
	  @AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
	  /**
	     * sleep and catch the exception.
	     * 
	     * @param seconds the number of seconds to wait
	     */
	    public void wait(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (InterruptedException e) {
	        }
	    }

}
