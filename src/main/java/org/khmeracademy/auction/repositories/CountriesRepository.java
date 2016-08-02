package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Countries;

public interface CountriesRepository {
	final String C_COUNTRY = "INSERT INTO countries(country_name) VALUES(#{country_name })";
	final String RA_COUNTRIES = "SELECT * FROM countries";
	final String R_COUNTRY = "SELECT * FROM countries WHERE country_id = #{country_id}";
	final String U_COUNTRY = "UPDATE countries SET country_name = #{country_name} WHERE country_id = #{country_id}";
	final String D_COUNTRY = "DELETE FROM countries WHERE country_id = #{country_id}";
	
	@Insert(C_COUNTRY)
	public boolean insertCountry(Countries c);
	
	@Select(RA_COUNTRIES)
	@Results(value = {
			@Result(property="country_id", column="country_id"),
			@Result(property="country_name", column="country_name")
	})
	public ArrayList<Countries> getAllCountries();
	
	@Select(R_COUNTRY)
	@Results(value = {
			@Result(property="country_id", column="country_id"),
			@Result(property="country_name", column="country_name")
	})
	public Countries getCountry(int id);
	
	@Update(U_COUNTRY)
	public boolean updateCountry(Countries c);
	
	@Delete(D_COUNTRY)
	public boolean deleteCountry(int id);
}
