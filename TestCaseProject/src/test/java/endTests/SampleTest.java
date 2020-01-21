package endTests;

import org.testng.annotations.Test;

import pageObjects.HomePage;

import com.relevantcodes.extentreports.LogStatus;

public class SampleTest extends BaseTest{
	
	@Test
	public void validationTest()
	{
		test=extent.startTest("validationTest");
		HomePage homePage=new HomePage(driver, test);
		homePage.searchtext("stainless work table");
		assertTrue(homePage.validateData("table"),test);
		homePage.addLastItem();
		homePage.emptyCart();
		assertTrue(homePage.validatecartEmpty(),test);
		extent.endTest(test);
		
	}
	
}
