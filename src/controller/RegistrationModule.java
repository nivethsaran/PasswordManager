package controller;
import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
public class RegistrationModule {
	
void registrationSetup()
{//String  
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
		
	}
}while(true);
}
public boolean isValidEmail(String email) 
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
