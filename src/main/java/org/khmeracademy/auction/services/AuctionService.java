package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Auction;

public interface AuctionService {
	
	public ArrayList<Auction> findAllAuctions();
	public ArrayList<Auction> findAuctionByProductName(String product_name);
	public ArrayList<Auction> findAuctionByDate(String trans_date);
	public boolean addAuction(Auction a);	
	public boolean updateAuction(Auction a);
	public boolean deleteAuction(int auction_id);	
}
