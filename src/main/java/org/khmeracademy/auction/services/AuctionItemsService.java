package org.khmeracademy.auction.services;

import java.util.ArrayList;
import org.khmeracademy.auction.entities.AuctionItems;

public interface AuctionItemsService {

	public ArrayList<AuctionItems> getAllAuctionItems();

	public boolean addAuctionItem(AuctionItems auctionItem);

	public boolean deleteActionItem(AuctionItems auctionItem);

	public boolean updateActionItem(AuctionItems aucitonItem);
}
