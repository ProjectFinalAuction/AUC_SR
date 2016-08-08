package org.khmeracademy.auction.services;

import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.auction.entities.Invoice;

public interface InvoiceService {
	
	public ArrayList<Invoice> findAllInvoices();
	public ArrayList<Invoice> findInvoiceByUserName(String user_name);
	public ArrayList<Invoice> findInvoiceByDate(Date invoice_date);
	public boolean addInvoice(Invoice inv);
	public boolean updateInvoice(Invoice inv);
	public boolean deleteInvoice(int invoice_id);
}
