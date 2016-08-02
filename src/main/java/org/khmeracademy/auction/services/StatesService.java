package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.States;

public interface StatesService {
public boolean insertState(States s);
	
	
	public ArrayList<States> getAllStates();
	
	public States getState(int id);
	
	public boolean updateState(States s);
	
	public boolean deleteState(int id);
}
