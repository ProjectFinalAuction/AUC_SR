package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Countries;

public interface CountriesService {
	
	public boolean insertCountry(Countries c);	
	
	public ArrayList<Countries> getAllCountries();	
	
	public Countries getCountry(int id);	
	
	public boolean updateCountry(Countries c);	
	
	public boolean deleteCountry(int id);
}
