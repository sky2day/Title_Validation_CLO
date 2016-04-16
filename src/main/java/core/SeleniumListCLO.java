package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.beust.jcommander.JCommander;

public class SeleniumListCLO{
public static void main(String [] args) 
	{
		new JCommander (new Settings(), args);
		if (Settings.help){
		new JCommander (new Settings(), args).usage();
		System.exit(0);
		}

	WebDriver driver = new FirefoxDriver();
	
	for(int i=0;i<Settings.list.size();i++)
	{
		String test_case_id = "TC-003.0"+(i+1);
		String param[] = Settings.list.get(i).split("\\:");
		String url = param[0];
		String title_expected = param[1];
		
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
}