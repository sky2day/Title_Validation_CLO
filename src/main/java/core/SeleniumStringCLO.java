package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class SeleniumStringCLO{
	
	public static final String sTest_case_id="-c";
	public static final String Test_case_id="--caseid";
	
	public static final String sURL="-u";
	public static final String URL="--url";
	
	public static final String sTitle="-t";
	public static final String TitleExpected="--title";
	
	public static final String sHelp="-h";
	public static final String Help="--help";
	
			
	@Parameter(names={sURL, URL}, description ="Web site URL")
	public static String url="http://www.thomsonreuters.com";

	@Parameter(names={sTitle, TitleExpected}, description ="Expected title of Web Site")
	public static String title_expected="Home | Thomson Reuters";	
	
	@Parameter(names={sTest_case_id, Test_case_id}, description ="Test case ID - > TC-xxx.xx")
	public static String test_case_id="TC-001.01";
	
	@Parameter(names={sHelp, Help}, help=true, hidden=true)
	public static boolean help;
	
public static void main(String [] args) {
	
	if (args.length == 0) {
		System.err.println ("No arguments!");
		System.exit(1);}
	
		new JCommander (new SeleniumStringCLO(), args);
		if (help){
		new JCommander (new SeleniumStringCLO(), args).usage();
		System.exit(0);
		}

	WebDriver driver = new FirefoxDriver();
	
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String title_actual = driver.getTitle();

	if (title_expected.equals(title_actual)) {
		System.out.println();
		System.out.println(">>>>....");
		System.out.println("Test Case ID: \t\t" + test_case_id);
		System.out.println("URL: \t\t\t" + url);
		System.out.println("Title Expected: \t" + title_expected);
		System.out.println("Title Actual: \t\t" + title_actual);
		System.out.println("Test Case Result: \t" + "PASSED");
		System.out.println("....<<<<");
		System.out.println();
	} else {
		System.out.println(">>>>....");
		System.out.println("Test Case ID: \t\t" + test_case_id);
		System.out.println("URL: \t\t\t" + url);
		System.out.println("Title Expected: \t" + title_expected);
		System.out.println("Title Actual: \t\t" + title_actual);
		System.out.println("Test Case Result: \t" + "FAILED");
		System.out.println("....<<<<");
		System.out.println();
	}
	driver.quit();
	
	}
}
