/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.BookModel;

/**
 *
 * @author ThuanBui
 */
public interface IJUpdateService {
    BookModel findOneBookById(int id);

    List<BookModel> findAllBooks();

    BookModel findOneBookBySlug (String slug);

    BookModel save(BookModel bookModel);

    void delete(Integer idBook);

    BookModel update(BookModel bookModel, Integer id);
}
