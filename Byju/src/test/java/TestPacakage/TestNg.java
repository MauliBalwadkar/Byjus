package TestPacakage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;
import module.AdmissionPopUp;
import pages.AboutUs;
import pages.ByjusTutionCenterNearMe;
import pages.HomePage;
import pages.TutionCenterLocation;


public class TestNg extends BrowserLaunch {
	
	private WebDriver driver;
	private HomePage _homepage;
	private AdmissionPopUp _admissionPopUp;
	private  ByjusTutionCenterNearMe _byjusTutionCenterNearMe;
	private  AboutUs _aboutUs;
	private  TutionCenterLocation _tutionCenterLocation;
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@BeforeClass
	public void createPOMObject()
	{
		_homepage=new  HomePage(driver);
		_admissionPopUp=new  AdmissionPopUp(driver);
		_byjusTutionCenterNearMe=new ByjusTutionCenterNearMe(driver);
		_aboutUs = new AboutUs(driver);
		_tutionCenterLocation = new TutionCenterLocation(driver);
	}

	
	@BeforeMethod
	public void verifyCoarseInformation()
	{
		driver.get("https://byjus.com/");
		
		HomePage _homepage=new  HomePage(driver);
		String actualResult= "https://byjus.com/";
		String expectedResult =driver.getCurrentUrl();
		
		Assert.assertEquals(actualResult, expectedResult);
		
		  _homepage.HoverOnBtcOption();
		 _homepage.selectOptionFromDropDownOfBtc();
		 String actualResult1="Tuition in West Zone";
		 String expectedResult1=_homepage.getTextListOfBtcZone();
		 SoftAssert softAssert = new SoftAssert();
		 softAssert.assertEquals(actualResult1,expectedResult1);
		// Assert.assertTrue(actualResult.equals(expectedResult1));
		 _homepage.selectOptionFromTutionInState();
		 _homepage.selectTutionInCity();
		 
		 
		
	}
	
	@Test (priority = 1)
	public void verifyParentFeedbackVideoFunctionality() throws InterruptedException
	{
		AdmissionPopUp _admissionPopUp=new  AdmissionPopUp(driver);
		_admissionPopUp.clickOnCrossButtonOfAdmissionPopUp();
		 ByjusTutionCenterNearMe _byjusTutionCenterNearMe=new ByjusTutionCenterNearMe(driver);
		 _byjusTutionCenterNearMe.clickOnParentFeedbackVideo();
	}
	
	@Test (priority =2)
	public void verifyTutionCenterLocationFunctionality() throws InterruptedException
	{
		
		ByjusTutionCenterNearMe _byjusTutionCenterNearMe=new ByjusTutionCenterNearMe(driver);
		 _byjusTutionCenterNearMe.clickONAboutUs();
		 
		  AboutUs _aboutUs = new AboutUs(driver);
		 _aboutUs.selectStateOption();
		 _aboutUs.selectCityOption();
		 Thread.sleep(2000);
		 _aboutUs.clickOnGoToCenterButton();
		 
		 TutionCenterLocation _tutionCenterLocation = new TutionCenterLocation(driver);
		 _tutionCenterLocation.clickOnGetDirection();
	}
	
	
	
	@AfterClass
	public void clearObject()
	{
		_homepage = null;
		_admissionPopUp = null;
		_byjusTutionCenterNearMe = null;
		_aboutUs = null;
		_tutionCenterLocation = null;
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
	


}
