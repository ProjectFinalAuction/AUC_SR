package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	//get all user
	String R_USERS="SELECT *  FROM auc_user  ";
	
	//get user by name(name | first | last)
	String R_USER_ByNAME="SELECT * FROM auc_user WHERE user_name = #{user_name} or first_name = #{user_name} or last_name = #{user_name}";
	
	//get user by email
	String R_USER_ByEMAIL="SELECT * FROM auc_user WHERE email = #{email}";
	
	//get user by Any Field
	String R_USER_ByAnyFIELD="SELECT * FROM auc_user WHERE "
			+ "		user_name = #{user_name} or "
			+ "		first_name = #{user_name} or "
			+ "		last_name = #{user_name} or "
			+ "		gender = #{user_name} or "
//			+ "		dob = #{user_name} or "
			+ "		address=#{user_name} or "
			+ "		contact = #{user_name} or "
			+ "		type= #{user_name} or "
			+ "		email = #{email} or "
			+ "		created_by = #{user_name} or "
//			+ "		created_date= #{user_name} or "
			+ "		comment= #{user_name} ";
	
//	String R_USER_ByAnyFIELD="SELECT * FROM auc_user WHERE " //#{user_name} in (first_name, last_name, email, type)
//			+ "		user_name = #{user_name} or "
//			+ "		first_name = #{user_name} or "
//			+ "		last_name = #{user_name} or "
//			+ "		gender = #{user_name} or "
//			+ "		dob = #{user_name} or "
//			+ "		address = #{user_name} or "
//			+ "		email = #{user_name} or "
//			+ "		contact = #{user_name} or "
//			+ "		type = #{user_name} or "
//			+ "		status = #{user_name} or "
//			+ "		created_by = #{user_name} or "
//			+ "		created_date= #{user_name} or "
//			+ "		comment= #{user_name}";
	//Insert User
	String C_USER="INSERT INTO "
			+ "auc_user("
			+ "		user_name, "
			+ "		first_name, "
			+ "		last_name, "
			+ "		gender, "
			+ "		dob, "
			+ "		address, "
			+ "		email, "
			+ "		password, "
			+ "		contact, "
			+ "		photo, "
			+ "		type , "
			+ "		status, "
			+ "		created_by,"
			+ "		created_date, "
			+ "		comment) "
			+ "VALUES ("
			+ "		#{user_name}, "
			+ "		#{first_name}, "
			+ "		#{last_name}, "
			+ " 	#{gender},"
			+ "		#{dob}, "
			+ " 	#{address}, "
			+ " 	#{email}, "
			+ " 	#{password}, "
			+ " 	#{contact}, "
			+ " 	#{photo}, "
			+ " 	#{type},"
			+ "		#{status},"
			+ "		#{created_by},"
			+ "		#{created_date},"
			+ "		#{comment})";
	//Update User
	String U_USER="UPDATE auc_user SET "
			+ "		user_name=#{user_name}, "
			+ "		first_name=#{first_name}, "
			+ "		last_name=#{last_name}, "
			+ "		gender=#{gender},"
			+ "		dob=#{dob}, "
			+ "		address=#{address},"
			+ "		email=#{email}, "
			+ "		password=#{password}, "
			+ "		contact=#{contact}, "
			+ "		photo=#{photo}, "
			+ "		type=#{type},"
			+ "		status=#{status},"
			+ "		created_by=#{created_by},"
			+ "		created_date=#{created_date},"
			+ "		comment=#{comment} "
			+ "WHERE user_id=#{user_id}";
	//Delete User
	String D_USER="UPDATE auc_user SET status = false WHERE user_id = #{user_id}";
	
	@Select(R_USERS)
	public ArrayList<User> getAllUsers();
	
	@Select(R_USER_ByNAME)
	public User getUserByName(String user_name);
	
	@Select(R_USER_ByEMAIL)
	public User getUserByEmail(String email);
	
	@Select(R_USER_ByAnyFIELD)
	public ArrayList<User> getUserByAnyField(String user_name);
	
	@Insert(C_USER)
	public boolean addUser( User user); 
	
	@Update(U_USER)
	public boolean updateUser(User user);
	
	@Delete(D_USER)
	public boolean deleteUsers(int userId); 
	
}
