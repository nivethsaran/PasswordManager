package passwordManagerPackage;
import java.util.*;
public class LoginModule {
	
	
	void getInput()
	{	Scanner in=new Scanner(System.in);
		String uname,pass;
		System.out.println("Enter UserName:");
		uname=in.nextLine();
		System.out.println("Enter Password:");
		pass=in.nextLine();
		
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
