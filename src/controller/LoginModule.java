package controller;
import java.util.ArrayList;
import java.util.Scanner;
import data.*;
public class LoginModule {
	Scanner in=new Scanner(System.in);
	
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
	{	String ename,epass;
		modifymodule mod=new UserModule();
		System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
		System.out.println("What service would you like to use?\n1.Create new Password Entry\n2.Modify Password Entry\n3.Remove Password Entry\n4.Logout");
		int ch=Integer.parseInt(in.nextLine());
		if(ch==1)
		{System.out.println("Enter Entry Name");
		ename=in.nextLine();
		System.out.println("Enter Entry Password");
		epass=in.nextLine();
		try {
				mod.add(user,ename,epass);
		}	catch(Exception E){
					System.out.println(E.getStackTrace());
				}
		}
		else if(ch==2)
		{System.out.println("Enter Entry Name");
		ename=in.nextLine();
		System.out.println("Enter New Password");
		epass=in.nextLine();
		try {
				mod.change(user,ename,epass);
		}	catch(Exception E){
					System.out.println(E.getStackTrace());
				}
			
		}
		else if(ch==3)
		{
			//mod.add(user,ename,epass);
		}
		else
		{
			System.out.println("You have successfully Logged Out");
		}
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
