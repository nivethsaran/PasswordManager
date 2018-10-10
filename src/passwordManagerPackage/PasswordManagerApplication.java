package passwordManagerPackage;
import data.*;
import java.io.*;
import java.util.*;
import controller.*;
public class PasswordManagerApplication {

	public static void main(String[] args) {
		ArrayList<User> users=new ArrayList<User>();
		Scanner scan=new Scanner(System.in);
		
		
		System.out.println("Enter your choice\n1.New User\n2.Login");
		int ch=Integer.parseInt(scan.nextLine());
		if(ch==1)
		{
			RegistrationModule.registrationSetup();
			}
		else if(ch==2)
		{
			
		}
		else
		{
			
		}
	}

}
