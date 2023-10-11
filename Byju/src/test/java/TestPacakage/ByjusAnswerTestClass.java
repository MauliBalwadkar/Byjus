package TestPacakage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ByjusAnswerPage;
import pages.ExamPapersPage;
import pages.HomePage;

public class ByjusAnswerTestClass {
	
	public static void main(String[] args) {
		
       WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://byjus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		
		HomePage _homepage=new  HomePage(driver);
		_homepage.clickOnByjusAnswer();
		
		ByjusAnswerPage _byjusAnswerPage = new ByjusAnswerPage(driver);
		_byjusAnswerPage.clickOnFindSolutionSearchBox();
		_byjusAnswerPage.sendQuestionInFindSolutionSearchBox("What is the full form of GST");
		_byjusAnswerPage.selectQuestion();
		_byjusAnswerPage.scrollThePage();
		
		HomePage _homepage1=new  HomePage(driver);
		_homepage1.clickOnByjusAnswer();
		
		_byjusAnswerPage.clickOnQuestionPapersSection();
		
		ExamPapersPage _examPapersPage = new ExamPapersPage(driver);
		_examPapersPage.selectGradeFromDropdown();
		_examPapersPage.selectExamFromDropdown();
		_examPapersPage.selectSubjectFromDropdown();
		_examPapersPage.clickOnQustionPaperYear();
	}

}
