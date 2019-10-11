package amazon.main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.CartPages;
import Pages.CreateUserPage;
import Pages.LoginUserPage;
import Pages.SearchItemsAddcart;
import Report.JUnitHTMLReporter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpenBrowser extends JUnitHTMLReporter {

	public static WebDriver driver;

	@BeforeClass
	public static void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	@Test
	public void test1VerifyCreateAccountFieldsErrorMessages() {
		CreateUserPage createuser = PageFactory.initElements(driver, CreateUserPage.class);
		createuser.openCreateUserPage();
		createuser.verifyEmptyFieldsErrorMessages();
		createuser.textverifcationinMobileTextbox();
	}
	@Test
	public void test2VerifyLoginSuccessOrFail() {
		LoginUserPage login = PageFactory.initElements(driver, LoginUserPage.class);
		login.verifyloginemptyValue();
		login.verifyinvaliedusername();    
		login.verifylogincorrectly_Or_not();
	}
	@Test
	public void test3VerifyCart() {
		CartPages cart = PageFactory.initElements(driver, CartPages.class);
		cart.verycart();
		driver.navigate().back();
	}
	@Test
	public void test4SearchItems() throws InterruptedException {
		SearchItemsAddcart search = PageFactory.initElements(driver, SearchItemsAddcart.class);
		search.Search_5th_item();
		search.FindItem();
        Thread.sleep(6000);
        search.logout();
	}

	@AfterClass
	public static void quit() {
		driver.quit();
	
	}

}
