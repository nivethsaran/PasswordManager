package controller;
import java.util.ArrayList;
import java.util.Scanner;
import data.*;
public class LoginModule {
	
	
	public void loginSetup(ArrayList<User> users)
	{	Scanner in=new Scanner(System.in);
		String uname,pass;
		System.out.println("Enter UserName:");
		uname=in.nextLine();
		System.out.println("Enter Password:");
		pass=in.nextLine();
		boolean auth=authenticate(uname,pass,users);
		
		
	}
	void afterLogin(User user)
	{
		System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
	}
	boolean authenticate(String uname,String pass,ArrayList<User> users)
	{System.out.println(users.size());
		for(int i=0;i<users.size();i++)
		{
			if(uname==users.get(i).getEmail())
			{
				afterLogin(users.get(i));
			}
			else
			{
				System.out.println("Illegal Entry!!!");
			}
		}
		return false;
	}
	boolean isExceedsLimit(int nooftries) {
		if(nooftries>3)
			return true;
		return false;
	}
}
