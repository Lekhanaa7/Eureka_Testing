package edurekaportal.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import edurekaportal.commonutils.CommonUtils;
import edurekaportal.pageobject.LoginPage;
import edurekaportal.pageobject.ProfilePage;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected ProfilePage profilePage;
	private CommonUtils commonUtils;

	@BeforeMethod
	public void setUp() throws IOException {
		driver = CommonUtils.createDriver(LoginPage.loadProperties());
		loginPage = new LoginPage(driver);
		profilePage = new ProfilePage(driver);
		commonUtils.browserSetup(driver);
	}

	@AfterMethod
	public void tearDown() {

		loginPage.closeBrowser();
	}
}
