package licenseCompanyadmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InternalTC {
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static XSSFSheet ReadExcel() throws IOException
	{
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicenseCompanyadmin.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Logging In - Performer (Both)");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"License");		//Method of Login class to login user.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	  @Test(priority = 2)
		void AllFilter() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.Allfilter(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	  /* @Test(priority =10 )
		void LicenseExpiredOnInternal() throws InterruptedException
		{
			test = extent.startTest("License Expired On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.LicenseExpiredOnInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 3)
		void ActiveInternalLicense() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ActiveInternalLicense(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}

	  @Test(priority = 4)
		void ExpiringInternalLicense() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ExpiringInternalLicense(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 5)
			void ExpiredInternalLicense() throws InterruptedException
			{
				test = extent.startTest("All Filter Working Verification");
				test.log(LogStatus.INFO, "Test Initiated");
				
				StatutoryMethod.ExpiredInternalLicense(driver, test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 6)
		void AppliedInternalLicense() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.AppliedInternalLicense(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 7)
			void PendingForReviewInternalInternalLicense() throws InterruptedException
			{
				test = extent.startTest("All Filter Working Verification");
				test.log(LogStatus.INFO, "Test Initiated");
				
				StatutoryMethod.pendingforreviewInternalLicense(driver, test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 8)
		void RejectedInternalInternalLicense() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.RejectedInternalLicense(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 9)
		void TerminateInternalInternalLicense() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.TerminateInternalLicense(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}*/
	  @Test(priority = 11)
	  void BystatusActiveInternalgraph() throws InterruptedException
		{
			test = extent.startTest("License Active On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusActiveInternalgraph(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 12)
	  void BystatusTerminateInternalgraph() throws InterruptedException
		{
			test = extent.startTest("License Active On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusTerminateInternalgraph(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 13)
	  void BystatusExpiredappliedbutnotrenewedInternalgraph() throws InterruptedException
		{
			test = extent.startTest("License Active On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpiredappliedbutnotrenewedInternalgraph(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 14)
	  void BystatusExpiredInternal() throws InterruptedException
		{
			test = extent.startTest("License Active On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpiredInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 15)
	  void BystatusExpringInternalgraph() throws InterruptedException
		{
			test = extent.startTest("License Expiring On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpringInternalgraph(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 16)
		void  ByLicensetypeExpiredInternal() throws InterruptedException
		{
			test = extent.startTest("License Expired On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeExpiredInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 17)
		void ByLicensetypeExpiringInternal() throws InterruptedException
		{
			test = extent.startTest("License Expiring On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeExpiringInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 18)
		void ByLicensetypeAppliedInternal() throws InterruptedException
		{
			test = extent.startTest("License Applied On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeAppliedInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 19)
		void BylicnesetypeActiveInternal() throws InterruptedException
		{
			test = extent.startTest("License Active On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeActiveInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 20)
		void BylicnesetypeTerminateInternal() throws InterruptedException
		{
			test = extent.startTest("License Terminate On Working Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeTerminateInternal(driver, test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  

	  
}
