package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.InvoiceDetail;
import org.khmeracademy.auction.repositories.InvoiceDetailRepository;
import org.khmeracademy.auction.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;

	@Override
	public ArrayList<InvoiceDetail> findAllInvoiceDetails() {
		return invoiceDetailRepository.findAllInvoiceDetails();
	}

	@Override
	public ArrayList<InvoiceDetail> findInvoiceDetailByInvoiceId(int invoice_id) {
		return invoiceDetailRepository.findInvoiceDetailByInvoiceId(invoice_id);
	}

	@Override
	public ArrayList<InvoiceDetail> findInvoiceDetailByAuctionId(int auction_id) {
		return invoiceDetailRepository.findInvoiceDetailByAuctionId(auction_id);
	}

	@Override
	public boolean addInvoiceDetail(InvoiceDetail invd) {
		return invoiceDetailRepository.addInvoiceDetail(invd);
	}

	@Override
	public boolean updateInvoiceDetail(InvoiceDetail invd) {
		return invoiceDetailRepository.updateInvoiceDetail(invd);
	}

	@Override
	public boolean deleteInvoiceDetail(int invoice_id, int auction_id) {
		return invoiceDetailRepository.deleteInvoiceDetail(invoice_id, auction_id);
	}	
	
}
