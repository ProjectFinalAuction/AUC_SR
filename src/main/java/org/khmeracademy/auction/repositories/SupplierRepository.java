package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository {
	//READ
	String R_SUPPLIERS = " SELECT * FROM auc_supplier where status <> '2'"; // statis=2 i.e deleted
	String R_SUPPLIER_ByNAME = "SELECT * FROM auc_supplier WHERE contact_name = #{contact_name} and status <> '2'";
	String R_SUPPLIER_ByEMAIL = "SELECT * FROM auc_supplier WHERE email = #{email} and status<>'2'";
	String R_SUPPLIER_ByAnyFIELD = "SELECT * FROM auc_supplier WHERE "
			+ " #{contact_name} in (supplier_id::TEXT, contact_name, address, phone, email) and status<>'2'";
	String R_SUPPLIER_ById = "SELECT * FROM auc_supplier WHERE supplier_id = #{supplier_id} and status<>'2'";
	String R_SUPPLIERS_InPRODUCTS = "SELECT * FROM auc_supplier S "
			+ "WHERE S.supplier_id "
			+ "IN (SELECT P.supplier_id FROM auc_product P ) and S.status<>'2'";
	//CREATE | INSERT 
	String C_SUPPLIER = "INSERT INTO "
			+ "auc_supplier( "
			+ " 	contact_name, "
			+ "		address, "
			+ "		phone, "
			+ "		email,status) "
			+ "VALUES( "
			+ "		#{contact_name}, "
			+ "		#{address}, "
			+ "		#{phone}, "
			+ "		#{email},#{status}) ";
	//UPDATE
	String U_SUPPLIER = " UPDATE auc_supplier SET "
			+ " 	contact_name = #{contact_name}, "
			+ "		address = #{address}, "
			+ "		phone = #{phone}, "
			+ "		email = #{email} "
			+ "		status = #{status} "
			+ "WHERE supplier_id = #{supplier_id}";
	//DELETE
	String D_USER = "UPDATE auc_supplier SET status = '2' WHERE supplier_id = #{supplier_id}";

	@Select(R_SUPPLIERS)
	public ArrayList<Supplier> findAllSuppliers();
	
	@Select(R_SUPPLIER_ByNAME)
	public ArrayList<Supplier> findSupplierByName(String contact_name);
	
	@Select(R_SUPPLIER_ByEMAIL)
	public ArrayList<Supplier> findSupplierByEmail(String email);
	
	@Select(R_SUPPLIER_ByAnyFIELD)
	public ArrayList<Supplier> findSupplierByAnyField( String str_search);
	
	@Insert(C_SUPPLIER)
	public boolean addSupplier(Supplier s);
	
	@Update(U_SUPPLIER)
	public boolean updateSupplier(Supplier s); 
	
	@Delete(D_USER)
	public boolean deleteSupplier(int supplier_id);
	
	@Select(R_SUPPLIER_ById)
	public Supplier findSupplierById(int id);
	
	@Select(R_SUPPLIERS_InPRODUCTS)
	public ArrayList<Supplier> findSupplierInProducts();
	
}
