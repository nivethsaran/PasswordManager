package controller;
import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
public class RegistrationModule {
	
public static void registrationSetup()
{//String  
	char ch='y';
	Scanner in=new Scanner(System.in);
	System.out.println("SNAAP Password Manager to save all your passwords Hassle Free\n"
			+ "Please enter details as requested");
	System.out.println("Enter Your First Name");
	String fname=in.nextLine();
	System.out.println("Enter Your Last Name");
	String lname=in.nextLine();
	do {
	System.out.println("Enter Email Address");
	String email=in.nextLine();
	boolean isEmail=isValidEmail(email);
	if(isEmail)
		{
		break;
		}
	else
	{
	System.out.println("The Email you have entered is not valid. Would you like to try again? y/n");
	ch=(in.nextLine()).charAt(0);
	
	}
}while(ch=='y'||ch=='Y');
}
public static boolean isValidEmail(String email) 
{ 
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                        "[a-zA-Z0-9_+&*-]+)*@" + 
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                        "A-Z]{2,7}$"; 
                          
    Pattern pat = Pattern.compile(emailRegex); 
    if (email == null) 
        return false; 
    return pat.matcher(email).matches(); 
} 
}
