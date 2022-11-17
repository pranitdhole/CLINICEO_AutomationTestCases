package feedback_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseClass;

public class NewFeedback extends BaseClass{
	
	@Test(groups= {""})
	public void Create_Feedback() {
		WebElement Feedbackbtn=driver.findElement(By.xpath("//div[text()='Feedback']"));
		Feedbackbtn.click();
		WebElement NewFeedback=driver.findElement(By.xpath("(//button[@class='button-filled-primary'])[1]"));
		NewFeedback.click();
		WebElement PatientName=driver.findElement(By.xpath("//input[@placeholder='Type Patient Name']"));
		PatientName.sendKeys("Pranit Dhole");
		WebElement DoctorName=driver.findElement(By.xpath("//input[@placeholder='Type Doctor Name']"));
		DoctorName.sendKeys("Dr. Pranit");
		WebElement FormName=driver.findElement(By.xpath("//input[@placeholder='Type feedback form name']"));
		FormName.sendKeys("Complete questions");
		driver.findElement(By.xpath("//span[text()=' Complete questions ']")).click();
		WebElement chk1=driver.findElement(By.xpath("(//span[@class='checkmark'])[1]"));
		chk1.click();
		WebElement radio2=driver.findElement(By.xpath("(//span[@class='radio-checkmark'])[2]"));
		radio2.click();
		WebElement Description=driver.findElement(By.xpath("//textarea[@class='form__text_area ng-star-inserted']"));
		Description.click();
		Description.sendKeys("This is feedback form");
		WebElement Save=driver.findElement(By.xpath("//button[text()='Save']"));
		//Save.click();
		System.out.println("Feedback Form is generated successfully !!");
	}

	@Test(groups= {""}) 
	public void Share_FeedbackMail() {
		WebElement Feedback=driver.findElement(By.xpath("//div[text()='Feedback']"));
		Feedback.click();
		WebElement NewFeedback=driver.findElement(By.xpath("(//button[@class='button-filled-primary'])[1]"));
		NewFeedback.click();
		WebElement PatientName=driver.findElement(By.xpath("//input[@placeholder='Type Patient Name']"));
		PatientName.sendKeys("Pranit Dhole");
		WebElement FormName=driver.findElement(By.xpath("//input[@placeholder='Type feedback form name']"));
		FormName.sendKeys("Complete questions");
		WebElement MailShare=driver.findElement(By.xpath("//span[@class='tick-mark tick-mark-unticked']"));
		MailShare.click();
		WebElement Sharebtn=driver.findElement(By.xpath("//button[@class='button-filled-secondary-s']"));
		Sharebtn.click();
		System.out.println("Form is shread via mail");	
	}
	
	@Test(groups= {""}) 
	public void Share_FeedbackWAP() {
		WebElement Feedback=driver.findElement(By.xpath("//div[text()='Feedback']"));
		Feedback.click();
		WebElement NewFeedback=driver.findElement(By.xpath("//button[@class='button-filled-primary']"));
		NewFeedback.click();
		WebElement PatientName=driver.findElement(By.xpath("//input[@placeholder='Type Patient Name']"));
		PatientName.sendKeys("Pranit Dhole");
		WebElement FormName=driver.findElement(By.xpath("//input[@placeholder='Type feedback form name']"));
		FormName.sendKeys("Complete questions");
		WebElement WAPShare=driver.findElement(By.xpath("(//span[@class='tick-mark tick-mark-unticked'])[2]"));
		WAPShare.click();
		WebElement Sharebtn=driver.findElement(By.xpath("//button[@class='button-filled-secondary-s']"));
		Sharebtn.click();
		System.out.println("Form is shread via Whatsapp");	
	}
}
