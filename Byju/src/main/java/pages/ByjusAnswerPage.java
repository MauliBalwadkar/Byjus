package pages;

import java.awt.Window;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ByjusAnswerPage {
	
	@FindBy (xpath="//input[@id='searchInput']")
	private WebElement findSolutionSearchBox;
	
	@FindBy (xpath="(//span[@style='display: block;'])[1]")
	private WebElement question;
	
	@FindBy (xpath="//div[@class='index_subRedirect2__34uwx']")
	private WebElement questionPapersSection;
	
	
	private WebDriver driver;
	
	
	//Constructor
	public ByjusAnswerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	//Methods
	public void clickOnFindSolutionSearchBox()
	{
		findSolutionSearchBox.click();
	}
	
	public void sendQuestionInFindSolutionSearchBox(String question)
	{
		findSolutionSearchBox.sendKeys(question);
	}
	
	public void selectQuestion()
	{
		question.click();
	}
	
	public void scrollThePage()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public void clickOnQuestionPapersSection()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",questionPapersSection);
		questionPapersSection.click();
	}
	
	public String getTextOfQuestion()
	{
		return question.getText();
	}
	
	
	
	

}
