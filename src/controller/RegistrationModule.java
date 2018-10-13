package controller;
import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

import crypt.mPassword;
public class RegistrationModule {
	
public String registrationSetup()
{String email;  
mPassword userMasterPassword;
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
	 email=in.nextLine();
	boolean isEmail=isValidEmail(email);
	if(isEmail)
		{
		break;
		}
	else
	{
	System.out.println("The Email you have entered is not valid. Would you like to try again? y/n");
	ch=(in.nextLine()).charAt(0);
	if(ch=='n'||ch=='N')
		email=null;
	}
}while(ch=='y'||ch=='Y');
	if(email==null)
	{
		//System.out.println("Registration Process Cancelled");
		return null;
	}
	else
	{
		System.out.println("Enter your Password");
		String password=in.nextLine();
		userMasterPassword=new mPassword(password);
	}
	
	return fname+" "+lname+" "+email+" "+userMasterPassword.getEncryptedPassword(userMasterPassword.getNormalPass());
}
public static boolean isValidEmail(String a){
		try {
		String p1=null,p2=null,p3=null;
		String temp;
		String[] part1 = a.split("@");
		p1 = part1[0];
		temp = part1[1];
		String[] part2 = temp.split("\\.",2);
		p2 = part2[0];
		p3 = part2[1];
		
		if(p1!=null&&p2!=null&&p3!=null) {
			return true;
		}
		else
			return false;
	}
		catch(Exception E)
		{
			return false;
		}
		
	}
	
	public static boolean password_strength(String a)
	{
		int l=a.length();
		int csc=0;
		int cn=0;
		for(int i=0;i<l;++i)
		{
			if(Character.isDigit(a.charAt(i)))
				cn++;
			if(!Character.isLetterOrDigit(a.charAt(i)))
				csc++;
		}
		if(l>=10&&csc>=2&&cn>=3)
			return true;
		else
			return false;
	}
}
