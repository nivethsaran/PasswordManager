package controller;

import java.io.IOException;

import data.User;

public interface modifymodule {
		void add(User user,String uname,String epass) throws IOException;
		void remove(User user,String uname) throws IOException;
		void change(User user,String uname,String epass) throws IOException;
		void listEntries(User user) throws IOException;
		void findEntry(User user,String uname)throws IOException;
		void findPassStrength(User user,String uname)throws IOException;
}
