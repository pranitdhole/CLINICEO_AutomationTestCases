package login_Roles_tests;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDiffRoles {

	@Test(dataProvider="credentials")
	public void DifferentRolesLogin(String LoginRoleRole,String email, String Pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://64.227.188.11/clinic/auth/login");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement ID=driver.findElement(By.xpath("//input[@placeholder='Enter email address']"));
		ID.sendKeys(email);
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Enter password']"));
		password.sendKeys(Pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		SoftAssert softassert= new SoftAssert();
		String DashBoard= driver.getCurrentUrl();
		String URL = driver.getCurrentUrl();
		softassert.assertEquals(Pass, DashBoard, URL);
		System.out.println("Loggedin Success !");
		driver.close();

	}

	@DataProvider(name="credentials")
	public Object[][]credentials(){

		return new Object[][] {
			{"Superdoc","dpranit07@gmail.com","Aa123456789"},
			{"Doctor","jeceni6533@pamaweb.com","Aa123456789"},
			{"Consultant","vahesop275@dakcans.com","Aa123456789"},
			{"InvalidSuperdoc","pranit07@gmail.com","AA123456789"},
			{"InvalidDoc","pranit07@gmail.com","AA123456789"}
		};
	}
}