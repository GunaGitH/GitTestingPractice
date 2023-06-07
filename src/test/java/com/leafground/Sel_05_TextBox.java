package com.leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.util.BaseClass;

public class Sel_05_TextBox extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		BaseClass bcl = new BaseClass();
		String uRL = "https://leafground.com/input.xhtml;jsessionid=node02uc5y9pro8pl1l7ijc6l5lft2291941.node0";
		bcl.openURL(uRL);
		//Thpe Your Name
		driver.findElement(By.id("j_idt88:name")).sendKeys("Guna");
		//Append Country to this City.
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys(" - India");
		//Verify if text box is disabled
		boolean isEnabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		if (isEnabled==true)
			System.out.println("Text Box is enabled");
		else
			System.out.println("Text Box is disabled");
		//Clear the typed text.
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		//Retrieve the typed text.
		String retriveText = driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value");
		System.out.println("retriveText -> "+retriveText);
		//Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("guna@raj.com",Keys.TAB);
		//Type about yourself
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("ok",Keys.TAB);
		//Text Editor
		driver.findElement(By.xpath("//*[@class = 'ql-editor ql-blank']")).sendKeys("ok");
		//Just Press Enter and confirm error message
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		String ageErrorMsg = driver.findElement(By.xpath("//*[@id='j_idt106:thisform:j_idt110_error-detail']")).getText();
		if(ageErrorMsg.equals("Age is mandatory"))
			System.out.println("Correct Error Message");
		else
			System.out.println("In-Correct Error Message");
		
		//Click and Confirm Label Position Changes
		WebElement userNameEle = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt113']"));
		int oldXAxis = userNameEle.getLocation().getX();
		System.out.println(oldXAxis);
		Thread.sleep(5000);
		driver.findElement(By.id("j_idt106:float-input")).click();
		Thread.sleep(5000);
		int newXAxis = userNameEle.getLocation().getX();
		System.out.println("oldXAxis->"+oldXAxis+" newXAxis->"+newXAxis);
		if(oldXAxis!=newXAxis)
			System.out.println("Label's Position Is Changed");
		else
			System.out.println("Label's Position Is Not Changed");
		
		//Type your name and choose the third option
		driver.findElement(By.xpath("//*[@id='j_idt106:auto-complete_input']")).sendKeys("Guna");
		driver.findElement(By.xpath("//*[@id='j_idt106:auto-complete_panel']/ul/li[3]")).click();
		
		//Type your DOB (mm/dd/yyyy) and confirm date chosen
		String dOB = "15/05/1990";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement dOBEle = driver.findElement(By.id("j_idt106:j_idt116_input"));
		js.executeScript("arguments[0].setAttribute('value','"+dOB+"')", dOBEle);
		Object actDOB = js.executeScript("return arguments[0].getAttribute('value')", dOBEle);
		String expDOB = dOB;
		boolean dOBVerify = actDOB.equals(expDOB);
		if(dOBVerify==true)
			System.out.println("DOB is equal");
		else
			System.out.println("DOB is not equal");
		
		//Type number and spin to confirm value changed
		WebElement spinTxtEle = driver.findElement(By.id("j_idt106:j_idt118_input"));
		//spinTxtEle.sendKeys("5");
		js.executeScript("arguments[0].setAttribute('value','5')", spinTxtEle);
		driver.findElement(By.xpath("//*[@id='j_idt106:j_idt118']/a[1]")).click();
		Object actSpinTxt = js.executeScript("return arguments[0].getAttribute('value')", spinTxtEle);
		System.out.println(actSpinTxt);
		
	}

}
