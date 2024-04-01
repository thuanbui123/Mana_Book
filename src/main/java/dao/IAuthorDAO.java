/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.AuthorModel;

/**
 *
 * @author ThuanBui
 */
public interface IAuthorDAO extends IGenericDAO<AuthorModel>{
    List<AuthorModel> findAllAuthors();
    AuthorModel findAuthorBySlug(String slug);

    Long addAuthor(AuthorModel authorModel);

    void updateAuthor(AuthorModel authorModel, String slug);

    void deleteAuthor(String slug);

}
