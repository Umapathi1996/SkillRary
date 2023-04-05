package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUsPage;
import pompages.Homepage;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestinPage;

public class BaseClass {
protected WebDriverUtility web;
protected PropertyFileUtility property;
protected ExcelUtitlity excel;
protected JavaUtililty jUtil;
protected WebDriver driver;
protected Homepage home;
protected SkillraryDemoAppPage demoApp;
protected SeleniumTrainingPage selenium;
protected TestinPage testing;
protected ContactUsPage contact;
//@BeforeSuite
//@BeforeTest

@BeforeClass
public void classConfiguration() {
	web=new WebDriverUtility();
	property = new PropertyFileUtility();
	excel = new ExcelUtitlity();
	jUtil = new JavaUtililty();
	
	property.propertyConFig(IConstantPath.PROPEERTIES_PATH);
	String browser = property.fetchProperty("browser");
	String url = property.fetchProperty("url");
	long time = Long.parseLong(property.fetchProperty("time"));
	driver = web.openApplication(browser, url, time);
}
  @BeforeMethod
  public void methodConfiguration()
  {
	  excel.exceInitialization(IConstantPath.EXCEL_PATH);
	  
	  home = new Homepage(driver);
	  demoApp=new SkillraryDemoAppPage(driver);
	  selenium=new SeleniumTrainingPage(driver);
	  testing=new TestinPage(driver);
	  contact=new ContactUsPage(driver);
	  
	  Assert.assertTrue(home.getLogo().isDisplayed());
  }
  @AfterMethod
  public void methodTearDown() {
	  excel.closeWorkbook();
  }
  @AfterClass
  public void classTearDown() {
	  web.quitBrowser();
  }
  //@AfterTest
  //@AfteSuite
}
