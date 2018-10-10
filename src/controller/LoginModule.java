package controller;
import java.util.Scanner;
import data.*;
public class LoginModule {
	
	
	void loginSetup()
	{	Scanner in=new Scanner(System.in);
		String uname,pass;
		System.out.println("Enter UserName:");
		uname=in.nextLine();
		System.out.println("Enter Password:");
		pass=in.nextLine();
		boolean auth=authenticate(uname,pass);
		
		
	}
	void afterLogin(User user)
	{
		System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
	}
	boolean authenticate(String uname,String pass)
	{
		return false;
	}
	boolean isExceedsLimit(int nooftries) {
		if(nooftries>3)
			return true;
		return false;
	}
}
