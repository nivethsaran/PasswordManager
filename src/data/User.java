package data;
import java.util.*;
public class User {
	private String firstname;
	private String lastname;
	private String emailid;
	private String master_password;
	private ArrayList<String> entries;
	int noofTries;
	
	String getFirstName()
	{
		return firstname;
	}
	String getLastName()
	{
		return lastname;
	}
	String getEmail()
	{
		return emailid;
	}
}
