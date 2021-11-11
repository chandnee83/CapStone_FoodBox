package com.simplilearn.workshop.FoodBoxAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.simplilearn.workshop.FoodBoxAdmin.*;

public class PositiveTests {
	@Test
	public void positiveTest() {

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

		// enter username

		WebElement username = driver.findElement(By.xpath("/html//input[@id='inputUserName']"));
		username.sendKeys("admin");
		// sleep(1000);

		// enter password
		WebElement password = driver.findElement(By.xpath("/html//input[@id='inputPassword']"));
		password.sendKeys("admin");
		sleep(1000);

		// click login
		WebElement loginButton = driver.findElement(By.xpath("//app-root/app-login//form/button[@type='submit']"));
		loginButton.click();
		sleep(2000);

		// verification on new url
		String expectedUrl = GlobalConstants.baseUrl + "user-account";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// fields visible

		WebElement homeButton = driver.findElement(By.xpath("//app-root//nav/a[@href='/user-account']"));
		Assert.assertTrue(homeButton.isDisplayed(), "FoodBox Admin Home button is not visible");
		// sleep(1000);
		WebElement enableButton = driver.findElement(
				By.xpath("/html//app-root/app-user-account/table/tbody/tr[1]/td[6]/button[@class='btn btn-success']"));
		Assert.assertTrue(enableButton.isDisplayed(), "Enable button is not visible");
		// sleep(1000);
		WebElement disableButton = driver.findElement(
				By.xpath("/html//app-root/app-user-account/table/tbody/tr[1]/td[7]/button[@class='btn btn-danger']"));
		Assert.assertTrue(disableButton.isDisplayed(), "Disable button is not visible");

		/*******************************************************************************/
		/********************
		 * Show Available foods
		 **************************************/
		/*******************************************************************************/

		// click Account Authorization link
		WebElement AALink = driver.findElement(
				By.xpath("//app-root//nav/div[@class='collapse navbar-collapse']/ul//a[@href='/authorize']"));
		AALink.click();
		sleep(2000);

		// verification on new url
		expectedUrl = GlobalConstants.baseUrl + "authorize";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		WebElement nameField = driver.findElement(By.xpath("//app-root/app-authorize-registration/table//tr/th[1]"));
		Assert.assertTrue(homeButton.isDisplayed(), "Name field is not visible");

		/*******************************************************************************/
		/********************
		 * Forget Password
		 ******************************************/
		/*******************************************************************************/

		// click Forget Password
		WebElement CRLink = driver.findElement(
				By.xpath("//app-root//nav/div[@class='collapse navbar-collapse']/ul//a[@href='/checkbook-requests']"));
		CRLink.click();
		sleep(2000);

		// verification on new url
		expectedUrl = GlobalConstants.baseUrl + "forget-password";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		WebElement confirmButton = driver.findElement(
				By.xpath("/html//app-root/app-forget-password/table//button[@class='btn btn-secondary']"));
		Assert.assertTrue(homeButton.isDisplayed(), "Confirm Request Button is not visible");

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
