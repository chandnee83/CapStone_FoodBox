package com.simplilearn.workshop.FoodBoxAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	
	@Test
	public void negativeTest() {

		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-new.exe");
		WebDriver driver = new ChromeDriver();
		// sleep(2000);

		// open testpage
		String url = GlobalConstants.baseUrl;
		driver.get(url);
		System.out.println("page is opened");
		// sleep(2000);

		// maximize browser window
		driver.manage().window().maximize();

		/*********************************************************************/
		/****************************** Login Tests **************************/
		/*********************************************************************/
		
		// click login
			WebElement loginButton1 = driver.findElement(By.xpath("//app-root/app-login//form/button[@type='submit']"));
			loginButton1.click();
			sleep(2000);
			
			driver.switchTo().alert().accept();
			
		WebElement RCfailMessage = driver.findElement(By.xpath("//app-root/app-login//form//span[.='Please enter a valid UserName']"));
		String actualMessage = RCfailMessage.getText();
		String expectedMessage = "Please enter a valid UserName";
		Assert.assertTrue(actualMessage.contains(expectedMessage),
					"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
							+ "\n Expected Message: " + expectedMessage);

		// enter username

		WebElement username = driver.findElement(By.xpath("/html//input[@id='inputUserName']"));
		username.sendKeys("incorrect user");
		// sleep(1000);

		// enter password
		WebElement password = driver.findElement(By.xpath("/html//input[@id='inputPassword']"));
		password.sendKeys("incorrectpassword");
		sleep(1000);

		// click login
		WebElement loginButton = driver.findElement(By.xpath("//app-root/app-login//form/button[@type='submit']"));
		loginButton.click();
		sleep(2000);
        
		String loginFailureAlert = driver.switchTo().alert().getText();
		String expectedAlert = "Login failed - Please try again";
		Assert.assertEquals(loginFailureAlert, expectedAlert, "Actual page url is not the same as expected");
		
		driver.switchTo().alert().accept();
		
		// verification on new url
		String expectedUrl = GlobalConstants.baseUrl;
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		
		// close browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
