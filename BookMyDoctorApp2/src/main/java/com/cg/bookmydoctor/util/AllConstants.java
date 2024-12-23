package com.cg.bookmydoctor.util;

public class AllConstants {
	//public static final String USERNAME_PATTERN = "^[a-zA-Z0-9_ ]+$"; // Allows alphabets, numbers, underscores, and spaces

	//public static final String USER_CANNOT_BE_EMPTY = "Username cannot be empty and should contain only alphabets.";

	public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$";

	public static final String PASSWORD_NOT_STRONG = "Password should be at least 6 characters long and contain both letters and numbers.";
	public static final String ROLE_INVALID = "Role must be one of the following: Admin, Doctor, or Patient.";
	public static final String NAME_PATTERN ="([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";

	public static final String EMAIL_PATTERN = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";


	public static final String PHONENUMBER_PATTERN	= "[1-9][0-9]{9}";
	public static final String BLOODGROUP_PATTERN = "^(A|B|AB|O)[+-]$";

	public static final String EMPTY_PHONENUMBER="Phone number must contain 10 digits";
	public static final String EMAIL_CANNOT_BE_EMPTY = "Enter a valid Email Example: example@example.com";

	public static final String  ADMIN_CANNOT_BE_EMPTY = "Admin name cannot be Empty and should contain only alphabets";

	public static final String EMPTY_DOCTOR = "Doctor name cannot be Empty and should contain only alphabets";
	public static final String EMPTY_SPECIALITY= "Speciality cannot be Empty and should contain only alphabets";
	public static final String EMPTY_LOCATION = "Location cannot be Empty and should contain only alphabets";
	public static final String EMPTY_HOSPITALNAME = "Hospital name cannot be Empty and should contain only alphabets";

	public static final String EMPTY_PATIENT = "Patient name cannot be Empty and should contain only alphabets";
	public static final String EMPTY_ADDRESS = "Address cannot be Empty and should contain only alphabets";
	public static final String BLOODGROUP_INVALID = "Invalid BloodGroup Enter: A+ or A- or  B+ or B- or  AB+ or AB- or  O+ or O-";
	public static final String GENDER_INVALID = "Invalid Gender! Enter: Male or Female or Others";
	public static final String INVALID_AGE = "Enter Valid Age";

	public static final String STATUS_INVALID = "Invalid Appointment Status! Enter: Approved or Cancelled or Completed";
	public static final String EMPTY_REMARK = "Please Enter the Remark";

	public static final String INVALID_RATING = "Enter Valid rating from 1 to 5";
	public static final String EMPTY_COMMENT = "Please leave the Feedback Comment";

	public static final String NAME_REMARK ="([A-Za-z ]+)";






}
