package testScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AmazonHomePage;
import objects.AmazonProductPage;
import objects.AmazonSignInPage;

public class Test_Amazon {

	WebDriver driver;
	AmazonHomePage objectrepo;
	
	@BeforeClass
	@Parameters("url")
	public void driverInstance1(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	@Test(priority = 0)
	public void Signin() {
		AmazonHomePage page1=new AmazonHomePage(driver);
		page1.SignIn();
	}
	
	@Test(priority = 1)
	@Parameters("email")
	public void EnterEmail(String mail) {
		AmazonSignInPage page2=new AmazonSignInPage(driver);
		page2.EnterEmail(mail);
	}
	
	@Test(priority = 2)
	@Parameters("password")
	public void EnterPassword(String pword) {
		AmazonSignInPage page3=new AmazonSignInPage(driver);
		page3.EnterPassword(pword);
	}
	
	@Test(priority = 3)
	@Parameters("search")
	public void HomePageOperation1(String search) {
		AmazonHomePage page4=new AmazonHomePage(driver);
		page4.SearchInAmazon(search);
	}
	
	@Test(priority = 4)
	public void HomePageOperation2() {
//		AmazonHomePage page2=new AmazonHomePage(driver);
//		page2.selectProduct();
		objectrepo=new AmazonHomePage(driver);
		objectrepo.selectProduct();
	}
	
	@Test(priority = 5)
	public void addToCartOperation() {
		AmazonProductPage page5=new AmazonProductPage(driver);
		page5.addToCart();
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}
