package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
	//READ
	String R_PRODUCTS="SELECT * FROM v_find_all_products";
	@Select(R_PRODUCTS)
	@Results(value={
			// supplier
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findAllProducts();
	
	String R_PRODUCT_ByNAME="SELECT * FROM v_find_all_products WHERE product_name = #{product_name}";
	@Select(R_PRODUCT_ByNAME)
	@Results(value={
			// supplier
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findProductByName(String product_name);
	
	
	String R_PRODUCT_BySUPPLIER=
				"SELECT * FROM v_find_all_products WHERE	s.contact_name = #{supplier_name}	";
	@Select(R_PRODUCT_BySUPPLIER)
	@Results(value={
			// supplier
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findProductBySupplier(String supplier_name);
	
	String R_PRODUCT_ByCATEGORY=" SELECT * FROM v_find_all_products WHERE cat.category_name = #{category_name}";
	@Select(R_PRODUCT_ByCATEGORY) 
	@Results(value={
			// supplier
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findProductByCategory(String category_name );
//----------------------------------------------
//	String R_PRODUCT_ByAnyFIELD=""; ==> SKIPPED
//----------------------------------------------
	String C_PRODUCT= " SELECT pr_add_product("
					+ " 	#{product_name}, "
					+ "		#{product_description}, "
					+ "		#{supplier_id}, "
					+ "    	#{category_id}, "
					+ "		#{qty}, "
					+ "		#{brand_id}, "
					+ "		#{status} ) ";
	@Insert(C_PRODUCT)
	public boolean addProduct(ProductInputUpdate p);
	
	
	String U_PRODUCT= " SELECT pr_update_product("
			+ " 	#{product_id}, "
			+ " 	#{product_name}, "
			+ "		#{product_description}, "
			+ "		#{supplier_id}, "
			+ "    	#{category_id}, "
			+ "		#{qty}, "
			+ "		#{brand_id}, "
			+ "		#{status} ) ";		
	@Update(U_PRODUCT)
	public boolean updateProduct(ProductInputUpdate p);
			
	String D_PRODUCT= "UPDATE auc_product SET status = false WHERE product_id = #{product_id}";
	@Delete(D_PRODUCT)
	public boolean deleteProduct(int  product_id);
	
}
