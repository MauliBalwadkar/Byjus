package TestPacakage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import module.AdmissionPopUp;
import pages.AboutUs;
import pages.ByjusTutionCenterNearMe;
import pages.HomePage;
import pages.TutionCenterLocation;

public class verifyByjusTutionCenterLocation {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://byjus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		
		HomePage _homepage=new  HomePage(driver);
		 
		 _homepage.HoverOnBtcOption();
		 _homepage.selectOptionFromDropDownOfBtc();
		 _homepage.selectOptionFromTutionInState();
		 _homepage.selectTutionInCity();
		
		 AdmissionPopUp _admissionPopUp=new  AdmissionPopUp(driver);
		 _admissionPopUp.clickOnCrossButtonOfAdmissionPopUp();
		 
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

}
