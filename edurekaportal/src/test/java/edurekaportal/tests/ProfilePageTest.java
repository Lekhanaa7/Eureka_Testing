package edurekaportal.tests;

import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest {
	@Test
	public void testProfilePage() throws InterruptedException {
		loginPage.doLogin("1ms20ec045@gmail.com", "Edureka@07");
		profilePage.updatePersonalDetails();
	}

}
