package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;

import org.khmeracademy.auction.entities.BiddingAuction;

import org.khmeracademy.auction.filtering.AuctionFilter;
import org.khmeracademy.auction.utils.Pagination;

public interface AuctionService {
	
	public ArrayList<Auction> findAllAuctions(AuctionFilter filter, Pagination pagination);
	public Auction getAuctionByID(int id);
	public ArrayList<Auction> findAuctionByProductName(String product_name);
	public ArrayList<Auction> findAuctionByDate(String trans_date);
	public ArrayList<Auction> findAuctionProductByCategory(int category_id);
	public boolean addAuction(AuctionInputUpdate a);	
	public boolean updateAuction(AuctionInputUpdate a);
	public boolean deleteAuction(int auction_id);	
	
	public BiddingAuction findBiddingAuctionByAuctionId(int auction_id);
	public ArrayList<Auction> findAuctionBrandByCategory(int category_id);
}
