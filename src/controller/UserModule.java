package controller;

import data.Entry;
import data.User;
import files.MainDirectory;

import java.io.*;
import java.util.ArrayList;

import crypt.Encrypt;
import crypt.Password;
public class UserModule implements modifymodule {

	@Override
	public void add(User user,String uname,String pass)	throws IOException {
		// TODO Auto-generated method stub
		String emailFileEcrypted=Encrypt.encryeasy(user.getEmail());
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
		FileWriter addData= new FileWriter(dir,true);
		String newLine = System.getProperty("line.separator");
		Password encrypass=new Password(pass);
		String encryPassString=encrypass.getEncryptedPassword();
		addData.write(uname+" "+encryPassString);
		//user.entries.add(new Entry(uname,new Password(pass)));
		addData.append("\n");
		addData.close();
		
	}

	@Override
	public void change(User user,String uname,String pass)	throws IOException {
		// TODO Auto-generated method stub
		String fileLineData[];
		ArrayList<Entry> entries=new ArrayList<Entry>();
		String emailFileEcrypted=Encrypt.encryeasy(user.getEmail());
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
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
		//System.out.println(n);
		boolean flag=false;
		for(int i=0;i<entries.size();i++)
		{
			if(uname.equals(entries.get(i).getEName()))
			{	flag=true;
			Password encrypass=new Password(pass);
			String encryPassString=encrypass.getEncryptedPassword();
				entries.get(i).setPassword(encryPassString);
				break;
			}
		}
		if(!flag) {
			System.out.println("No such entry exists");
			return;
		}
		FileWriter addData= new FileWriter(dir);
		addData.write("");
		
		for(int i=0;i<n;i++)
		{	addData=new FileWriter(dir,true);
			String tuname=entries.get(i).getEName();
			String tnewpass=Encrypt.encryeasy(entries.get(i).getPassword());
			//System.out.println(tuname+" "+tnewpass);
			addData.write(tuname+" "+tnewpass);
			addData.append('\n');
			addData.close();
		}
		
		
		
		
	}

	@Override
	public void remove(User user,String uname)	throws IOException {
		
		String fileLineData[];
		ArrayList<Entry> entries=new ArrayList<Entry>();
		String emailFileEcrypted=Encrypt.encryeasy(user.getEmail());
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
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
		//System.out.println(n);
		boolean flag=false;
		for(int i=0;i<entries.size();i++)
		{
			if(uname.equals(entries.get(i).getEName()))
			{	flag=true;
				entries.remove(i);
				i--;
				
			}
		}
		if(!flag) {
			System.out.println("No such entry exists");
			return;
		}
		FileWriter addData= new FileWriter(dir);
		addData.write("");
		
		for(int i=0;i<n-1;i++)
		{	addData=new FileWriter(dir,true);
			String tuname=entries.get(i).getEName();
			String tnewpass=Encrypt.encryeasy(entries.get(i).getPassword());
			//System.out.println(tuname+" "+tnewpass);
			addData.write(tuname+" "+tnewpass);
			addData.append('\n');
			addData.close();
		}
		
			
	}

	@Override
	public void listEntries(User user) throws IOException {
		// TODO Auto-generated method stub
		String fileLineData[];
		String emailFileEcrypted=Encrypt.encryeasy(user.getEmail());
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
		FileInputStream fstream = new FileInputStream(dir);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String fileLine="";
		while ((fileLine = br.readLine()) != null)   {
			fileLineData=fileLine.split(" ");
			System.out.println("Entry Name: "+fileLineData[0]+"--> Password:"+Encrypt.encryeasy(fileLineData[1]));
			
			
		}
	}

	@Override
	public void findEntry(User user, String uname) throws IOException {
		// TODO Auto-generated method stub
		String fileLineData[];
		ArrayList<Entry> entries=new ArrayList<Entry>();
		String emailFileEcrypted=Encrypt.encryeasy(user.getEmail());
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
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
		//System.out.println(n);
		boolean flag=false;
		for(int i=0;i<entries.size();i++)
		{
			if(uname.equals(entries.get(i).getEName()))
			{	flag=true;
				System.out.println("Entryname:"+entries.get(i).getEName()+"-->Password: "+entries.get(i).getPassword());
				break;
			}
		}
		if(!flag) {
			System.out.println("No such entry exists");
			return;
		}
	}

	@Override
	public void findPassStrength(User user, String uname) throws IOException {
		// TODO Auto-generated method stub
		String fileLineData[];
		ArrayList<Entry> entries=new ArrayList<Entry>();
		String emailFileEcrypted=Encrypt.encryeasy(user.getEmail());
		File dir=new File("E:\\Misc\\OOPS Project\\"+emailFileEcrypted+".txt");
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
		//System.out.println(n);
		boolean flag=false;
		for(int i=0;i<entries.size();i++)
		{
			if(uname.equals(entries.get(i).getEName()))
			{	flag=true;
			boolean strength=RegistrationModule.password_strength(entries.get(i).getPassword());
			if(strength)
				System.out.println("Entryname:"+entries.get(i).getEName()+"-->Password Strength: Strong");
			else
				System.out.println("Entryname:"+entries.get(i).getEName()+"-->Password Strength: Weak");
				break;
			}
		}
		if(!flag) {
			System.out.println("No such entry exists");
			return;
		}
	}
	

}
