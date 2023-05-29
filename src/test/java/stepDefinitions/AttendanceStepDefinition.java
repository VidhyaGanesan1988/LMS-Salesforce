package stepDefinitions;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import baseclass.BaseClass;
import commonmethod.CommonMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AttendancePage;

public class AttendanceStepDefinition extends BaseClass{
	public WebDriver driver;
	
	AttendancePage attendancepage = new AttendancePage(driver);
	CommonMethod commonmethod = new CommonMethod();
	
	@Given("Student is on LMS Attendance page")
	public void student_is_on_lms_attendance_page() throws InterruptedException {
		logger.info("Student is on LMS Attendance Page");
		}

	@When("Student is on Attendance page")
	public void student_is_on_attendance_page() {
	   logger.info("Student is on Attendance Page");
	}

	@Then("Page logo is displayed")
	public void page_logo_is_displayed() {
       logger.info("Test will fail. Logo is out of scope for this Sprint");
	}

	@Then("Page header text {string} is displayed")
	public void page_header_text_is_displayed(String pageheader) {
		String Pageheader = attendancepage.headertxt();
		if(Pageheader == pageheader)
		{
       Assert.assertEquals(Pageheader,pageheader);
       logger.info("Page header text is displayed");
		}
		else {
			logger.info("Page header text is not displayed");
		}
	}

	@Then("Page sub header text {string} is displayed")
	public void page_sub_header_text_is_displayed(String pagesubheader) {
		String Pagesubheader = attendancepage.subheadertxt();
		if(Pagesubheader == pagesubheader)
		{
       Assert.assertEquals(Pagesubheader, pagesubheader);
       logger.info("Page subheader text is displayed");
		}
		else {
			logger.info("Page sub header text is not displayed");
		}
	}

	@Then("Text fields labels like First Name, Last Name, Batch Name, Log In Date & Time, Log Out Date & Time, Attendance Status and Reason for Absence is displayed")
	public void text_fields_labels_like_first_name_last_name_batch_name_log_in_date_time_log_out_date_time_attendance_status_and_reason_for_absence_is_displayed() {
      
		if (attendancepage.txtheaders())
       {
		   attendancepage.txtheaders();
    	   logger.info("All text fields displayed");
       }
		else {
			logger.info("All text fields not displayed");
		}
	}   

	@Then("Submit button is displayed at the top of the form")
	public void submit_button_is_displayed_at_the_top_of_the_form() {
		if (attendancepage.topsubmitbtntxt())
	       {
			   attendancepage.topsubmitbtntxt();
	    	   logger.info("Submit button is displayed at the top of the form");
	       }
			else {
				logger.info("Submit button is not displayed at the top of the form");
			}
	}

	@Then("Submit button is displayed at the bottom of the form")
	public void submit_button_is_displayed_at_the_bottom_of_the_form() {
		if (attendancepage.bottomsubmitbtntxt())
	       {
			   attendancepage.bottomsubmitbtntxt();
	    	   logger.info("Submit button is displayed at the bottom of the form");
	       }
			else {
				logger.info("Submit button is not displayed at the bottom of the form");
			}
	}

