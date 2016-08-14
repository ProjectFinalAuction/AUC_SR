package org.khmeracademy.auction.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Category;
import org.khmeracademy.auction.entities.Gallery;
import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;
import org.springframework.stereotype.Repository;

import scala.sys.process.processInternal;

@Repository
public interface ProductRepository {
	//READ
	String R_PRODUCTS="SELECT * FROM v_find_all_products";
	
	String R_GALLERY_BY_ID ="SELECT * FROM auc_gallery WHERE product_id = #{product_id}";
	
	String R_PRODUCTS_HasSUPPLIER = "SELECT * FROM auc_product P WHERE P.supplier_id = #{supplier_id}";
	
	@Select(R_PRODUCTS)
	@Results(value={
			// supplier
			@Result(property="supplier.supplier_id",column="supplier_id"),
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_id",column="category_id"),
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_id",column="brand_id"),
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description"),		
			
			
			//gallery
			@Result(property="product_id",column="product_id"),
			@Result(property="gallery", javaType=List.class, column="product_id",
					many=@Many(select="findAllGalleryByProductID"))
		
			
	})
	public ArrayList<Product> findAllProducts();
	
	@Select(R_PRODUCTS_HasSUPPLIER)
	@Results(value={
			@Result(property="supplier.supplier_id", column="supplier_id")
	})
	public ArrayList<Product> findProductsHasSupplier(int supId);
	
	@Select(R_GALLERY_BY_ID)
	@Results(value={
			@Result(property="product.product_id", column="product_id")
	})
	public ArrayList<Gallery> findAllGalleryByProductID(int product_id);
	
	
	
	String R_PRODUCT_ByNAME="SELECT * FROM v_find_all_products WHERE product_name = #{product_name}";
	@Select(R_PRODUCT_ByNAME)
	@Results(value={
			// supplier
			@Result(property="supplier.supplier_id",column="supplier_id"),
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_id",column="category_id"),
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_id",column="brand_id"),
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findProductByName(String product_name);
	
	
	String R_PRODUCT_BySUPPLIER=
				"SELECT * FROM v_find_all_products WHERE	s.contact_name = #{supplier_name}	";
	@Select(R_PRODUCT_BySUPPLIER)
	@Results(value={
			// supplier
			@Result(property="supplier.supplier_id",column="supplier_id"),
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_id",column="category_id"),
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_id",column="brand_id"),
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findProductBySupplier(String supplier_name);
	
	String R_PRODUCT_ByCATEGORY=" SELECT * FROM v_find_all_products WHERE cat.category_name = #{category_name}";
	@Select(R_PRODUCT_ByCATEGORY) 
	@Results(value={
			// supplier
			@Result(property="supplier.supplier_id",column="supplier_id"),
			@Result(property="supplier.contact_name",column="contact_name"),
			@Result(property="supplier.address",column="address"),
			@Result(property="supplier.phone",column="phone"),
			@Result(property="supplier.email",column="email"),
			
			// category
			@Result(property="category.category_id",column="category_id"),
			@Result(property="category.category_name",column="category_name"),
			@Result(property="category.category_description",column="category_description"),
			
			// brand
			@Result(property="brand.brand_id",column="brand_id"),
			@Result(property="brand.brand_name",column="brand_name"),
			@Result(property="brand.brand_description",column="brand_description")			
	})
	public ArrayList<Product> findProductByCategory(String category_name );
//----------------------------------------------
//	String R_PRODUCT_ByAnyFIELD=""; ==> SKIPPED
//----------------------------------------------
	String C_PRODUCT= "	INSERT INTO auc_product (	"+
			"	product_name,	"+
			"	product_description,	"+
			"	supplier_id,	"+
			"	category_id,	"+
			"	qty,	"+
			"	brand_id,	"+
			"	status )	"+
			"	VALUES (	"+
			"	#{product_name},	"+
			"	#{product_description},	"+
			"	#{supplier_id},	"+
			"	#{category_id},	"+
			"	#{qty},	"+
			"	#{brand_id},	"+
			"	#{status}	"+
			"	) 	";

	@Insert(C_PRODUCT)
	public boolean addProduct(ProductInputUpdate p);
	
	
	String U_PRODUCT= " UPDATE auc_product " +
			" SET " +
			" product_name = #{product_name}, "+
			" product_description = #{product_description}, "+
			" supplier_id = #{supplier_id}, "+
			" category_id = #{category_id}, "+
			" qty = #{qty}, "+
			" brand_id = #{brand_id}, "+
			" status = #{status} "+
			" WHERE product_id = #{product_id} ";	
	@Update(U_PRODUCT)
	public boolean updateProduct(ProductInputUpdate p);
			
	String D_PRODUCT= "UPDATE auc_product SET status = false WHERE product_id = #{product_id}";
	@Delete(D_PRODUCT)
	public boolean deleteProduct(int  product_id);
	
}
