package commonmethod;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import baseclass.BaseClass;
import pageobjects.AttendancePage;

public class CommonMethod extends BaseClass{
	
	public WebDriver driver;
	AttendancePage attendancepage = new AttendancePage(driver);
	
	public void SendAllStudentData(String SheetName, int Rownumber) throws InvalidFormatException, IOException {
		getDataFromExcel(SheetName, Rownumber);
		String FirstName = getDataFromExcel(SheetName,Rownumber).get("FirstName");
		String LastName = getDataFromExcel(SheetName,Rownumber).get("LastName");
		String BatchNumber = getDataFromExcel(SheetName,Rownumber).get("BatchNumber");
		String LogInDateTime = getDataFromExcel(SheetName,Rownumber).get("LogInDateTime");
		String LogOutDateTime = getDataFromExcel(SheetName,Rownumber).get("LogOutDateTime");
		attendancepage.selectattended();
		String ReasonForAbsence = getDataFromExcel(SheetName,Rownumber).get("ReasonForAbsence");
		attendancepage.sendstudentdata(FirstName, LastName, BatchNumber, LogInDateTime, LogOutDateTime, ReasonForAbsence);
		attendancepage.bottomsubmitbtn();
	}
}
