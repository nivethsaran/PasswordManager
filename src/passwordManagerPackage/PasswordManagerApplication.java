package passwordManagerPackage;
import data.*;
import files.*;

import java.io.*;
import java.util.*;
import controller.*;
public class PasswordManagerApplication {

	public static void main(String[] args) throws IOException{
		ArrayList<User> users=new ArrayList<User>();
		Scanner scan=new Scanner(System.in);
		
		MainDirectory md=new MainDirectory();
		md.makeDir();
		md.storeUserData();
		System.out.println("Enter your choice\n1.New User\n2.Login");
		int ch=Integer.parseInt(scan.nextLine());
		if(ch==1)
		{
			RegistrationModule reg=new RegistrationModule();
			String fileout=reg.registrationSetup();
			md.addFileData(fileout);
			}
		else if(ch==2)
		{
			LoginModule login=new LoginModule();
			
		}
		else
		{
			
		}
	}

}
