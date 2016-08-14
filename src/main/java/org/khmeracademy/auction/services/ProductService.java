package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;


public interface ProductService {

	public ArrayList<Product> findAllProducts();

	public ArrayList<Product> findProductByName(String product_name);

	public ArrayList<Product> findProductBySupplier(String supplier_name);
 
	public ArrayList<Product> findProductByCategory(String category_name );
	
	public ArrayList<Product> findProductsHasSupplier(int supId);

	public boolean addProduct(ProductInputUpdate p);

	public boolean updateProduct(ProductInputUpdate p);

	public boolean deleteProduct(int  product_id);
}
