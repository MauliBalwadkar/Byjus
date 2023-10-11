package TestPacakage;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ByjusAnswerPage;
import pages.ExamPapersPage;
import pages.HomePage;

public class VerifyByjusAnswerModuleTestNG extends BrowserLaunch{
	
private WebDriver driver;
private ByjusAnswerPage _byjusAnswerPage;
private ExamPapersPage _examPapersPage;

	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=launchChrome();
		}
		if(browserName.equals("Edge"))
		{
			driver=launchEdge();
			
		}
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void createPOMObject()
	{
		_byjusAnswerPage = new ByjusAnswerPage(driver);
		_examPapersPage = new ExamPapersPage(driver);
		
	}

	
	@BeforeMethod
	public void verifyCoarseInformation()
	{
		driver.get("https://byjus.com/");
		
		HomePage _homepage=new  HomePage(driver);
		  _homepage.clickOnByjusAnswer();
		
	}
	
	@Test (priority=1)
	public void verifyFindSolutionsSearchBoxFunctionality()
	{
		ByjusAnswerPage _byjusAnswerPage = new ByjusAnswerPage(driver);
		_byjusAnswerPage.clickOnFindSolutionSearchBox();
		_byjusAnswerPage.sendQuestionInFindSolutionSearchBox("What is the full form of GST");
		String actualResult=_byjusAnswerPage.getTextOfQuestion();
		String expectedResult="What is the full form of GST";
		System.out.println(expectedResult);
		
		if(expectedResult.contains(actualResult))
		{
			
			_byjusAnswerPage.selectQuestion();
		}
		else {
			Assert.fail();
			
		}
		
		_byjusAnswerPage.scrollThePage();
	}
	
	@Test (priority=2)
	public void verifyQuestionPapersFunctionality() throws InterruptedException
	{
		ByjusAnswerPage _byjusAnswerPage = new ByjusAnswerPage(driver);
		_byjusAnswerPage.clickOnQuestionPapersSection();
		Thread.sleep(2000);
		ExamPapersPage _examPapersPage = new ExamPapersPage(driver);
		String expectedUrl="https://byjus.com/question-answer/exams/";
		String actualUrl=driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		Assert.assertEquals(actualUrl,expectedUrl);
		SoftAssert _softAssert = new SoftAssert();
		_examPapersPage.selectGradeFromDropdown();
	//	_softAssert.assertEquals(_examPapersPage.getTextOfGrade(),"Grade X");
		_examPapersPage.selectExamFromDropdown();
		_examPapersPage.selectSubjectFromDropdown();
		_examPapersPage.clickOnQustionPaperYear();
		_softAssert.assertAll();
	}
	
	
	@AfterClass
	public void clearObject()
	{
		_byjusAnswerPage = null;
		_examPapersPage = null;
		
	}
	
	@AfterTest()
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}


}
