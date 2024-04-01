/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.AuthorModel;

/**
 *
 * @author ThuanBui
 */
public interface IAuthorService {
    AuthorModel findOneAuthorBySlug(String slug);

    List<AuthorModel> findAllAuthors();

    AuthorModel save(AuthorModel authorModel);

    void delete(String slug);

    AuthorModel update(AuthorModel authorModel, String slug);

}
