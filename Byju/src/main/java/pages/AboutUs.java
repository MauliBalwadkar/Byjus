package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AboutUs {
	
	@FindBy (xpath="//select[@id='stateSel']")
	private WebElement State;
	
	@FindBy (xpath="//select[@id='citySel']")
	private WebElement city;
	
	@FindBy (xpath="(//button[@class='get-to-center-btn'])[1]")
	private WebElement goToCenterButton; 
	
	private WebDriver driver;
	private Actions _action;
	
	public AboutUs(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		_action=new Actions (driver);
	}
	
	public void selectStateOption()
	{
		Select _select= new Select (State);
		_select.selectByVisibleText("Maharashtra");
	}
	
	public void selectCityOption()
	{
		Select _select = new Select (city);
		_select.selectByIndex(12);
	}
	
	public void clickOnGoToCenterButton()
	{
		goToCenterButton.click();
	}
	
	
}
