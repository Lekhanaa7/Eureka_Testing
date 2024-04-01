package edurekaportal.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() throws InterruptedException {
		loginPage.doLogin("1ms20ec045@gmail.com", "Edureka@07");
	}
}
