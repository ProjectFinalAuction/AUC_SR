package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.User;

public interface UserService {
	
	public ArrayList<User> getAllUsers();
	
	public User findUserById(int user_id);
	
	public User getUserByName(String user_name);
	
	public boolean userLogin(User user);
	
	public User getUserByEmail(String email);
	
	public ArrayList<User> getUserByAnyField(String user_name);
	
	public boolean addUser( User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUsers(int userId);
}
