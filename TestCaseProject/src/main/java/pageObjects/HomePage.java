package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumUtils;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends SeleniumUtils{

	@FindBy(how=How.ID,using="searchval")
	WebElement searchtext;
	@FindBy(how=How.XPATH,using="//button[text()='Search']")
	WebElement Search;
	@FindBy(how=How.XPATH,using="//a[@href='/viewcart.cfm']")
	WebElement viewcart;
	@FindBy(how=How.XPATH,using="//a[text()='Empty Cart']")
	WebElement emptycart;
	@FindBy(how=How.XPATH,using="//button[text()='Empty Cart']")
	WebElement confirmemptycart;
	@FindBy(how=How.XPATH,using="//p[text()='Your cart is empty.']")
	WebElement cartemptymessage;
	
	
	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void searchtext(String text)
	{
		sendKeys(searchtext, text, "searchtext");
		clickElement(Search, "Search");
		sleep();
	}
	
	
	public boolean validateData(String text)
	{
		List<WebElement> data=driver.findElements(By.xpath("//a[@class='description']"));
		for(WebElement d:data)
			if(!d.getText().toLowerCase().contains(text))
				return false;
		return true;
		
	}
	
	public void addLastItem()
	{
		List<WebElement> data=driver.findElements(By.xpath("//div[@class='cartAndQuantity']/input[2]"));
		clickElement(data.get(data.size()-1), "LastAddtoCart");
	}
	
	public void emptyCart()
	{
		clickElement(viewcart, "viewcart");
		sleep();
		clickElement(emptycart, "emptycart");
		sleep();
		clickElement(confirmemptycart, "confirmemptycart");
		sleep();
	}
	
	public boolean validatecartEmpty()
	{
		return cartemptymessage.isDisplayed();
	}

}
