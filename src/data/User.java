package data;
import java.util.*;
public class User {
	private String firstname;
	private String lastname;
	private String emailid;
	private String master_password;
	int noofTries;
	public User()
	{
		firstname=" ";
		lastname=" ";
		emailid="";
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
	
}
