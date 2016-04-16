package core;
import java.util.List;
//import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = ":")

public class Settings {
	
	public static final String sTest_case_id="-c";
	public static final String Test_case_id="--caseid";
	
	public static final String sURL="-u";
	public static final String URL="--url";
	
	public static final String sTitle="-t";
	public static final String TitleExpected="--title";
	
	public static final String sHelp="-h";
	public static final String Help="--help";
	
	public static final String sLIST="-l";
	public static final String LIST="--list";
	
		
	@Parameter(names={sURL, URL}, description ="URL of Web site -> http://.......")
	public static String url="http://www.thomsonreuters.com";

	@Parameter(names={sTitle, TitleExpected}, description ="Expected title of Web Site")
	public static String title_expected="Home | Thomson Reuters";	
	
	@Parameter(names={sTest_case_id, Test_case_id}, description ="Test case ID - > TC-xxx.xx")
	public static String test_case_id="TC-001.01";
	
	@Parameter(names={sHelp, Help}, help=true, hidden=true)
	public static boolean help;
	
	@Parameter(names={sLIST, LIST}, variableArity = true, description ="Pairs of URL & title. Separate Pairs by ':' ")
	public static List<String> list;
}