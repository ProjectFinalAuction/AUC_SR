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
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {
	//READ
	String R_CATEGORIES="SELECT * FROM auc_category WHERE status != false AND parent_id IS NULL";
	
	String R_SUB_CATEGORIES = "SELECT * FROM auc_category WHERE parent_id = #{category_id}";
	
	String R_CATEGORY_ByNAME="SELECT * FROM auc_category WHERE category_name = #{category_name}";
	String R_CATEGORY_ByPARENT_CATEGORY=
					"	SELECT	"+
					"	c.category_id,	"+
					"	c.category_name,	"+
					"	c.category_description,	"+
					"	c.parent_id,	"+
					"	c.status	"+
					"	FROM auc_category c INNER JOIN auc_category P	"+
					"	ON c.parent_id = p.category_id	"+
					"	where p.category_name = #{parent_name}";


	String R_CATEGORY_ByAnyFIELD="SELECT * FROM auc_category WHERE "
//			+ " category_id = #{category_id} or "
			+ " category_name = #{category_name} or "
			+ " category_description = #{category_description} ";
//			+ " parent_id = #{parent_id} or "
//			+ " status = #{status}";
	
	String C_CATEGORY= " INSERT INTO "
			+ " auc_category( "
			+ "		category_name,"
			+ "		category_description,"
//			+ "		parent_id, "
			+ "		status) "
			+ " VALUES( "
			+ " 	#{category_name}, "
			+ "		#{category_description}, "
//			+ "		#{parent_id} "
			+ "		#{status}"; 
	String U_CATEGORY= "UPDATE auc_category "
			+ " SET "
			+ " 	category_name = #{category_name}, "
			+ " 	category_description = #{category_description}, "
//			+ " 	parent_id = #{parent_id} "
			+ " 	status = #{status} "
			+ " WHERE "
			+ "		category_id = #{category_id}";
	String D_CATEGORY="DELETE FROM auc_category WHERE category_id = #{category_id}";
	
	@Select(R_CATEGORIES)
	@Results(value={
			@Result(property="parentCategory.category_id", column="parent_id"),
			@Result(property="subCategories", javaType=List.class, column="category_id",
					many=@Many(select="findAllSubCategories"))
	})
	public ArrayList<Category> findAllCategories();
	
	@Select(R_SUB_CATEGORIES)
	public ArrayList<Category> findAllSubCategories(int category_id);
	
	@Select(R_CATEGORY_ByNAME)
	public ArrayList<Category> findCategoryByName(String category_name); 
	
	@Select(R_CATEGORY_ByPARENT_CATEGORY)
	public ArrayList<Category> findCategoryByParentCategory(String parent_name); 
 
	@Select(R_CATEGORY_ByAnyFIELD)
	public ArrayList<Category> findCategoryByAnyField(String str_search);
	
	@Insert(C_CATEGORY)
	public boolean addCategory(Category c);
	
	@Update(U_CATEGORY)
	public boolean updateCategory(Category c); 
	
	@Delete(D_CATEGORY)
	public boolean deleteCategory(int category_id);
}
