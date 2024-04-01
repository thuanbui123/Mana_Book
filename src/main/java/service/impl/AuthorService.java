/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.impl.AuthorDAO;
import java.util.List;
import model.AuthorModel;
import service.IAuthorService;

/**
 *
 * @author ThuanBui
 */
public class AuthorService implements IAuthorService{
    private final AuthorDAO authorDAO = new AuthorDAO();

    @Override
    public AuthorModel findOneAuthorBySlug(String slug) {
        return authorDAO.findAuthorBySlug(slug);
    }

    @Override
    public List<AuthorModel> findAllAuthors() {
        return authorDAO.findAllAuthors();
    }

    @Override
    public AuthorModel save(AuthorModel authorModel) {
        authorDAO.addAuthor(authorModel);
        return findOneAuthorBySlug(authorModel.getSlug());
    }

    @Override
    public void delete(String slug) {
        authorDAO.deleteAuthor(slug);
    }

    @Override
    public AuthorModel update(AuthorModel authorModel, String slug) {
        authorDAO.updateAuthor(authorModel, slug);
        return findOneAuthorBySlug(authorModel.getSlug());
    }
}
