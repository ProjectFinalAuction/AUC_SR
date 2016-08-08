package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.InvoiceDetail;

public interface InvoiceDetailService {
	
	public ArrayList<InvoiceDetail> findAllInvoiceDetails();	
	public ArrayList<InvoiceDetail> findInvoiceDetailByInvoiceId(int invoice_id);	
	public ArrayList<InvoiceDetail> findInvoiceDetailByAuctionId(int auction_id);	
	public boolean addInvoiceDetail(InvoiceDetail invd);	
	public boolean updateInvoiceDetail(InvoiceDetail invd);	
	public boolean deleteInvoiceDetail(int invoice_id, int auction_id);
}
