package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository {
	//READ 
	String R_BRANDS="SELECT * FROM auc_brand";
	String R_BRAND_ByNAME=" SELECT * FROM auc_brand WHERE brand_name = #{brand_name}";
	String R_BRAND_ByAnyFIELD="SELECT * FROM auc_brand "
			+ " WHERE "
			+ "		brand_name= #{brand_name} or "
			+ "		brand_description = #{brand_description} ";
	//CREATE
	String C_BRAND="INSERT INTO "
			+ " auc_brand( "
			+ " 	brand_name, "
			+ "		brand_description, "
			+ "		status) "
			+ " VALUES( "
			+ " 	#{brand_name}, "
			+ "		#{brand_description},"
			+ "		#{status})";
	//UPDATE
	String U_BRAND=" UPDATE auc_brand "
			+ " SET "
			+ "		brand_name = #{brand_name}, "
			+ "		brand_description = #{brand_description}, "
			+ "		status = #{status} "
			+ " WHERE "
			+ " 	brand_id = #{brand_id}";
	//DELETE
	String D_BRAND=" UPDATE auc_brand SET status = false WHERE brand_id = #{brand_id} ";
	
	@Select(R_BRANDS)
	public ArrayList<Brand> findAllBrands();
	
	@Select(R_BRAND_ByNAME)
	public ArrayList<Brand> findBrandByName(String brand_name);
	
	@Select(R_BRAND_ByAnyFIELD)
	public ArrayList<Brand> findBrandByAnyField (String str_search);
	
	@Insert(C_BRAND)
	public boolean addBrand(Brand b);
	
	@Update(U_BRAND)
	public boolean updateBrand(Brand b);
	
	@Delete(D_BRAND)
	public boolean deleteBrand(int brand_id);
}
