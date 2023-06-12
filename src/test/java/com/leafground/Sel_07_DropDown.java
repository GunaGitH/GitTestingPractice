package com.leafground;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.util.BaseClass;

public class Sel_07_DropDown extends BaseClass {

	private void favUI() {

		WebElement drp1 = driver.findElement(By.xpath("//*[@id='j_idt87']/div/div[1]/div[1]/div/div/select"));
		Select sel = new Select(drp1);
		sel.selectByIndex(1);
	}

	private void country() {
		driver.findElement(By.xpath("//*[@id='j_idt87:country_label']")).click();
		driver.findElement(By.xpath("//*[@id='j_idt87:country_3']")).click();
	}

	private void verifyCities() {
		driver.findElement(By.id("j_idt87:city_label")).click();

		List<WebElement> cityEle = driver.findElements(By.xpath("//ul[@id='j_idt87:city_items']/li"));
		int cityLstSize = cityEle.size();
		System.out.println("cityLstSize-> " + cityLstSize);
		List<String> cityList = new ArrayList<>();
		for (int i = 1; i < cityLstSize; i++) {
			WebElement sinCityEle = cityEle.get(i);
			String cityName = sinCityEle.getText();
			cityList.addAll(Arrays.asList(cityName));
		}
		System.out.println("cityList-> " + cityList);
		if(cityList.contains("Bengaluru")&&cityList.contains("Chennai")&&cityList.contains("Delhi"))
			System.out.println("City List Are Correct");
		else
			System.out.println("City List Are Not Correct");
	}

	private void chooseCourse2() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='j_idt87:auto-complete']/button")).click();
		Thread.sleep(3000);
		List<WebElement> courseEle = driver
				.findElements(By.xpath("//*[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all']"));
		System.out.println("courseEle.size()-> " + courseEle.size());
		for (int i = 0; i < courseEle.size(); i++) {
			String courseText = courseEle.get(i).getText();
			System.out.println(i + ") " + courseText);
			if (courseText.contains("Selenium"))
				courseEle.get(i).click();
		}
	}

	private void chooseRandom() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='j_idt87']/div/div[2]/div[2]/div")).click();
		List<WebElement> langDrpEle = driver.findElements(By.xpath("//*[@id='j_idt87:lang_input']/option"));
		int drpSize = langDrpEle.size();
		System.out.println("drpSize-> " + drpSize);
		int randInt = ThreadLocalRandom.current().nextInt(2, drpSize);
		System.out.println("randInt-> " + randInt);
		System.out.println("//*[@id='j_idt87:lang_items']/li[" + randInt + "]");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='j_idt87:lang_items']/li[" + randInt + "]")).click();
	}

	private void numTwo() {
		String selectedLang = driver.findElement(By.xpath("//*[@id='j_idt87:lang_label']")).getText();
		System.out.println("selectedLang-> " + selectedLang);
		if (selectedLang.equals("English")) {
			driver.findElement(By.id("j_idt87:value_label")).click();
			driver.findElement(By.xpath("//li[contains(text(),'Two')]")).click();
		} else if (selectedLang.equals("Tamil")) {
			driver.findElement(By.id("j_idt87:value_label")).click();
			driver.findElement(By.xpath("//*[@id='j_idt87:value_label']")).click();
		} else if (selectedLang.equals("Telugu")) {
			driver.findElement(By.id("j_idt87:value_label")).click();
			driver.findElement(By.xpath("//*[@id='j_idt87:value_3']")).click();
		} else if (selectedLang.equals("Kannada")) {
			driver.findElement(By.id("j_idt87:value_label")).click();
			driver.findElement(By.xpath("//*[@id='j_idt87:value_1']")).click();
		} else {
			driver.findElement(By.id("j_idt87:value_label")).click();
			driver.findElement(By.xpath("//*[@id='j_idt87:value_3']")).click();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BaseClass bcl = new BaseClass();
		Sel_07_DropDown sel = new Sel_07_DropDown();
		String uRL = "https://leafground.com/select.xhtml";
		bcl.openURL(uRL);

		// Which is your favorite UI Automation tool?
		sel.favUI();

		// Choose your preferred country.
		sel.country();
		sel.verifyCities();

		// Choose the Course
		sel.chooseCourse2();

		//
		sel.chooseRandom();
		Thread.sleep(3000);

		sel.numTwo();

		// driver.close();
	}

}
