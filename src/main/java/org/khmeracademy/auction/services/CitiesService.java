package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Cities;

public interface CitiesService {
	
	public ArrayList<Cities> getCities();
	public boolean addCities(Cities city);
	public ArrayList<Cities> findCitiesById(int city_id);
	public boolean updateCities(Cities city);
	public boolean deleteCities(int city_id);
}
