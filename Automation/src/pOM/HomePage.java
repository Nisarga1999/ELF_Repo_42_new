package pOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(id = "SignIn") // ctrl A(select all)ctrl shift f(formate change)
	private WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getEmailSignInTextBox() {
		return emailSignInTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getSignInTextBox() {
		return signInTextBox;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getPassWordTextBox() {
		return passWordTextBox;
	}

	public WebElement getNameTextBox() {
		return nameTextBox;
	}

	public WebElement getMobileTextBox() {
		return mobileTextBox;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}

	public WebElement getReSignIn() {
		return reSignIn;
	}

	public WebElement getReEmailTextBox() {
		return reEmailTextBox;
	}

	public WebElement getRePassWordTextBox() {
		return rePassWordTextBox;
	}

	public WebElement getReNameTextBox() {
		return reNameTextBox;
	}

	public WebElement getRemMobileTextBox() {
		return remMobileTextBox;
	}

	@FindBy(id = "loginIdText")
	private WebElement emailSignInTextBox;

	@FindBy(id = "passwordText")
	private WebElement passwordTextBox;

	@FindBy(id = "loginValidate")
	private WebElement signInTextBox;

	@FindBy(xpath = "//span[text()='SIGN UP']")
	private WebElement signUpButton;

	@FindBy(id = "emailIdSignUp")
	private WebElement emailTextBox;

	@FindBy(id = "passwordSignUp")
	private WebElement passWordTextBox;

	@FindBy(id = "nameSignUp")
	private WebElement nameTextBox;

	@FindBy(id = "mobileNoSignUp")
	private WebElement mobileTextBox;

	@FindBy(id = "signUpValidate")
	private WebElement createAccount;

	@FindBy(id = "loginIdText")
	private WebElement reSignIn;

	@FindBy(id = "loginIdText")
	private WebElement reEmailTextBox;

	@FindBy(id = "passwordSignUp")
	private WebElement rePassWordTextBox;

	@FindBy(id = "nameSignUp")
	private WebElement reNameTextBox;

	@FindBy(id = "mobileNoSignUp")
	private WebElement remMobileTextBox;

	@FindBy(xpath = "//span[text()='Hotels ']")
	private WebElement hotelNavBarElement;

	public WebElement getHotelNavBarElement() {
		return hotelNavBarElement;
	}

	public WebElement getDestinationTextBox() {
		return destinationTextBox;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	@FindBy(id = "destination")
	private WebElement destinationTextBox;
	@FindBy(id = "checkIn")
	private WebElement checkIn;

}
