/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IAuthorDAO;
import java.util.List;
import mapper.AuthorMapper;
import model.AuthorModel;

/**
 *
 * @author ThuanBui
 */
public class AuthorDAO extends AbstractDAO<AuthorModel> implements IAuthorDAO {

    @Override
    public List<AuthorModel> findAllAuthors() {
        String sql = "SELECT * FROM author ORDER BY name ASC";
        return query(sql, new AuthorMapper()); //list authors
    }

    @Override
    public AuthorModel findAuthorBySlug(String slug) {
        String sql = "SELECT * FROM author WHERE slug = ?";
        if (query(sql, new AuthorMapper(), slug).isEmpty()) {
            return null;
        }
        return query(sql, new AuthorMapper(), slug).get(0);
    }

    @Override
    public Long addAuthor(AuthorModel authorModel) {
        String sql = "INSERT INTO author (name, slug) VALUES (? , ?)";
        return insert(sql, authorModel.getName(), authorModel.getSlug()); // id generate
    }

    @Override
    public void updateAuthor(AuthorModel authorModel, String slug) {
        String sql = "UPDATE author SET name = ?, slug = ? WHERE slug = ?";
        update(sql, authorModel.getName(), authorModel.getSlug(), slug);
    }

    @Override
    public void deleteAuthor(String slug) {
        String sql = "DELETE FROM author WHERE slug = ?";
        update(sql, slug);
    }
    
}
