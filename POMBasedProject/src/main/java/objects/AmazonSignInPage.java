package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSignInPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public AmazonSignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.xpath("//input[@id='ap_email']");
	By cont = By.xpath("//input[@id='continue']");
	By password = By.xpath("//input[@id='ap_password']");
	By sin = By.xpath("//input[@id='signInSubmit']");
	
	public void EnterEmail(String mail) {
		wait = new WebDriverWait(driver, 20);
		WebElement emailBox=wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		emailBox.sendKeys(mail);
		WebElement continueButton=wait.until(ExpectedConditions.visibilityOfElementLocated(cont));
		continueButton.click();
		
	}
	public void EnterPassword(String pword) {
		wait = new WebDriverWait(driver, 20);
		WebElement passwordBox=wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		passwordBox.sendKeys(pword);
		WebElement signButton=wait.until(ExpectedConditions.visibilityOfElementLocated(sin));
		signButton.click();
	}
}
