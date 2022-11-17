package appointments_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;

public class Consultation_appointment_test extends BaseClass{

	@Test(dataProvider="Names")
	public void ConsultationAppoinment(String Patient) throws InterruptedException {
		WebElement Appointment = driver.findElement(By.xpath("//div[text()='Appointments']"));
		Appointment.click();
		WebElement NewAppointment =driver.findElement(By.xpath("(//button[@class='button-filled-primary'])[1]"));
		NewAppointment.click();
		WebElement PatientName=driver.findElement(By.xpath("//input[@placeholder='Type patient name']"));
		PatientName.click();
		PatientName.sendKeys(Patient);
		Thread.sleep(5000);
		//PatientName.sendKeys("Pranit Dhole");//Manual Name can be added from here
		driver.findElement(By.xpath("//li[@class='ng-star-inserted']")).click();
		
		WebElement Appoinmenttype= driver.findElement(By.xpath("//input[@class='form__input ng-untouched ng-pristine ng-invalid']"));
		Appoinmenttype.click();
		WebElement NewConsultation=driver.findElement(By.xpath("//span[text()='Book New Consultation']"));
		NewConsultation.click();
		driver.findElement(By.xpath("//span[text()=' Superdoc_Pranit ']")).click();
		WebElement SearchProblem = driver.findElement(By.xpath("//input[@placeholder='Type name of the Problem']"));
		SearchProblem.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Acne ']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		WebElement time1= driver.findElement(By.xpath("//div[text()=' 9:00 PM ']"));
		if(time1.isSelected()==false) {
			time1.click();
		}
		WebElement Bookbtn=driver.findElement(By.xpath("//button[text()=' Schedule Appointment']"));
		Thread.sleep(2000);
		Bookbtn.click();
		WebElement PayLater=driver.findElement(By.xpath("//button[text()=' Pay Later ']"));
		PayLater.click();
		driver.findElement(By.xpath("(//button[text()='Done'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Done'])")).click();
		System.out.println("Consultation appointment generated successfully");
	}
	
	@DataProvider(name="Names")
	public Object[][]Patients(){

		return new Object[][] {
			{"Pranit Dhole"},
			/*{"Vijay K"},
			{"Smaran"}*/
		};
	}
}
