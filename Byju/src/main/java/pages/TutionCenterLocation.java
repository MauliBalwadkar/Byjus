package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TutionCenterLocation {
	
	@FindBy (xpath="(//span[@class='vtl-algn-mdl'])[3]")
	private WebElement getDirection;
	
	private WebDriver driver;
	
	public TutionCenterLocation(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void clickOnGetDirection()
	{
		getDirection.click();
	}

}
