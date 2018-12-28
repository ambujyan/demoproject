package GridTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeGridTest {

	public static void main(String[] args) throws MalformedURLException {
		
		//Define Desired Capability
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		//Define Chrome Options
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		//Launch Chrome Browser on Node
		String hubUrl = "http://172.20.1.18:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);
				
		driver.get("http://www.freecrm.com");
		System.out.println("Chrome Title : "+ driver.getTitle());
		
			

	}

}
