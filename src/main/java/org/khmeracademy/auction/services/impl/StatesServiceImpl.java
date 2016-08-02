package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.States;
import org.khmeracademy.auction.repositories.StatesRepository;
import org.khmeracademy.auction.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatesServiceImpl implements StatesService{
	@Autowired
	private StatesRepository statesRepository;

	@Override
	public boolean insertState(States s) {
		return statesRepository.insertState(s);
	}

	@Override
	public ArrayList<States> getAllStates() {
		return statesRepository.getAllStates();
	}

	@Override
	public States getState(int id) {
		return statesRepository.getState(id);
	}

	@Override
	public boolean updateState(States s) {
		return statesRepository.updateState(s);
	}

	@Override
	public boolean deleteState(int id) {
		return statesRepository.deleteState(id);
	}
	
	
}
