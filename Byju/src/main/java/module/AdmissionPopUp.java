package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdmissionPopUp {

	@FindBy (xpath="(//button[@class='close'])[2]")
	private WebElement crossButtonOfAdmissionPopUp;

	//constructor
	
	public  AdmissionPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//method
	public void clickOnCrossButtonOfAdmissionPopUp()
	{
		crossButtonOfAdmissionPopUp.click();
	}
	
}
