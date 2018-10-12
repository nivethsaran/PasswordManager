package data;
import java.util.*;

import crypt.Encrypt;
import crypt.mPassword;
import data.*;
import java.io.*;
public class User {
	private String firstname;
	private String lastname;
	private String emailid;
	public String master_password;
	
	int noofTries;
	
	public User()
	{
		firstname=" ";
		lastname=" ";
		emailid="";
		noofTries=0;
		
	}
	public User(String firstname,String lastname,String emailid,String epassword)throws IOException
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.emailid=emailid;
		this.master_password=epassword;
		String emailFileEcrypted=Encrypt.encryeasy(emailid);
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
		//File dir1=new File("E:\\Misc\\OOPS Project\\"+emailid);
		//dir1.delete();
		OutputStream store=new FileOutputStream(dir,true);
		noofTries=0;
		
	}
	public String getFirstName()
	{
		return firstname;
	}
	public String getLastName()
	{
		return lastname;
	}
	public String getEmail()
	{
		return emailid;
	}
	public void setUserName(String firstname,String lastname)
	{
		this.firstname=firstname;
		this.lastname=lastname;
	}
	public void setEmail(String emailID)
	{
		this.emailid=emailID;
	}
	public void setPassword(String newpassword)
	{
		//enter password encryption stuff here
	}
	public void resetNoOfTries()
	{
		noofTries=0;
	}
	public String getHashedPass() {
		// TODO Auto-generated method stub
		return master_password;
	}
	
}
