package com.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://leafground.com/select.xhtml");

		// use webdriver wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

		// select ui automation tool---------->
		WebElement dropUI = driver.findElement(By.className("ui-selectonemenu"));
		Select se = new Select(dropUI);
		se.selectByVisibleText("Selenium");

		// select preferred country----------->

		// 1.click select country dropdown
		driver.findElement(By.id("j_idt87:country_label")).click();
		// 2.click prefered country from dropdown
		driver.findElement(By.id("j_idt87:country_3")).click();

		// select city belongs to the country------->

		// 1.click select city dropdown
		// Thread.sleep(2000);
		// driver.findElement(By.id("j_idt87:city_label")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt87:city_label"))).click();
		// 2.click prefered city from dropdown
		driver.findElement(By.id("j_idt87:city_2")).click();

		// choose course----------------------------->
		// do {
		driver.findElement(By.xpath("//button[@type='button']")).click();

//			List<WebElement> courses = driver.findElements(
//					By.xpath("//li[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all']"));

		// List<WebElement> courses =
		// driver.findElements(By.xpath("//li[contains(@class,'ui-autocomplete-item')]"));

		List<WebElement> courses = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//li[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all']")));

		for (int i = 0; i < courses.size(); i++) {
			String text = courses.get(i).getText();
			System.out.println(text);

			if (text.contains("Selenium")) {
				courses.get(i).click();
				// break;
			}
//			if (text.contains("JMeter")) {
//				courses.get(i).click();
//			}
		}
		// } while (true);

		// select language------------->

		driver.findElement(By.id("j_idt87:lang_label")).click();

		List<WebElement> languages = driver.findElements(By.xpath("//ul[@id='j_idt87:lang_items']/li"));

		for (WebElement eachLang : languages) {
			String text = eachLang.getText();
			System.out.println(text);
			if (text.contains("Tamil")) {
				eachLang.click();
				//break;
			}
		}

		// select word according to the language selected----------->

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt87:value_label"))).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:value_items']/li[2]")).click();

//		List<WebElement> langWord = driver.findElements(By.xpath("//ul[@id='j_idt87:value_items']/li"));
//		for (WebElement words : langWord) {
//			String text = words.getText();
//			System.out.println(text);
//			if (text.contains("")) {
//				words.click();
//				break;
//			}
//		}

	}
}
