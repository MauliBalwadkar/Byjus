package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExamPapersPage {
	
	@FindBy (xpath="//select[@id='grade_filter']")
	private WebElement gradeDropdown;
	
	@FindBy (xpath="//select[@id='board_filter']")
	private WebElement examDropdown;
	
	@FindBy (xpath="//select[@id='subject_filter']")
	private WebElement subjectDropdown;
	
	@FindBy (xpath="(//div[@class='examsv2_examYearsText__2iDvC'])[2]")
	private WebElement qustionPaperYear;
	
	
private WebDriver driver;
	
	
	//Constructor
	public ExamPapersPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	//Methods
	public void selectGradeFromDropdown()
	{
		
		Select s =new Select(gradeDropdown);
		s.selectByIndex(2);
	}
	
	public void selectExamFromDropdown()
	{
		
		Select s =new Select(examDropdown);
		s.selectByVisibleText("CBSE");
	}
	
	public void selectSubjectFromDropdown()
	{
		
		Select s =new Select(subjectDropdown);
		s.selectByValue("Mathematics");
	}
	
	public void clickOnQustionPaperYear()
	{
		
		 qustionPaperYear.click();
	}
	
//	public String getTextOfGrade()
//	{
//		Select s =new Select(gradeDropdown);
//		String result=s.selectByIndex(2)
//		//return gradeDropdown.getText();
//		return result;
//		selectGradeFromDropdown().getText()
	//}

}
