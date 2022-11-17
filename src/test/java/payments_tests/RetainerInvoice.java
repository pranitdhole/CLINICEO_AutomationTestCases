package payments_tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;

public class RetainerInvoice extends BaseClass{

	@Test(dataProvider="TestData")
	public void NewRetainerInvoice(String Patient,String amount, String mode) throws InterruptedException {
		WebElement Paymentsbtn= driver.findElement(By.xpath("//div[text()='Payments']"));
		Paymentsbtn.click();
		WebElement RetainerInv= driver.findElement(By.xpath("//div[text()=' Retainer Invoices ']"));
		RetainerInv.click();
		WebElement NewRetainer= driver.findElement(By.xpath("//button[text()=' Create Retainer Invoice ']"));
		NewRetainer.click();
		Thread.sleep(3000);
		WebElement SearchPatient=driver.findElement(By.xpath("//input[@placeholder='Type Patient Name']"));
		SearchPatient.click();
		SearchPatient.sendKeys(Patient);
		Thread.sleep(2000);
		WebElement searchbox=driver.findElement(By.xpath("//span[@class='d-flex justify-content-between ng-star-inserted']"));
		searchbox.click();
		WebElement Amount=driver.findElement(By.xpath("//input[@class='form__input ng-untouched ng-pristine ng-valid ng-star-inserted']"));
		Amount.click();
		Amount.sendKeys(Keys.BACK_SPACE);
		Amount.sendKeys(amount);
		WebElement Mode=driver.findElement(By.xpath("/html/body/app-root/mnp-patients/sbpro-layout-dashboard/span/div/div[2]/main/mnp-retainer-invoice-form/div/div[2]/form/div[1]/div[2]/div[1]/mnp-input/div/input"));
		Mode.click();
		Mode.sendKeys(mode);
		driver.findElement(By.xpath("//li[@class='ng-star-inserted']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		WebElement AlertYes=driver.findElement(By.xpath("//button[text()='Yes']"));
		AlertYes.click();
		Thread.sleep(3000);
		System.out.println("Retainer Invoice Generated");


		/*Screenshotcode
		TakesScreenshot scrShot =((TakesScreenshot)driver);
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile=new File();
                FileUtils.copyFile(SrcFile, DestFile);
    }
		 */
	}

	@DataProvider(name="TestData")
	public Object[][]testdata(){

		return new Object[][] {
			{"Pranit Dhole","50000","Cash"},
			{"Vijay K","6000","UPI"},
			{"Samuel","10000","Card"},
		};
	}
	
	
	
	
	
	
	
}
