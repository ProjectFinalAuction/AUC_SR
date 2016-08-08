package org.khmeracademy.auction.services.impl;

import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.auction.entities.Invoice;
import org.khmeracademy.auction.repositories.InvoiceRepository;
import org.khmeracademy.auction.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public ArrayList<Invoice> findAllInvoices() {
		return invoiceRepository.findAllInvoices();
	}

	@Override
	public ArrayList<Invoice> findInvoiceByUserName(String user_name) {
		return invoiceRepository.findInvoiceByUserName(user_name);
	}

	@Override
	public ArrayList<Invoice> findInvoiceByDate(Date invoice_date) {
		return invoiceRepository.findInvoiceByDate(invoice_date);
	}

	@Override
	public boolean addInvoice(Invoice inv) {
		return invoiceRepository.addInvoice(inv);
	}

	@Override
	public boolean updateInvoice(Invoice inv) {
		return invoiceRepository.updateInvoice(inv);
	}

	@Override
	public boolean deleteInvoice(int invoice_id) {
		return invoiceRepository.deleteInvoice(invoice_id);
	}
	
	
}
