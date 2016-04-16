package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class HtmlUnitStringCLO {
	public static void main(String[] args) {

		WebDriver driver = new HtmlUnitDriver();   // Version 1.2 :: HtmlUnit

		//String text_case_id = "TC-001.00";
		//String url = "http://www.thomsonreuters.com";
		//String title_expected = "thomsonreuters.com";
		
		driver.get(Settings.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (Settings.title_expected.equals(title_actual)) {
			System.out.println();
			System.out.println(">>>>....");
			System.out.println("Test Case ID: \t\t" + Settings.test_case_id);
			System.out.println("URL: \t\t\t" + Settings.url);
			System.out.println("Title Expected: \t" + Settings.title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
			System.out.println("....<<<<");
			System.out.println();
		} else {
			System.out.println(">>>>....");
			System.out.println("Test Case ID: \t\t" + Settings.test_case_id);
			System.out.println("URL: \t\t\t" + Settings.url);
			System.out.println("Title Expected: \t" + Settings.title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
			System.out.println("....<<<<");
			System.out.println();
		}
		driver.quit();
		}
		}
