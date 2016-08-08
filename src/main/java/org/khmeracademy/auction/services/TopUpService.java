package org.khmeracademy.auction.services;

import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.auction.entities.TopUp;

public interface TopUpService {
	public ArrayList<TopUp> findAllTopUp();	
	public ArrayList<TopUp> findTopUpByCurrency(String currency);
	public ArrayList<TopUp> findTopUpByUserName(String user_name);
	public ArrayList<TopUp> findTopUpByDate(Date top_up_date);
	public boolean addTopUp(TopUp t);
	public boolean updateTopUp(TopUp t);
	public boolean deleteTopUp(int top_up_id);
}
