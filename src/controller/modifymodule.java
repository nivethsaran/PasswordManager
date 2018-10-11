package controller;

import java.io.IOException;

import data.User;

public interface modifymodule {
		void add(User user,String uname,String epass) throws IOException;
		void remove(User user);
		void change(User user);
}
