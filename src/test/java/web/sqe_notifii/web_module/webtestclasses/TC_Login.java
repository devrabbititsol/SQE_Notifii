package web.sqe_notifii.web_module.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import web.sqe_notifii.web_module.webpageclasses.Login_New;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC_Login extends BaseClass {
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	private String browserName = "chrome";
	public boolean isElementDispalyed = false;


	public TC_Login() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC_Login.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc_login.properties");
	}

	@BeforeTest
	@Parameters("browser")
	public void browserName(String browser) throws Exception {
		browserName = browser;
	}

	
	public void setUP() throws Exception {
		driver = launchBrowser(browserName, configFileObj);
	}

	public void Login_NewTest(int i) throws Exception {

	 try{
		int datasetScreencount = 1;
		Login_New objLogin_New = PageFactory.initElements(driver, Login_New.class);
		testLogHeader("Verify Login_New page");
		objLogin_New.fillinputUsername_473887(configFileObj.getProperty("Username"+ i + datasetScreencount));
		printSuccessLogAndReport(logger,  "Entered Username : " + configFileObj.getProperty("Username"+ i + datasetScreencount));
		objLogin_New.fillinputPassword_473901(configFileObj.getProperty("Password"+ i + datasetScreencount));
		printSuccessLogAndReport(logger,  "Entered Password : " + configFileObj.getProperty("Password"+ i + datasetScreencount));
		objLogin_New.clkbuttonLogIn_473924();
		printInfoLogAndReport(logger, "Clicked on LogInButton");
		
	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport( logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;			
			setUP();			
			setTestcaseName(browserName,"TC_Login - " + configFileObj.getProperty("dataset" + (datasets)));
			Login_NewTest(datasets);
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		driver.quit();
	}
}