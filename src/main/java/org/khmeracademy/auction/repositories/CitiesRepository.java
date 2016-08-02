package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Cities;
import org.springframework.stereotype.Repository;



@Repository
public interface CitiesRepository {
	
	//Get Cities from table auc_cities
		String R_CITIES = "SELECT city_id, state_id ,city_name "
							+ "FROM auc_cities ORDER BY city_id";
		
		@Select(R_CITIES)
		public ArrayList<Cities> getCities();
		
		
		//Insert Cities into table auc_cities
		String C_CITIES = "INSERT INTO auc_cities (city_id, state_id ,city_name) "
							+ "VALUES( #{city_id} , #{state_id} , #{city_name} )";
		
		@Insert(C_CITIES)
		public boolean addCities(Cities city);
		
		
		
		//Get Cities By ID
		String F_CITIES = "SELECT city_id, state_id ,city_name "
				+ "FROM auc_cities WHERE city_id=#{city_id}";

		@Select(F_CITIES)
		public ArrayList<Cities> findCitiesById(int city_id);
		
		
		//Update Cities into table auc_cities
		String U_CITIES = "UPDATE auc_cities SET city_name=#{city_name},"
							+ " state_id=#{state_id} WHERE city_id=#{city_id}";
		
		@Update(U_CITIES)
		public boolean updateCities(Cities city);
		
		
		
		//Delete Cities into table auc_cities
		String D_CITIES = "DELETE FROM auc_cities WHERE city_id=#{city_id}";
		
		@Delete(D_CITIES)
		public boolean deleteCities(int city_id);
	
}
