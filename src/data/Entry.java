package data;

import crypt.Password;

public class Entry {
		private String entryname;
		private Password entrypass;
		private int id;
		Entry(String ename,String epass,String id)
		{	
			//int n for hello
		}
		public Entry(String uname, Password password) {
			// TODO Auto-generated constructor stub
			entryname=uname;
			entrypass=password;
		}
		public String getEName()
		{
			return entryname;
		}
		public String getPassword()
		{
			return entrypass.getEncryptedPassword();
		}
}
