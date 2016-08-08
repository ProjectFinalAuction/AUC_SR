package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.InvoiceDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository {
	final String FIND_ALL_INVOICE_DETAILS="SELECT * FROM auc_invoice_detail";
	@Select(FIND_ALL_INVOICE_DETAILS)
	public ArrayList<InvoiceDetail> findAllInvoiceDetails();
	
	final String FIND_INVOICE_DETAIL_BY_INVOICE_ID="SELECT * FROM auc_invoice_detail WHERE invoice_id = #{invoice_id}";
	@Select(FIND_INVOICE_DETAIL_BY_INVOICE_ID)
	public ArrayList<InvoiceDetail> findInvoiceDetailByInvoiceId(int invoice_id);
	
	final String FIND_INVOICE_DETAIL_BY_AUCTION_ID="SELECT * FROM auc_invoice_detail WHERE auction_id = #{auction_id}";
	@Select(FIND_INVOICE_DETAIL_BY_AUCTION_ID)
	public ArrayList<InvoiceDetail> findInvoiceDetailByAuctionId(int auction_id);
	
	final String ADD_INVOICE_DETAIL="INSERT INTO auc_invoice_details(invoice_id,auction_id,buy_price,qty) VALUES(#{invoice_id},#{auction_id},#{buy_price},#{qty})";
	@Insert(ADD_INVOICE_DETAIL)
	public boolean addInvoiceDetail(InvoiceDetail invd);
	
	final String UPDATE_INVOICE_DETAIL="UPDATE auc_invoice_detail "+
									" SET buy_price = #{buy_price}, qty = #{qty} "+
									" WHERE invoice_id = #{invoice_id} AND auction_id = #{auction_id} ";
	@Update(UPDATE_INVOICE_DETAIL)
	public boolean updateInvoiceDetail(InvoiceDetail invd);
	
	final String DELETE_INVOICE_DETAIL="DELETE FROM auc_invoice_detail "+
			" WHERE invoice_id = #{invoice_id} AND auction_id = #{auction_id}";
	@Delete(DELETE_INVOICE_DETAIL)
	public boolean deleteInvoiceDetail(int invoice_id, int auction_id);
}
