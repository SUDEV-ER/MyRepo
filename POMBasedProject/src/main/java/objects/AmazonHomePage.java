package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By signin = By.xpath("(//span[text()='Hello, Sign in'])");
	By searchbox=By.xpath("//input[@id='twotabsearchtextbox']");
	By searchbutton=By.xpath("//input[@id='nav-search-submit-button']");
	By product=By.xpath("(//span[text()='Rich Dad Poor Dad: What the Rich Teach Their Kids About Money That the Poor and Middle Class Do Not!'])[1]");

	
	public void SignIn() {
//		wait = new WebDriverWait(driver, 20);
//		WebElement we1=wait.until(ExpectedConditions.visibilityOfElementLocated(signin));
//		we1.click();
		driver.findElement(signin).click();
	}
	
	public void SearchInAmazon(String search) {
		wait = new WebDriverWait(driver, 20);
		Actions actions = new Actions(driver);
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
		actions.click(searchField).perform();
//		
//		WebElement we7=wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
		searchField.sendKeys(search);
		WebElement searchFieldButton=wait.until(ExpectedConditions.visibilityOfElementLocated(searchbutton));
		searchFieldButton.click();
	}
	
	public void selectProduct() {
		wait = new WebDriverWait(driver, 20);
		WebElement productBook=wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		productBook.click();
	}
}
