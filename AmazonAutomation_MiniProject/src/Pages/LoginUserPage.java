package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Operations.Action_Methods;

public class LoginUserPage extends Action_Methods {

	public WebDriver driver;

	@FindBy(xpath = "(//*[contains(text(),'Sign in')])[1]")
	public WebElement SignIn;
	
	@FindBy(id = "continue")
	public WebElement continueButton;
	
	@FindBy(xpath = "//*[contains(text(),'Enter your email or mobile phone number')]")
	public WebElement entermobilenoText;

	@FindBy(id = "auth-error-message-box")
	public WebElement Errormessage;
	
	@FindBy(id = "ap_email")
	public WebElement Emailtextbox;

	@FindBy(xpath = "//*[contains(text(),'Hello, venkat')]")
	public WebElement username;
	
	@FindBy(id = "ap_password")
	public WebElement password;
	
	@FindBy(id = "signInSubmit")
	public WebElement Loginbutton;

	public LoginUserPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyloginemptyValue() {

		click(SignIn);
		click(continueButton);
		verifyElementisPresent(entermobilenoText);

	}

	public void verifyinvaliedusername() {
		sendText(Emailtextbox, "354646");
		click(continueButton);
		verifyElementisPresent(Errormessage);
	}

	public void verifylogincorrectly_Or_not() {
		sendText(Emailtextbox, "sudha151994@gmail.com");
		click(continueButton);
		sendText(password, "Qwerty15");
		click(Loginbutton);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyText(username, "Hello, Sudhanthira");
	}

}
