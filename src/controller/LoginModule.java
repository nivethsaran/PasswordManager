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
		int auth_Token=authenticate(uname,pass,users);
		if(auth_Token!=-1)
			afterLogin(users.get(auth_Token));
		else
			System.out.println("Wrong details entered");
		
		
		
	}
	void afterLogin(User user)
	{
		System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
	}

	
	int authenticate(String uname,String pass,ArrayList<User> users)
	{//System.out.println(users.size());
		
	for(int i=0;i<users.size();i++)
		{
			if(uname.equals(users.get(i).getEmail())&&pass.equals(users.get(i).getHashedPass()))
			{	
				return i;
			}
			
		}
		
		return -1;
	}
	boolean isExceedsLimit(int nooftries) {
		if(nooftries>3)
			return true;
		return false;
	}
}
