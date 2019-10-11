package Operations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Action_Methods {

	public void click(WebElement elementlocation) {
		try {
			elementlocation.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendText(WebElement elementlocation, String text) {
		try {
			elementlocation.clear();
			elementlocation.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyElementisPresent(WebElement elementlocation) {
		try {
			if (!elementlocation.isDisplayed()) {
				System.out.println(elementlocation + "  " + "is not displayed");
				throw new Exception(elementlocation + " : Not Found");
			} else {
				System.out.println(elementlocation + "  " + "is displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyText(WebElement elementlocation, String expectedresult) {

		if (elementlocation.getText().equals(expectedresult)) {
			System.out.println("Text verifification success");
		} else {
			System.out.println("Text verifification Failed");
		}
		String value = elementlocation.getText();
		System.out.println(value);
	}

	public void selectDropdown(WebElement elementlocation, Integer index) {
		try {
			Select se = new Select(elementlocation);
			se.deselectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void KeyboardAction(WebElement elementlocation, String text) throws InterruptedException {
		elementlocation.sendKeys(text);
		Thread.sleep(2000);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.ENTER);

	}

}
