package passwordManagerPackage;
import data.*;
import files.*;

import java.io.*;
import java.util.*;
import controller.*;
public class PasswordManagerApplication {

	public static void main(String[] args) throws IOException{
		System.out.println("||||||PASSWORD MANAGER|||||||");
		ArrayList<User> users=new ArrayList<User>();
		String fileLineData[];
		char ch2;
		Scanner scan=new Scanner(System.in);
		MainDirectory md=new MainDirectory();
		md.makeDir();
		md.storeUserData();
		File userdata=md.userdata;
		FileInputStream fstream = new FileInputStream(userdata);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String fileLine;
		while ((fileLine = br.readLine()) != null)   {
			fileLineData=fileLine.split(" ");
			users.add(new User(fileLineData[0],fileLineData[1],fileLineData[2],fileLineData[3]));
			//System.out.println(fileLineData[0]+" "+fileLineData[1]+" "+fileLineData[2]+" "+fileLineData[3]);
		}
		br.close();
		do {
		System.out.println("Enter your choice\n1.New User\n2.Login");
		int ch=Integer.parseInt(scan.nextLine());
		if(ch==1)
		{
			RegistrationModule reg=new RegistrationModule();
			String fileout=reg.registrationSetup();
			if(fileout==null)
			{
				System.out.println("Registration Process Cancelled");
			}else
			{
				System.out.println("Registration Process Successful");
				md.addFileData(fileout);
				fileLineData=fileout.split(" ");
				users.add(new User(fileLineData[0],fileLineData[1],fileLineData[2],fileLineData[3]));
				
			}
		}
		else if(ch==2)
		{
			LoginModule login=new LoginModule();
			login.loginSetup(users);
			
			
		}
		else
		{
			System.out.println("");
		}
		System.out.println("Exit Application y/n");
		 ch2=(scan.nextLine()).charAt(0);
		
		}while(ch2=='n'||ch2=='N');
	}

}
