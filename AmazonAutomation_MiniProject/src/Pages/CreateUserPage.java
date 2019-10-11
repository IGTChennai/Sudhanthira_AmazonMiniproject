package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Operations.Action_Methods;

public class CreateUserPage extends Action_Methods {

	public static WebDriver driver;

	@FindBy(xpath = "//*[@id='nav-link-accountList']/span[2]")
	public WebElement loginButton;

	@FindBy(id = "createAccountSubmit")
	public WebElement createbutton;

	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(xpath = "//*[contains(text(),'Enter your name')]")
	public WebElement nameverificationText;

	@FindBy(xpath = "//*[contains(text(),'Enter your mobile number')]")
	public WebElement mobilenoverificationText;

	@FindBy(xpath = "//*[contains(text(),'Enter your password')]")
	public WebElement passwordverificationText;

	@FindBy(id = "ap_phone_number")
	public WebElement mobileNumber;

	@FindBy(id = "ap_password")
	public WebElement password;

	@FindBy(xpath = "//*[contains(text(),'The mobile number you entered does not seem to be valid')]")
	public WebElement mobilenoverificationTextenter;

	@FindBy(xpath = "(//*[contains(text(),'Passwords must be at least 6 characters.')])[2]")
	public WebElement verifyleastpasswordchar;

	public CreateUserPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openCreateUserPage() {
		try {
			Thread.sleep(5000);
			click(loginButton);Thread.sleep(2000);
			click(createbutton);Thread.sleep(2000);
			click(continueButton);Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyEmptyFieldsErrorMessages() {
		verifyElementisPresent(nameverificationText);
		verifyElementisPresent(mobilenoverificationText);
		verifyElementisPresent(passwordverificationText);
		sendText(password, "abc");
		click(continueButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyElementisPresent(verifyleastpasswordchar);
	}

	public void textverifcationinMobileTextbox() {
		sendText(mobileNumber, "testtext");
		click(continueButton);
		verifyElementisPresent(mobilenoverificationTextenter);

	}

}
