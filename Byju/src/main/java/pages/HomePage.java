package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[text()='BTC']")
	private WebElement btcOption;
	
	@FindBy(xpath="//div[@class='primary-dropdown-menu primary-dropdown-menu-index-3']//ul//li[@class='sub']")
	private List<WebElement> listOfBtcZone;
	
	@FindBy(xpath="//ul[@class='right-popopen']//li[@class='sub']")
	private List<WebElement> tutionInState;
	
	@FindBy(xpath="//ul[@class='right-popopen more-less-open']//li")
	private List<WebElement> tutionInCity;
	
	@FindBy (xpath="(//a[@href='/question-answer/'])[1]")
	private WebElement byjusAnswer;
	
	private WebDriver driver;
	private Actions _actions;
	
	//constructor
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		_actions=new Actions(driver);
	}

	//method
	
	// Actions act=new Actions(driver);
	
	public void HoverOnBtcOption()
	{
		
		_actions.moveToElement(btcOption).perform();
		
	}
	
	public void selectOptionFromDropDownOfBtc()
	{
		for(int i=0;i<listOfBtcZone.size();i++)
		{
			String result=listOfBtcZone.get(i).getText();
			if(result.contains("Tuition in West Zone"))
			{
				
				System.out.println(listOfBtcZone.get(i).getText());
				_actions.moveToElement(listOfBtcZone.get(i)).perform();
				break;
			}
			
		}
	}
	
	public void selectOptionFromTutionInState()
	{
		
		for(int i=0;i<tutionInState.size();i++)
		{
		   String result1=tutionInState.get(i).getText();
			if(result1.contains("Tuition in Maharashtra"))
			{ 
				//Actions act=new Actions(driver);
				System.out.println(tutionInState.get(i).getText());
				_actions.moveToElement(tutionInState.get(i)).perform();
				break;
			}	
		}
	}
	
	
	public void selectTutionInCity()
	{
		for(int i=0;i< tutionInCity.size();i++)
		{
				String result= tutionInCity.get(i).getText();
				if(result.contains("Tuition in Navi Mumbai"))
				{
					//Actions act=new Actions(driver);
			      _actions.moveToElement( tutionInCity.get(i)).perform();
		         System.out.println( tutionInCity.get(i).getText());
		         _actions.click().perform();
		         break;
				}
		}
	}
	
	public void clickOnByjusAnswer()
	{
		byjusAnswer.click();
	}
	
	
	public String getTextListOfBtcZone()
	{
		 String result1 ="";
		for(int i=0;i<listOfBtcZone.size();i++)
		{
			String result=listOfBtcZone.get(i).getText();
			result1=result;
			System.out.println(result1);
		}
		return result1;
		
	}
	
	
	
	
}
