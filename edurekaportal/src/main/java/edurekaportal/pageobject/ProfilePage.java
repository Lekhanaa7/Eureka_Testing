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

public class ProfilePage {
	private final WebDriver driver;
	private CommonUtils commonUtils;
	private LoginPage loginPage;

	public void testLogin() throws InterruptedException {
		loginPage.doLogin("1ms20ec045@gmail.com", "Edureka@07");
		Thread.sleep(10000);
	}

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

	public ProfilePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//img[@class='img30']")
	private WebElement profileBtn;

	@FindBy(how = How.XPATH, using = "//a[@class='giTrackElementHeader' and @data-button-name='My Profile']")
	private WebElement myProfileBtn;

	@FindBy(how = How.XPATH, using = "//a[@href='/my-profile/career-service']")
	private WebElement careerServiceBtn;

	@FindBy(how = How.XPATH, using = "(//i[@class='icon-pr-edit'])[2]")
	private WebElement editBtn;

	@FindBy(how = How.XPATH, using = "//select[@class='form-control form-element ng-pristine ng-valid ng-touched']")
	private WebElement currentJobBtn;

	@FindBy(how = How.XPATH, using = "(//button[@class='ngx-dropdown-button' and @type='button'])[2]")
	private WebElement industryDropdownBtn;

	@FindBy(how = How.XPATH, using = "//button[@id='wzrk-cancel']")
	private WebElement overlay;
	//ul[@class='available-items']//li[contains(text(), '4-7 years')]

	public void updatePersonalDetails() throws InterruptedException {
		commonUtils.waitForElement(driver, profileBtn, 2);
		profileBtn.click();
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, myProfileBtn, 2);
		myProfileBtn.click();
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, careerServiceBtn, 2);
		careerServiceBtn.click();
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, editBtn, 2);
		editBtn.click();
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, currentJobBtn, 2);
		currentJobBtn.click();
		Thread.sleep(2000);
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);

	}
}
