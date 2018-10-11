package data;
import java.util.*;

import crypt.mPassword;
import data.*;
public class User {
	private String firstname;
	private String lastname;
	private String emailid;
	public mPassword master_password;
	int noofTries;
	public User()
	{
		firstname=" ";
		lastname=" ";
		emailid="";
		noofTries=0;
		
	}
	public User(String firstname,String lastname,String emailid,String epassword)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.emailid=emailid;
		this.master_password=new mPassword("epassword");
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
		return master_password.getEncryptedPassword();
	}
	
}
