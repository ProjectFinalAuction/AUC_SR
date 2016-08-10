package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
	//READ
	String R_PRODUCTS="SELECT * FROM auc_product";
	String R_PRODUCT_ByNAME="SELECT * FROM auc_product WHERE product_name = #{product_name}";
	String R_PRODUCT_BySUPPLIER=
				"	SELECT	"+
					"	P .product_id,	"+
					"	P .product_name,	"+
					"	P .product_description,	"+
					"	P .supplier_id,	"+
					"	P .category_id,	"+
					"	P .qty,	"+
					"	P .brand_id,	"+
					"	P .status	"+
					"	FROM	"+
					"	auc_product P	"+
					"	INNER JOIN auc_supplier s ON s.supplier_id = P .supplier_id	"+
					"	WHERE	"+
					"	s.contact_name = #{supplier_name}	";
	String R_PRODUCT_ByCATEGORY="	SELECT	"+
					"	P.product_id,	"+
					"	P.product_name,	"+
					"	P.product_description,	"+
					"	P.supplier_id,	"+
					"	P.category_id,	"+
					"	P.qty,	"+
					"	P.brand_id,	"+
					"	P.status	"+
					"	FROM	"+
					"	auc_product P	"+
					"	INNER JOIN auc_category cat ON cat.category_id = P.category_id	"+
					"	WHERE	"+
					"	cat.category_name = #{category_name}";
//----------------------------------------------
//	String R_PRODUCT_ByAnyFIELD=""; ==> SKIPPED
//----------------------------------------------
	String C_PRODUCT= "INSERT INTO "
					+ " auc_product( "
					+ "		product_name, "
					+ "		product_description, "
					+ "		supplier_id, "
					+ "		category_id, "
					+ "		qty, "
					+ "		brand_id, "
					+ "		status ) "
					+ " VALUES ( "
					+ " 	#{product_name}, "
					+ "		#{product_description}, "
					+ "		#{supplier_id}, "
					+ "    	#{category_id}, "
					+ "		#{qty}, "
					+ "		#{brand_id}, "
					+ "		#{status} ) ";
	String U_PRODUCT= "UPDATE auc_product "
					+ " SET "
					+ " 	product_name = #{product_name}, "
					+ "		product_description = #{product_description}, "
					+ "		supplier_id = #{supplier_id}, "
					+ "		category_id = #{category_id}, "
					+ "		qty = #{qty}, "
					+ "		brand_id = #{brand_id}, "
					+ "		status = #{status} "
					+ " WHERE "
					+ "		product_id = #{product_id}";
	String D_PRODUCT= "UPDATE auc_product SET status = false WHERE product_id = #{product_id}";
	
	@Select(R_PRODUCTS)
	public ArrayList<Product> findAllProducts();
	
	@Select(R_PRODUCT_ByNAME)
	public ArrayList<Product> findProductByName(String product_name);
	
	@Select(R_PRODUCT_BySUPPLIER)
	public ArrayList<Product> findProductBySupplier(String supplier_name);
	
	@Select(R_PRODUCT_ByCATEGORY) 
	public ArrayList<Product> findProductByCategory(String category_name );
	
	@Insert(C_PRODUCT)
	public boolean addProduct(ProductInputUpdate p);
	
	@Update(U_PRODUCT)
	public boolean updateProduct(ProductInputUpdate p);
	
	@Delete(D_PRODUCT)
	public boolean deleteProduct(int  product_id);
}
