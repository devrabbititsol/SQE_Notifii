package web.sqe_notifii.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;

public class Login_New extends BaseClass {
	public static String projectName = "sqe_notifii";
	public WebDriver driver;

	public Login_New(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")	
	private WebElement	Username_473887input;
	public String fillinputUsername_473887(String varInputValue) {
		waitForExpectedElement(driver, Username_473887input);
		Username_473887input.sendKeys(varInputValue);
		return text;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='password']")	
	private WebElement	Password_473901input;
	public String fillinputPassword_473901(String varInputValue) {
		waitForExpectedElement(driver, Password_473901input);
		Password_473901input.sendKeys(varInputValue);
		return text;
	}

	@FindBy(how = How.XPATH, using = "//form[@id='login-form']/fieldset[1]/section[4]/div[1]/div[2]/button")	
	private WebElement	LogIn_473924button;
	public String clkbuttonLogIn_473924() {
		waitForExpectedElement(driver, LogIn_473924button);		
		String text = LogIn_473924button.getText();
		LogIn_473924button.click();
		return text;
	}

}