	@When("Student submits attendance form with all valid data from {string} and {int}")
	public void student_submits_attendance_form_with_all_valid_data_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student submits attendance form with all valid data");
	}

	@Then("Attendance form is successfully submitted with the success message {string}")
	public void attendance_form_is_successfully_submitted_with_the_success_message(String successmsg) {
		String SuccessMsg = attendancepage.successmsg();
		if (SuccessMsg == successmsg)
		{
			Assert.assertEquals(SuccessMsg,successmsg);
			logger.info("Attendance form is successfully submitted with the success message");
		}
		else {
			logger.info("Attendance form not submitted");
		}
	}

	@When("Student submits the attendance form without entering data")
	public void student_submits_the_attendance_form_without_entering_data() {
		attendancepage.bottomsubmitbtn();
		logger.info("Student submits the attendance form without entering data");
	}

	@Then("Error message {string} is displayed")
	public void error_message_is_displayed(String errormsg) {
		String ErrorMsg = attendancepage.errormsg();
		if(ErrorMsg == errormsg)
		{
			Assert.assertEquals(ErrorMsg, errormsg);
			logger.info("Error message is dispplayed");
		}
		else {
			logger.info("Error message is not dispplayed");
		}
	}

	@When("Student enters only First Name from {string} and {int} and clicks submit button")
	public void student_enters_only_first_name_from_and_and_clicks_submit_button(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String FirstName = getDataFromExcel(SheetName,Rownumber).get("FirstName");
		attendancepage.sendfirstname(FirstName);
		attendancepage.bottomsubmitbtn();
		logger.info("Student enters only First Name and clicks submit button");
	}

	@When("Student enters only Last Name from {string} and {int} and clicks submit button")
	public void student_enters_only_last_name_from_and_and_clicks_submit_button(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String LastName = getDataFromExcel(SheetName,Rownumber).get("LastName");
		attendancepage.sendlastname(LastName);
		attendancepage.bottomsubmitbtn();
		logger.info("Student enters only Last Name and clicks submit button");
	}

	@When("Student enters only Batch Number from {string} and {int} and clicks submit button")
	public void student_enters_only_batch_number_from_and_and_clicks_submit_button(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String BatchNumber = getDataFromExcel(SheetName,Rownumber).get("BatchNumber");
		attendancepage.sendbatchnumber(BatchNumber);
		attendancepage.bottomsubmitbtn();
		logger.info("Student enters only Batch Number and clicks submit button");
	}

	@When("Student enters only Log In Date & Time from {string} and {int} and clicks submit button")
	public void student_enters_only_log_in_date_time_from_and_and_clicks_submit_button(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String LogInDateTime = getDataFromExcel(SheetName,Rownumber).get("LogInDateTime");
		attendancepage.sendlogindatetime(LogInDateTime);
		attendancepage.bottomsubmitbtn();
		logger.info("Student enters only Log In Date & Time and clicks submit button");
	}

	@When("Student enters only Log Out Date & Time from {string} and {int} and clicks submit button")
	public void student_enters_only_log_out_date_time_from_and_and_clicks_submit_button(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String LogOutDateTime = getDataFromExcel(SheetName,Rownumber).get("LogOutDateTime");
		attendancepage.sendlogindatetime(LogOutDateTime);
		attendancepage.bottomsubmitbtn();
		logger.info("Student enters only Log In Date & Time and clicks submit button");
	}

	@When("Student selects only Attendance Status-None and clicks submit button")
	public void student_selects_only_attendance_status_none_and_clicks_submit_button() {
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-None and clicks submit button");
	}

	@When("Student selects only Attendance Status-Attended and clicks submit button")
	public void student_selects_only_attendance_status_attended_and_clicks_submit_button() {
		attendancepage.selectattended();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Attended and clicks submit button");
	}

	@When("Student selects only Attendance Status-Absent and clicks submit button")
	public void student_selects_only_attendance_status_absent_and_clicks_submit_button() {
		attendancepage.selectabsent();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Absent and clicks submit button");
	}

	@When("Student selects only Attendance Status-Late Log In and clicks submit button")
	public void student_selects_only_attendance_status_late_log_in_and_clicks_submit_button() {
		attendancepage.selectlatelogin();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Late Log In and clicks submit button");
	}

	@When("Student selects only Attendance Status-Late Log Out and clicks submit button")
	public void student_selects_only_attendance_status_late_log_out_and_clicks_submit_button() {
		attendancepage.selectearlylogout();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Late Log Out and clicks submit button");
	}

	@When("Student selects only Attendance Status-Approved Absence\\(To be Used Only when Tim Approved) and clicks submit button")
	public void student_selects_only_attendance_status_approved_absence_to_be_used_only_when_tim_approved_and_clicks_submit_button() {
		attendancepage.selectatapprovedabsence();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Approved Absence(To be Used Only when Tim Approved) and clicks submit button");
	}

	@When("Student selects only Attendance Status-Approved Late Log in\\(To be Used Only when Tim Approved) and clicks submit button")
	public void student_selects_only_attendance_status_approved_late_log_in_to_be_used_only_when_tim_approved_and_clicks_submit_button() {
		attendancepage.selectatapprovedlatelogin();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Approved Late Log in (To be Used Only when Tim Approved) and clicks submit button");
	}

	@When("Student selects only Attendance Status-Approved Early Log out\\(To be Used Only when Tim Approved) and clicks submit button")
	public void student_selects_only_attendance_status_approved_late_log_out_to_be_used_only_when_tim_approved_and_clicks_submit_button() {
		attendancepage.selectatapprovedearlylogout();
		attendancepage.bottomsubmitbtn();
		logger.info("Student selects only Attendance Status-Approved Early Log out(To be Used Only when Tim Approved) and clicks submit button");
	}

	@When("Student enters only Reason of Absence from {string} and {int} and clicks submit button")
	public void student_enters_only_reason_of_absence_from_and_and_clicks_submit_button(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String ReasonForAbsence = getDataFromExcel(SheetName,Rownumber).get("ReasonForAbsence");
		attendancepage.sendreasonforabsence(ReasonForAbsence);
		attendancepage.bottomsubmitbtn();
		logger.info("Student enters only Reason of Absence and clicks submit button");
	}
	
	@When("Student enters numbers in First Name text field & valid data in the other fields from {string} and {int} and clicks submit")
	public void student_enters_numbers_in_first_name_text_field_valid_data_in_the_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters numbers in First Name text field & valid data in the other fields and clicks submit");
	}

	@When("Student enters special characters in First Name text field & valid data in the other fields from {string} and {int} and clicks submit")
	public void student_enters_special_characters_in_first_name_text_field_valid_data_in_the_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters special characters in First Name text field & valid data in the other fields and clicks submit");
	}

	@When("Student enters numbers in Last Name text field & valid data in the other fields from {string} and {int} and clicks submit")
	public void student_enters_numbers_in_last_name_text_field_valid_data_in_the_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters numbers in Last Name text field & valid data in the other fields and clicks submit");
	}

	@When("Student enters special characters in Last Name text field & valid data in the other fields from {string} and {int} and clicks submit")
	public void student_enters_special_characters_in_last_name_text_field_valid_data_in_the_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters special characters in Last Name text field & valid data in the other fields and clicks submit");
	}

	@When("Student enters special characters in Batch Number field & valid data in the other fields from {string} and {int} and clicks submit")
	public void student_enters_special_characters_in_batch_number_field_valid_data_in_the_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters special characters in BatchNumber field & valid data in the other fields and clicks submit");
	}

	@When("Student enters text in Log In Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_text_in_log_in_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters text in Log In Date & Time & valid data in the other fields and clicks submit");
	}

	@When("Student enters special characters in Log In Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_special_characters_in_log_in_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
		logger.info("Student enters special character in Log In Date & Time & valid data in the other fields and clicks submit");
	}

	@When("Student enters date in non-date format in Log In Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_date_in_non_date_format_in_log_in_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
	}

	@When("Student enters future date in Log In Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_future_date_in_log_in_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
	}

	@When("Student enters text in Log Out Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_text_in_log_out_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
	}

	@When("Student enters special characters in Log Out Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_special_characters_in_log_out_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);
	}

	@When("Student enters date in non-date format in Log Out Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_date_in_non_date_format_in_log_out_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);	}

	@When("Student enters future date in Log Out Date & Time & valid data in other fields from {string} and {int} and clicks submit")
	public void student_enters_future_date_in_log_out_date_time_valid_data_in_other_fields_from_and_and_clicks_submit(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		commonmethod.SendAllStudentData(SheetName,Rownumber);	}

}
