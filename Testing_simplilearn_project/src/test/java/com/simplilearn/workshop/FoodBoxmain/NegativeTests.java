package com.simplilearn.workshop.FoodBoxmain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.simplilearn.workshop.FoodBoxmain.*;

public class NegativeTests {
	@Test
	public void loginTest() {

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
		/****************************** Login Tests ****************************/
		/*********************************************************************/

		// enter username

		WebElement username = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='text']"));
		username.sendKeys("incorrect user");
		// sleep(1000);

		// click login
		WebElement loginButton = driver
				.findElement(By.xpath("//app-root/app-login//form//button[@class='btn btn-primary']"));
		loginButton.click();
		sleep(2000);

		// verification on new url
		String expectedUrl = GlobalConstants.baseUrl + "login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		// screen messages
		WebElement pwEmptyMessage = driver.findElement(
				By.xpath("/html//app-root/app-login//form//div[@class='invalid-feedback']/div[.='Please enter a Password']"));
		String actualMessage = pwEmptyMessage.getText();
		String expectedMessage = "Please enter a Password";
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
						+ "\n Expected Message: " + expectedMessage);
		
		// enter password
		WebElement password = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='password']"));
		password.sendKeys("incorrectpassword");
		sleep(1000);

		// click login
		WebElement loginButton2 = driver
				.findElement(By.xpath("//app-root/app-login//form//button[@class='btn btn-primary']"));
		loginButton2.click();
		sleep(2000);

		// verification on new url
		expectedUrl = GlobalConstants.baseUrl + "login";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		WebElement loginErr = driver.findElement(By.xpath("/html//h2[@id='swal2-title']"));
		Assert.assertTrue(loginErr.isDisplayed(), "Login Incorrect");
		// sleep(1000);

		
		// close browser
		driver.quit();
		
		

	}
	
	@Test
	public void showAvailableFoodsTest() {

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

		
		/*** Show available food test and paypal integration **/
		

		// Food got added

				WebElement FoodAdded = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='text']"));
				FoodAdded.sendKeys("user2");
				// sleep(1000);

				// Food successfully added
				WebElement AddedSuc = driver.findElement(By.xpath("//app-root/app-login//form//input[@type='password']"));
				AddedSuc.sendKeys("user1234");
				sleep(1000);

				// save my cart
				WebElement loginButton = driver
						.findElement(By.xpath("//app-root/app-login//form//button[@class='btn btn-primary']"));
				loginButton.click();
				sleep(2000);
				
				// show my order
				WebElement showMyOrder = driver.findElement(By
						.xpath("//app-root/app-home/app-navbar//div[@class='collapse navbar-collapse']//a[@href='/transfer']"));
				showMyOrder.click();
				sleep(1000);
				
				// payment gateway

				WebElement paymentGateway = driver.findElement(
						By.xpath("//app-root/app-payment-gateway//form[@method='post']/div[3]/input[@type='text']"));
				paymentGateway.sendKeys("12345678");
				// sleep(1000);

				// paypal shipping order
				WebElement shippingDetail = driver.findElement(
						By.xpath("//app-root/app-payment-gateway//form[@method='post']/div[4]/input[@type='text']"));
				shippingDetail.sendKeys("2");
				sleep(1000);

				// paypal transaction detail
				WebElement tButton = driver.findElement(By.xpath(
						"//app-root/app-paypal-transaction//form[@method='post']//button[@class='btn btn-info form-control']"));
				tButton.click();
				sleep(3000);

				WebElement transferfailMessage = driver.findElement(By.xpath("/html//div[@id='swal2-content']"));
				String actualMessage = transferfailMessage.getText();
				String expectedMessage = "Error code 1691: credit card number is incorrect";
				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"Actual message does not contain expected message. \n" + "Actual Message:" + actualMessage
								+ "\n Expected Message: " + expectedMessage);
				//
				WebElement tOKButton = driver
						.findElement(By.xpath("/html//div[@role='dialog']/div[@class='swal2-actions']/button[1]"));
				tOKButton.click();
				sleep(1000);

		
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
