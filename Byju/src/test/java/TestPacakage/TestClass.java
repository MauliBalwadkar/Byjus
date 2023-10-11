package TestPacakage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import module.AdmissionPopUp;
import pages.ByjusTutionCenterNearMe;
import pages.HomePage;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://byjus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		
		
		
		 HomePage _homepage=new  HomePage(driver);
		 
		 _homepage.HoverOnBtcOption();
		 _homepage.selectOptionFromDropDownOfBtc();
		 _homepage.selectOptionFromTutionInState();
		 _homepage.selectTutionInCity();
		
		 AdmissionPopUp _admissionPopUp=new  AdmissionPopUp(driver);
		 _admissionPopUp.clickOnCrossButtonOfAdmissionPopUp();
		 
		 ByjusTutionCenterNearMe _byjusTutionCenterNearMe=new ByjusTutionCenterNearMe(driver);
		 _byjusTutionCenterNearMe.clickOnParentFeedbackVideo();
				 
		
		 
		 
	}

}
