package constants;
import java.text.SimpleDateFormat;
import java.util.Date;
public class FileConstants {
	static String dateStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	public static final String ROOT_PATH=System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE_PATH=ROOT_PATH+"\\src\\main\\java\\testdata\\logintestdata.properties";
	public static final String MYPROFILE_TEST_DATA_FILE_PATH=ROOT_PATH+"\\src\\main\\java\\testdata\\myprofiletestdata.properties";
	public static final String MYSETTINGS_TEST_DATA_FILE_PATH=ROOT_PATH+"\\src\\main\\java\\testdata\\mysettingstestdata.properties";
	public static final String ACCOUNT_TEST_DATA_FILE_PATH=ROOT_PATH+"\\src\\main\\java\\testdata\\accounttestdata.properties";
	public static final String OPPORTUNITIES_TEST_DATA_FILE_PATH=ROOT_PATH+"\\src\\main\\java\\testdata\\opportunitiestestdata.properties";
	public static final String LEADS_TEST_DATA_FILE_PATH=ROOT_PATH+"\\src\\main\\java\\testdata\\leadstestdata.properties";
	public static final String TEST_DATA_FILE_TO_UPLOAD=ROOT_PATH+"\\FileUpload";
	public static final String PHOTO_UPLOAD_PATH=ROOT_PATH+"\\image_2.jpg";
	public static final String REPORT_PATH = ROOT_PATH+"\\src\\main\\resources\\reports\\reports"+dateStamp+".html";
	public static final String VIEW_NAME = "abcd"+dateStamp;
	public static final String REPORT_NAME = "REPORT"+dateStamp;
}
