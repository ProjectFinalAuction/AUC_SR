package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Cities;
import org.khmeracademy.auction.repositories.CitiesRepository;
import org.khmeracademy.auction.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesServiceImpl implements CitiesService{
	
	@Autowired
	CitiesRepository cityRepo;

	@Override
	public ArrayList<Cities> getCities() {
		
		return cityRepo.getCities();
	}

	@Override
	public boolean addCities(Cities city) {
		
		return cityRepo.addCities(city);
	}

	@Override
	public ArrayList<Cities> findCitiesById(int city_id) {
		
		return  cityRepo.findCitiesById(city_id);
	}

	@Override
	public boolean updateCities(Cities city) {
	
		return  cityRepo.updateCities(city);
	}

	@Override
	public boolean deleteCities(int city_id) {
		
		return  cityRepo.deleteCities(city_id);
	}
}
