@tag
Feature: Attendance feature

  @DisplayFeatures
  Scenario: Verify attendance page logo
    Given Student is on LMS Attendance page
    When Student is on Attendance page
    Then Page logo is displayed
  
  @DisplayFeatures  
  Scenario: Verify attendance page header
    Given Student is on LMS Attendance page
    When Student is on Attendance page
    Then Page header text "NUMPY NINJA STUDENT ATTENDANCE TRACKER" is displayed  
  
  @DisplayFeatures  
  Scenario: Verify attendance page sub header
    Given Student is on LMS Attendance page
    When Student is on Attendance page
    Then Page sub header text "Fill the Below details to update the Attendance" is displayed
   
  @DisplayFeatures  
  Scenario: Verify text field labels displayed
    Given Student is on LMS Attendance page
    When Student is on Attendance page
    Then Text fields labels like First Name, Last Name, Batch Name, Log In Date & Time, Log Out Date & Time, Attendance Status and Reason for Absence is displayed     
   
  @DisplayFeatures  
  Scenario: Verify submit button displayed
    Given Student is on LMS Attendance page
    When Student is on Attendance page
    Then Submit button is displayed at the top of the form
    
   @DisplayFeatures 
   Scenario: Verify submit button displayed
    Given Student is on LMS Attendance page
    When Student is on Attendance page
    Then Submit button is displayed at the bottom of the form  
      
  Scenario Outline: Validate top submit button
    Given Student is on LMS Attendance page
    When Student submits attendance form with all valid data from "<SheetName>" and <Rownumber>
    Then Attendance form is successfully submitted with the success message "your attendance has been successfully Updated!!!!"
    
    Examples: 
      | SheetName    | Rownumber |
      | studentdata  |     0     |
      
  Scenario Outline: Validate bottom submit button
    Given Student is on LMS Attendance page
    When Student submits attendance form with all valid data from "<SheetName>" and <Rownumber>
    Then Attendance form is successfully submitted with the success message "your attendance has been successfully Updated!!!!"
    
    Examples: 
      | SheetName     | Rownumber |
      | studentdata   |     1     |
          
  Scenario Outline: Validate attendance form submission with all valid data
    Given Student is on LMS Attendance page
    When Student submits attendance form with all valid data from "<SheetName>" and <Rownumber>
    Then Attendance form is successfully submitted with the success message "your attendance has been successfully Updated!!!!"
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     2     |
      
  Scenario: Empty form submission
    Given Student is on LMS Attendance page
    When Student submits the attendance form without entering data
    Then Error message "Please enter some valid input" is displayed    

  Scenario Outline: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student enters only First Name from "<SheetName>" and <Rownumber> and clicks submit button 
    Then Error message "Please enter some valid input" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     3     |
    
  Scenario Outline: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student enters only Last Name from "<SheetName>" and <Rownumber> and clicks submit button 
    Then Error message "Please enter some valid input" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     4     |  
      
  Scenario Outline: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student enters only Batch Number from "<SheetName>" and <Rownumber> and clicks submit button 
    Then Error message "Please enter some valid input" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     5     |    
      
  Scenario Outline: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student enters only Log In Date & Time from "<SheetName>" and <Rownumber> and clicks submit button 
    Then Error message "Please enter some valid input" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     6     |   
      
  Scenario Outline: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student enters only Log Out Date & Time from "<SheetName>" and <Rownumber> and clicks submit button 
    Then Error message "Please enter some valid input" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     7     |     
      
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-None and clicks submit button
    Then Error message "Please select a choice" is displayed
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Attended and clicks submit button
    Then Error message "Please select a choice" is displayed      
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Absent and clicks submit button
    Then Error message "Please select a choice" is displayed  
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Late Log In and clicks submit button
    Then Error message "Please select a choice" is displayed  
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Late Log Out and clicks submit button
    Then Error message "Please select a choice" is displayed  
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Approved Absence(To be Used Only when Tim Approved) and clicks submit button
    Then Error message "Please select a choice" is displayed
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Approved Late Log in(To be Used Only when Tim Approved) and clicks submit button
    Then Error message "Please select a choice" is displayed
    
  Scenario: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student selects only Attendance Status-Approved Early Log out(To be Used Only when Tim Approved) and clicks submit button
    Then Error message "Please select a choice" is displayed      

  Scenario Outline: Validate attendance form submission with missing data
    Given Student is on LMS Attendance page
    When Student enters only Reason of Absence from "<SheetName>" and <Rownumber> and clicks submit button
    Then Error message "Please enter some valid input" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     8     |
    
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters numbers in First Name text field & valid data in the other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Name Should be Only 50 Char n Contains Only Alphabets!!" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     9     |  
    
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters special characters in First Name text field & valid data in the other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Name Should be Only 50 Char n Contains Only Alphabets!!" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     10     |  
    
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters numbers in Last Name text field & valid data in the other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Last Name Should be Only 50 CHAR & Contains Only Alphabets!!" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     11    |  
    
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters special characters in Last Name text field & valid data in the other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Last Name Should be Only 50 CHAR & Contains Only Alphabets!!" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     12    |    
   
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters special characters in Batch Number field & valid data in the other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Batch Number Should be Only 50 CHAR & Contains Only Alphanuremic input!!" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     13    |  
    
  @AttendanceLoginDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters text in Log In Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     14    |  
    
  @AttendanceLoginDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters special characters in Log In Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     15    |  
    
  @AttendanceLoginDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters date in non-date format in Log In Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     16    |  
      
  @AttendanceLoginDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters future date in Log In Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     17    |    
    
  @AttendanceLogoutDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters text in Log Out Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     18    |  
    
  @AttendanceLogoutDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters special characters in Log Out Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     19    |  
    
  @AttendanceLogoutDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters date in non-date format in Log Out Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     20    |  
      
  @AttendanceLogoutDate
  Scenario Outline: Validate text fields with invalid data
    Given Student is on LMS Attendance page
    When Student enters future date in Log Out Date & Time & valid data in other fields from "<SheetName>" and <Rownumber> and clicks submit 
    Then Error message "Invalid Date and Time" is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      | studentdata      |     21    |  
    
    
    
    
    
    
    
    
    
    
    
    
    