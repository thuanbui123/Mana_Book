/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.AuthorModel;

/**
 *
 * @author ThuanBui
 */
public class AuthorMapper implements RowMapper<AuthorModel> {

    @Override
    public AuthorModel mapRow(ResultSet rs) {
        try {
            AuthorModel authorModel = new AuthorModel();
            authorModel.setId(rs.getInt("id"));
            authorModel.setName(rs.getString("name"));
            authorModel.setSlug(rs.getString("slug"));
            authorModel.setCreated_at(rs.getTimestamp("created_at"));
            authorModel.setUpdated_at(rs.getTimestamp("updated_at"));
            return authorModel;
        } catch (SQLException ex) {
            return null;
        }
    }
}
