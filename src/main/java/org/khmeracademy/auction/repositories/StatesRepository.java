package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.States;
import org.springframework.stereotype.Repository;
@Repository	
public interface StatesRepository {
	final String C_STATE = "INSERT INTO auc_states(country_id, state_name) VALUES(#{country_id},#{state_name })";
	final String RA_STATES = "SELECT * FROM auc_states";
	final String R_STATE = "SELECT * FROM auc_states WHERE state_id = #{state_id}";
	final String U_STATE = "UPDATE auc_states SET state_name = #{state_name} WHERE state_id = #{state_id}";
	final String D_STATE = "DELETE FROM auc_states WHERE state_id = #{state_id}";
	
	@Insert(C_STATE)
	public boolean insertState(States s);
	
	@Select(RA_STATES)
	@Results(value = {
			@Result(property="state_id", column="state_id"),
			@Result(property="country_id", column="country_id"),
			@Result(property="state_name", column="state_name")
	})
	public ArrayList<States> getAllStates();
	
	@Select(R_STATE)
	@Results(value = {
			@Result(property="state_id", column="state_id"),
			@Result(property="country_id", column="country_id"),
			@Result(property="state_name", column="state_name")
	})
	public States getState(int id);
	
	@Update(U_STATE)
	public boolean updateState(States s);
	
	@Delete(D_STATE)
	public boolean deleteState(int id);
}
