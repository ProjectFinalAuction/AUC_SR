package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Supplier;

public interface SupplierService {

	public ArrayList<Supplier> findAllSuppliers();
	
	public ArrayList<Supplier> findSupplierByName(String contact_name);
	
	public ArrayList<Supplier> findSupplierByEmail(String email);
	
	public ArrayList<Supplier> findSupplierByAnyField(String str_search);
	
	public boolean addSupplier(Supplier s);
	
	public boolean updateSupplier(Supplier s); 
	
	public boolean deleteSupplier(int supplier_id);
	
	public ArrayList<Supplier> findSupplierById(int supplier_id);

}
