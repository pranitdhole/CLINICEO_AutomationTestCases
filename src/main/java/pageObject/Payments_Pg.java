package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Payments_Pg {
	
	@FindBy(how=How.XPATH,using="//div[text()='Payments']")
	private WebElement payments;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Credit Notes ']")
	private WebElement CreditNotes;
	

	public WebElement getPayments() {
		return payments;
	}

	public WebElement getCreditNotes() {
		return CreditNotes;
	}
}