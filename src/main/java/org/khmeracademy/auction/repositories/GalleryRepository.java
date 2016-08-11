package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Gallery;
import org.khmeracademy.auction.entities.GalleryInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository {
	//READ
	String R_GALLERY="SELECT * FROM v_find_all_gallery WHERE product_name = #{product_name}";
	@Select(R_GALLERY)
	@Results(value={
			// product
			@Result(property="product.product_name", column="product_name"),
			@Result(property="product.product_description", column="product_description"),
			@Result(property="product.qty", column="qty"),
			@Result(property="product.status", column="status"),
			@Result(property="product.supplier_id", column="supplier_id"),
			
			// supplier
			@Result(property="supplier.contact_name", column="contact_name"),
			@Result(property="supplier.address", column="address"),
			@Result(property="supplier.phone", column="phone"),
			@Result(property="supplier.email", column="email"),
			
			// category
			@Result(property="category.category_id", column="category_id"),
			@Result(property="category.category_name", column="category_name"),
			@Result(property="category.category_description", column="category_description")
			
	})
	public ArrayList<Gallery> findImageByProductName(String product_name);
	
	//CREATE
	String C_GALLERY=" INSERT INTO "
			+ " auc_gallery( "
			+ " 	product_id, "
			+ "		image_path ) "
			+ " VALUES("
			+ "		#{product_id}, "
			+ "		#{image_path}) ";
	@Insert(C_GALLERY)
	public boolean addImage(GalleryInputUpdate g);
	
	String U_GALLERY=" UPDATE auc_gallery "
			+ "SET "
			+ " 	product_id= #{product_id}, "
			+ " 	image_path= #{image_path} "
			+ "WHERE "
			+ "		image_id= #{image_id}";
	@Update(U_GALLERY)
	public boolean updateImagePath(GalleryInputUpdate g);
	
	String D_GALLERY=" DELETE FROM auc_gallery WHERE image_id = #{image_id} ";
	@Delete(D_GALLERY)
	public boolean deleteImage(int image_id);
	
}
