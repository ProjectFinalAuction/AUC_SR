package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Countries;
import org.khmeracademy.auction.repositories.CountriesRepository;
import org.khmeracademy.auction.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountriesServiceImpl implements CountriesService{

	@Autowired
	private CountriesRepository countryRepository;
	
	@Override
	public boolean insertCountry(Countries c) {
		return countryRepository.insertCountry(c);
	}

	@Override
	public ArrayList<Countries> getAllCountries() {
		return countryRepository.getAllCountries();
	}

	@Override
	public Countries getCountry(int id) {
		return countryRepository.getCountry(id);
	}

	@Override
	public boolean updateCountry(Countries c) {
		return countryRepository.updateCountry(c);
	}

	@Override
	public boolean deleteCountry(int id) {
		return countryRepository.deleteCountry(id);
	}
	
}
