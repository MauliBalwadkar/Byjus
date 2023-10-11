package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ByjusTutionCenterNearMe {
	
	
		@FindBy (xpath="//div[@class='youtube-video']")
		private WebElement parentFeedbackVideo;
		
		@FindBy (xpath="//ul[@class='nav navbar-nav navbar-right top-navbar-right']//li[@class='nav-about-us']")
		private WebElement aboutUs;
		
		private JavascriptExecutor _javascriptExecutor;
		
		private WebDriver driver;
		//
		public ByjusTutionCenterNearMe(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			this.driver=driver;
			_javascriptExecutor=(JavascriptExecutor)driver;
		}
		//
		
		public void clickOnParentFeedbackVideo() throws InterruptedException
		{
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			_javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",parentFeedbackVideo);
			
			parentFeedbackVideo.click();
			Thread.sleep(3000);
			//parentFeedbackVideo.click();
			
		}
		
		public void clickONAboutUs()
		{
			aboutUs.click();
		}
		

}
