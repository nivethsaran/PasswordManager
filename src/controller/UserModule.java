package controller;

import data.User;
import java.io.*;
public class UserModule implements modifymodule {

	@Override
	public void add(User user,String uname,String pass)	throws IOException {
		// TODO Auto-generated method stub
		File dir=new File("E:\\Misc\\OOPS Project\\"+user.getEmail()+".txt");
		FileWriter addData= new FileWriter(dir,true);
		String newLine = System.getProperty("line.separator");
		addData.write(uname+" "+pass);
		addData.append('\n');
		addData.close();
		
	}

	@Override
	public void change(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		
	}
	

}
