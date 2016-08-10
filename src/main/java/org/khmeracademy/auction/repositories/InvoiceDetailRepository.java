package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.InvoiceDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository {
	final String FIND_ALL_INVOICE_DETAILS="SELECT * FROM v_find_all_invoice_details";
	@Select(FIND_ALL_INVOICE_DETAILS)
	@Results(value={
			// user
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.address", column="address"),
			@Result(property="user.email", column="email"),
			@Result(property="user.password", column="password"),
			@Result(property="user.contact", column="contact"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="user_status"),
			
			// auction
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="auction_buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="current_price"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.end_date", column="end_date"),
			@Result(property="auction.status", column="auction_status"),
			
			// product
			@Result(property="product.product_name", column="product_name"),
			@Result(property="product.product_description", column="product_description")		
	})
	public ArrayList<InvoiceDetail> findAllInvoiceDetails();
	
	final String FIND_INVOICE_DETAIL_BY_INVOICE_ID="SELECT * FROM v_find_all_invoice_details WHERE invoice_id = #{invoice_id}";
	@Select(FIND_INVOICE_DETAIL_BY_INVOICE_ID)
	@Results(value={
			// user
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.address", column="address"),
			@Result(property="user.email", column="email"),
			@Result(property="user.password", column="password"),
			@Result(property="user.contact", column="contact"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="user_status"),
			
			// auction
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="auction_buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="current_price"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.end_date", column="end_date"),
			@Result(property="auction.status", column="auction_status"),
			
			// product
			@Result(property="product.product_name", column="product_name"),
			@Result(property="product.product_description", column="product_description")		
	})
	public ArrayList<InvoiceDetail> findInvoiceDetailByInvoiceId(int invoice_id);
	
	final String FIND_INVOICE_DETAIL_BY_AUCTION_ID="SELECT * FROM v_find_all_invoice_details WHERE auction_id = #{auction_id}";
	@Select(FIND_INVOICE_DETAIL_BY_AUCTION_ID)
	@Results(value={
			// user
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.address", column="address"),
			@Result(property="user.email", column="email"),
			@Result(property="user.password", column="password"),
			@Result(property="user.contact", column="contact"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="user_status"),
			
			// auction
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="auction_buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="current_price"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.end_date", column="end_date"),
			@Result(property="auction.status", column="auction_status"),
			
			// product
			@Result(property="product.product_name", column="product_name"),
			@Result(property="product.product_description", column="product_description")		
	})
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
