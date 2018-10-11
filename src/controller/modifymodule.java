package controller;

import data.User;

public interface modifymodule {
		void add(User user,String uname,String epass);
		void remove(User user);
		void change(User user);
}
