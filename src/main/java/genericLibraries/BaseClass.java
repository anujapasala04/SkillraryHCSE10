package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomClass.ContactUsPage;
import pomClass.SeleniumTrainingPage;
import pomClass.SkillraryDemoAppPage;
import pomClass.SkillraryHomePage;
import pomClass.TestingPageInSkillraryApp;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPageInSkillraryApp testing;
	protected ContactUsPage contact;
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfig() {
		
		property=new PropertiesUtility();
		excel=new ExcelUtility(); 
		jutil=new JavaUtility();
		web=new WebDriverUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		}
	@BeforeMethod
	public void methodConfig(){
		driver=web.launchBrowser(property.readDataFromProperties("browser"));
		web.maximizeBrowser();
		web.navigateTOApp(property.readDataFromProperties("url"));
		web.waitUntilElementFound(Long.parseLong(property.readDataFromProperties("time")));
		
		home=new SkillraryHomePage(driver);
		demoApp=new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPageInSkillraryApp(driver);
		contact=new ContactUsPage(driver);
	}
	@AfterMethod
	public void MethodTearDown() {
		web.quitallWindows();
	}
	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}
	
	//@AfterTest
	//@AfterSuite
}
	
	
	

	
	


