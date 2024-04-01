/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.BookModel;

/**
 *
 * @author ThuanBui
 */
public interface IBookDAO extends IGenericDAO<BookModel> {
    List<BookModel> findAllBooks();
    BookModel findOneBookById(int id);

    BookModel findOneBookBySlug (String slug);

    Long addBook(BookModel bookModel);

    void updateBook(BookModel bookModel,Integer id);

    void deleteBook(Integer idBook);
}
