package edurekaportal.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import edurekaportal.commonutils.CommonUtils;

public class LoginPage {
	private WebDriver driver;
	private CommonUtils commonUtils;

	public static String loadProperties() throws IOException {
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		return browser;

	}

	public void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[@data-toggle='modal' and @data-target='#new_sign_up_optim' and contains(@class, 'login_click login-vd giTrackElementHeader ')]")
	private WebElement logInBtn;

	@FindBy(how = How.XPATH, using = "//input[@class='control_place popusreml' and @type='email']")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "//input[@type='password' and @id='si_popup_passwd']")
	private WebElement passwordBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='clik_btn_log btn-block']")
	private WebElement logIn;

	@FindBy(how = How.XPATH, using = "//p[@id='emailError']")
	private WebElement errorMsgMail;

	@FindBy(how = How.XPATH, using = "//p[@id='phoneNoError']")
	private WebElement errorMsgPh;

	public void doLogin(String email, String passWord) throws InterruptedException {

		commonUtils.waitForElement(driver, logInBtn, 2);
		logInBtn.click();
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, emailInput, 2);
		emailInput.sendKeys(email);
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, passwordBtn, 2);
		passwordBtn.sendKeys(passWord);
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, logIn, 2);
		logIn.click();
		Thread.sleep(10000);

		//			commonUtils.waitForElement(driver, errorMsgMail, 2);
		//			String msg = errorMsgMail.getText();
		//			System.out.println(msg);
		//			commonUtils.waitForElement(driver, errorMsgPh, 2);
		//			String msgPh = errorMsgPh.getText();
		//			System.out.println(msgPh);
		//			driver.quit();

	}
}
