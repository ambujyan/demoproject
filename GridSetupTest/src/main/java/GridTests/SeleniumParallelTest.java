package GridTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumParallelTest {
	
	WebDriver driver;
	String nodeUrl;
		
	@Parameters({"portNo","appUrl"})
	@BeforeMethod
	public void setUp(String portNo, String appUrl) throws MalformedURLException {
		
		if(portNo.equalsIgnoreCase("4445")) {
			
			nodeUrl = "http://172.20.1.18:4445/wd/hub";
			System.out.println("Chrome Browser Test Environment Created");
			
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL(nodeUrl), cap);
			driver.manage().window().maximize();
			driver.navigate().to(appUrl);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			
		}
		else if(portNo.equalsIgnoreCase("4446")) {
			
			nodeUrl = "http://172.20.1.18:4446/wd/hub";
			System.out.println("Firefox Browser Test Environment Created");
			
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setVersion("38.0.5");
			cap.setCapability("marionette", false);
			cap.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL(nodeUrl), cap);
			driver.manage().window().maximize();
			driver.navigate().to(appUrl);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		else
		{
			System.err.println("Provide correct port no");
		}
		
	}
	
	@Test
	public void test() {
		System.out.println("Page Title is : "+ driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}

}
