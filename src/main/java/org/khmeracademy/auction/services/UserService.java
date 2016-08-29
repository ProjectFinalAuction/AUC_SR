package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.User;
import org.khmeracademy.auction.entities.UserInputUpdate;
import org.khmeracademy.auction.filtering.UserFilter;
import org.khmeracademy.auction.utils.Pagination;

public interface UserService {
	
	public ArrayList<User> getAllUsers(UserFilter filter, Pagination pagination);
	
	public User findUserById(int user_id);
	
	public User getUserByName(String user_name);
	
	public boolean userLogin(User user);
	
	public User getUserByEmail(String email);
	
	public ArrayList<User> getUserByAnyField(String user_name);
	
	public boolean addUser(UserInputUpdate u);
	
	public boolean updateUser(User user);
	
	public boolean deleteUsers(int userId);
	
	public User findUserByVerifiedCode(String verified_code);
}
