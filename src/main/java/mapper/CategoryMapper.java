/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CategoryModel;

/**
 *
 * @author ThuanBui
 */
public class CategoryMapper implements RowMapper<CategoryModel>{
    @Override
    public CategoryModel mapRow(ResultSet rs) {

        try {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(rs.getInt("id"));
            categoryModel.setName(rs.getString("name"));
            categoryModel.setSlug(rs.getString("slug"));
            categoryModel.setCreated_at(rs.getTimestamp("created_at"));
            categoryModel.setUpdated_at(rs.getTimestamp("updated_at"));

            return categoryModel;
        }catch(SQLException ex){
            return null;
        }

    }
}
