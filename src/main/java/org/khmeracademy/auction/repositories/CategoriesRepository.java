package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Categories;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository {
	
	//Get Categories from table auc_categories
	String R_CATEGORIES = "SELECT category_id, category_name, is_sub_of_category "
						+ "FROM auc_categories ORDER BY category_id";
	
	@Select(R_CATEGORIES)
	public ArrayList<Categories> getCategories();
	
	
	//Insert Categories into table auc_categories
	String C_CATEGORIES = "INSERT INTO auc_categories (category_id, category_name, is_sub_of_category) "
						+ "VALUES( #{category_id} , #{category_name} , #{is_sub_of_category} )";
	
	@Insert(C_CATEGORIES)
	public boolean addCategories(Categories cate);
	
	
	
	//Get Categories By ID
	String F_CATEGORIES = "SELECT category_id, category_name, is_sub_of_category "
			+ "FROM auc_categories WHERE category_id=#{category_id}";

	@Select(F_CATEGORIES)
	public ArrayList<Categories> findCategoriesById(int category_id);
	
	
	//Insert Categories into table auc_categories
	String U_CATEGORIES = "UPDATE auc_categories SET category_name=#{category_name},"
						+ " is_sub_of_category=#{is_sub_of_category} WHERE category_id=#{category_id}";
	
	@Update(U_CATEGORIES)
	public boolean updateCategories(Categories cate);
	
	
	
	//Insert Categories into table auc_categories
	String D_CATEGORIES = "DELETE FROM auc_categories WHERE category_id=#{category_id}";
	
	@Delete(D_CATEGORIES)
	public boolean deleteCatedories(int category_id);
}
