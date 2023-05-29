package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AttendancePage {
	
	public WebDriver driver;
	public AttendancePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	By header = By.xpath("//strong[contains(text(),'NUMPY NINJA STUDENT ATTENDANCE TRACKER')]");
	By subheader = By.xpath("//p[contains(text(),'Fill the Below details to update the Attendance')]");
	By firstnametxt = By.xpath("//label[contains(text(),'First Name')]");
	By lastnametxt = By.xpath("//label[contains(text(),'Last Name')]");
	By batchnumbertxt = By.xpath("//label[contains(text(),'Batch Number')]");
	By logintxt = By.xpath("//label[contains(text(),'Log In Date & Time')]");
	By loginouttxt = By.xpath("//label[contains(text(),'Log Out Date & Time')]");
	By attendancestatustxt = By.xpath("//label[contains(text(),'Attendance Status')]");
	By reasonforabsencetxt = By.xpath("//label[contains(text(),'Reason For Absence')]");
	By topsubmitbtn = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:pbb:next']");
	By bottomsubmitbtn = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:pbb:bottom:next']");
	By firstnametxtfield = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:d:First_Name.input']");
	By lastnametxtfield = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:d:LastName.input']");
	By batchnumbertxtfield = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:d:Batch_Number.input']");
	By logintxtfield = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:d:Log_In_Date_n_Time.input']");
	By logouttxtfield = By.xpath("//input[@id='j_id0:j_id1:i:f:pb:d:Log_Out_Date_n_Time.input']");
	By attendancestatusdrpdown = By.xpath("//select[@id='j_id0:j_id1:i:f:pb:d:Attendance_Status.input']");
	By reasonforabsencetxtfield = By.xpath("//textarea[@id='j_id0:j_id1:i:f:pb:d:Reason_For_Absence.input']");
	By batchnumberinfo = By.xpath("//img[@title='Help']");
	By logindatepicker = By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[12]/td[2]/div[1]/span[1]/span[1]/a[1]");
	By logoutdatepicker = By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[15]/td[2]/div[1]/span[1]/span[1]/a[1]");
	By successmsg = By.xpath("//*[contains(text(),'your  attendance has been successfully Updated!!!!')]");
	By errormsg = By.xpath("//p[@class='errorLine'][contains(text(),'Please enter some valid input')]");
	
	public String headertxt() {
		return driver.findElement(header).getText();
	}
	
	public String subheadertxt() {
		return driver.findElement(subheader).getText();
	}
	
	public boolean txtheaders() {
		 driver.findElement(firstnametxt).isDisplayed();
		 driver.findElement(lastnametxt).isDisplayed();
		 driver.findElement(batchnumbertxt).isDisplayed();
		 driver.findElement(logintxt).isDisplayed();
		 driver.findElement(loginouttxt).isDisplayed();
		 driver.findElement(attendancestatustxt).isDisplayed();
		 driver.findElement(reasonforabsencetxt).isDisplayed();
		 return true;
	}
	
	public boolean topsubmitbtntxt() {
		return driver.findElement(topsubmitbtn).isDisplayed();
	}	
	
	public void topsubmitbtn() {
		 driver.findElement(topsubmitbtn).click();
	}	
	
	public boolean bottomsubmitbtntxt() {
		return driver.findElement(bottomsubmitbtn).isDisplayed();
	}	
	
	public void bottomsubmitbtn() {
		 driver.findElement(bottomsubmitbtn).click();
	}	

	public void sendstudentdata(String FirstName, String LastName, String BatchNumber, String LogInDateTime, String LogOutDateTime, String ReasonForAbsence ) {
		 driver.findElement(firstnametxtfield).sendKeys(FirstName);
		 driver.findElement(lastnametxtfield).sendKeys(LastName);
		 driver.findElement(batchnumbertxtfield).sendKeys(BatchNumber);
		 driver.findElement(logintxtfield).sendKeys(LogInDateTime);
		 driver.findElement(logouttxtfield).sendKeys(LogOutDateTime);
		 driver.findElement(reasonforabsencetxtfield).sendKeys(ReasonForAbsence);	 
	}
	
	public void sendfirstname (String FirstName) {
		driver.findElement(firstnametxtfield).sendKeys(FirstName);
	}
	
	public void sendlastname (String LastName) {
		driver.findElement(lastnametxtfield).sendKeys(LastName);
	}
	
	public void sendbatchnumber (String BatchNumber) {
		driver.findElement(batchnumbertxtfield).sendKeys(BatchNumber);
	}
	
	public void sendlogindatetime (String LogInDateTime) {
		driver.findElement(logintxtfield).sendKeys(LogInDateTime);
	}
	
	public void sendlogoutdatetime (String LogOutDateTime) {
		driver.findElement(logouttxtfield).sendKeys(LogOutDateTime);
	}
	
	public void sendreasonforabsence (String ReasonForAbsence) {
		driver.findElement(reasonforabsencetxtfield).sendKeys(ReasonForAbsence);
	}
		
		Select drpstatus = new Select(driver.findElement(attendancestatusdrpdown));
		
		public void selectattended() {
		drpstatus.selectByVisibleText("Attended");
	}
		public void selectabsent() {
			drpstatus.selectByVisibleText("Absent");
		}
		public void selectlatelogin() {
			drpstatus.selectByVisibleText("Late Log In");
		}
		public void selectearlylogout() {
			drpstatus.selectByVisibleText("Early Log Out");
		}
		public void selectatapprovedabsence() {
			drpstatus.selectByVisibleText("Approved Absence(To be Used Only when Tim Approved");
		}
		public void selectatapprovedlatelogin() {
			drpstatus.selectByVisibleText("Approved Late Log in (To be Used Only when Tim Approved");
		}
		public void selectatapprovedearlylogout() {
			drpstatus.selectByVisibleText("Approved Early Log out(To be Used Only when Tim Approved");
		}
		
		public String successmsg() {
			return driver.findElement(successmsg).getText();
		}
		
		public String errormsg() {
			return driver.findElement(errormsg).getText();
		}
}
