package controller;

import data.Entry;
import data.User;
import files.MainDirectory;

import java.io.*;
import java.util.ArrayList;

import crypt.Password;
public class UserModule implements modifymodule {

	@Override
	public void add(User user,String uname,String pass)	throws IOException {
		// TODO Auto-generated method stub
		
		File dir=new File("E:\\Misc\\OOPS Project\\"+user.getEmail()+".txt");
		FileWriter addData= new FileWriter(dir,true);
		String newLine = System.getProperty("line.separator");
		addData.write(uname+" "+pass);
		//user.entries.add(new Entry(uname,new Password(pass)));
		addData.append("\n");
		addData.close();
		
	}

	@Override
	public void change(User user,String uname,String pass)	throws IOException {
		// TODO Auto-generated method stub
		String fileLineData[];
		ArrayList<Entry> entries=new ArrayList<Entry>();
		File dir=new File("E:\\Misc\\OOPS Project\\"+user.getEmail()+".txt");
		FileInputStream fstream = new FileInputStream(dir);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String fileLine="";
		while ((fileLine = br.readLine()) != null)   {
			fileLineData=fileLine.split(" ");
			Entry temp=new Entry(fileLineData[0],new Password(fileLineData[1]));
			entries.add(temp);
			
		}
		br.close();
		int n=entries.size();
		System.out.println(n);
		for(int i=0;i<entries.size();i++)
		{
			if(uname.equals(entries.get(i).getEName()))
			{
				entries.set(i, new Entry(uname,new Password(pass)));
			}
		}
		FileWriter addData= new FileWriter(dir);
		addData.write("");
		addData=new FileWriter(dir,true);
		for(int i=0;i<n;i++)
		{
			String tuname=entries.get(i).getEName();
			String tnewpass=entries.get(i).getPassword();
			System.out.println(tuname+" "+tnewpass);
			addData.write(tuname+" "+tnewpass);
			addData.append("\n");
			addData.close();
		}
		
		
		
		
	}

	@Override
	public void remove(User user,String uname,String pass)	throws IOException {
		// TODO Auto-generated method stub
		
	}
	

}
