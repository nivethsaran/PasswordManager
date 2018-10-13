package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import crypt.Encrypt;
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
	public void afterLogin(User user)
	{	String ename,epass;
		modifymodule mod=new UserModule();
		System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
		char ch2;
		do {
		System.out.println("What service would you like to use?\n1.Create new Password Entry\n2.Modify Password Entry\n3.Remove Password Entry\n4.List All Entries\n5.Get Password\n6.Get Password Strength\n7.Logout");
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
			System.out.println("Enter Entry Name to Remove");
			ename=in.nextLine();
		
			try {
					mod.remove(user,ename);
			}	catch(Exception E){
						System.out.println(E.getStackTrace());
					}
				
		}
		else if(ch==4)
		{
			try {
				mod.listEntries(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ch==5)
		{
			System.out.println("Enter Entry Name to GET Password");
			ename=in.nextLine();
			try {
				mod.findEntry(user,ename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ch==6)
		{
			System.out.println("Enter Entry Name to GET Password Strength");
			ename=in.nextLine();
			try {
				mod.findPassStrength(user, ename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return;
		}
		System.out.println("Do you want to Logout y/n");
		ch2=(in.nextLine()).charAt(0);
		
		}while(ch2=='n'||ch2=='N');
		}
		

	
	int authenticate(String uname,String pass,ArrayList<User> users)
	{//System.out.println(users.size());
		
	for(int i=0;i<users.size();i++)
		{
			if(uname.equals(users.get(i).getEmail())&&Encrypt.aesencrypt(pass).equals(users.get(i).getHashedPass()))
			{	
				return i;
			}
			
		}
		
		return -1;
	}

}
