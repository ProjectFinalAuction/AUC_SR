package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;

public interface AuctionService {
	
	public ArrayList<Auction> findAllAuctions();
	public ArrayList<Auction> findAuctionByProductName(String product_name);
	public ArrayList<Auction> findAuctionByDate(String trans_date);
	public boolean addAuction(AuctionInputUpdate a);	
	public boolean updateAuction(AuctionInputUpdate a);
	public boolean deleteAuction(int auction_id);	
}
