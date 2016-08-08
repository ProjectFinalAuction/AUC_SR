package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Gallery;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository {
	//READ
	String R_GALLERY="	SELECT	"+
			"	G.image_path,	"+
			"	G.product_id,	"+
			"	G.image_id,	"+
			"	auc_product.product_name	"+
			"	FROM	"+
			"	auc_gallery G	"+
			"	INNER JOIN auc_product ON auc_product.product_id = G.product_id	"+
			"	WHERE	"+
			"	auc_product.product_name = #{product_name}";
	
	//CREATE
	String C_GALLERY=" INSERT INTO "
			+ " auc_gallery( "
			+ " 	product_id, "
			+ "		image_path ) "
			+ " VALUES("
			+ "		#{product_id}, "
			+ "		#{image_path}) ";
	
	String U_GALLERY=" UPDATE auc_gallery "
			+ "SET "
			+ " 	product_id= #{product_id}, "
			+ " 	image_path= #{image_path} "
			+ "WHERE "
			+ "		image_id= #{image_id}";
	
	String D_GALLERY=" DELETE FROM auc_gallery WHERE image_id = #{image_id} ";
	
	@Select(R_GALLERY)
	public ArrayList<Gallery> findImageByProductName(String supplier_name);
	
	@Insert(C_GALLERY)
	public boolean addImage(Gallery g);
	
	@Update(U_GALLERY)
	public boolean updateImagePath(Gallery g);
	
	@Delete(D_GALLERY)
	public boolean deleteImage(int image_id);
	
}
