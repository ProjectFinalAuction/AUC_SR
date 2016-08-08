package org.khmeracademy.auction.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository {
	final String FIND_ALL_INVOICES ="SELECT * FROM auc_invoice";
	@Select(FIND_ALL_INVOICES)
	public ArrayList<Invoice> findAllInvoices();
	
	final String FIND_INVOICE_BY_USER_NAME=
					"	SELECT	"+
					"	i.invoice_id,	"+
					"	i.user_id,	"+
					"	i.invoice_date	"+
					"	FROM	"+
					"	auc_invoice i	"+
					"	INNER JOIN auc_user u ON u.user_id = i.user_id	"+
					"	WHERE	"+
					"	u.user_name = 'd'	";
	@Select(FIND_INVOICE_BY_USER_NAME)
	public ArrayList<Invoice> findInvoiceByUserName(String user_name);
	
	final String FIND_INVOICE_BY_DATE="SELECT * FROM auc_invoice WHERE invoice_date = #{invoice_date} ";
	@Select(FIND_INVOICE_BY_DATE)
	public ArrayList<Invoice> findInvoiceByDate(Date invoice_date);
	
	final String ADD_INVOICE="INSERT INTO auc_invoice(user_id,invoice_date) VALUES(#{user_id},#{invoice_date}) ";
	@Insert(ADD_INVOICE)
	public boolean addInvoice(Invoice inv);
	
	final String UPDATE_INVOICE=
					"	UPDATE auc_invoice	"+
					"	SET user_id = #{user_id}, 	"+
					"	invoice_date = #{invoice_date}	"+
					"	WHERE invoice_id = #{invoice_id}	";
	@Update(UPDATE_INVOICE)
	public boolean updateInvoice(Invoice inv);
	
	final String DELETE_INVOICE="DELETE FROM auc_invoice WHERE invoice_id = #{invoice_id}";
	@Delete(DELETE_INVOICE)
	public boolean deleteInvoice(int invoice_id);

}
