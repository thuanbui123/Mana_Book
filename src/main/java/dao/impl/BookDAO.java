/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IBookDAO;
import java.util.ArrayList;
import java.util.List;
import mapper.AuthorMapper;
import mapper.BookMapper;
import model.BookModel;
import model.CategoryModel;

/**
 *
 * @author ThuanBui
 */
public class BookDAO extends AbstractDAO<BookModel> implements IBookDAO {
    
    public Integer findOneAuthorByName (String name) {
        String sql = "Select * from author Where name=?";
        return query(sql, new AuthorMapper(), name).get(0).getId();
    }
    
    @Override
    public List<BookModel> findAllBooks() {
        String sql = "SELECT DISTINCT * FROM books, author WHERE books.authorId = author.id ORDER BY books.title ASC";
        List<BookModel> bookModels = query(sql, new BookMapper());
        return bookModels;
    }

    @Override
    public BookModel findOneBookById(int id) {
        String sql = "SELECT DISTINCT * FROM books WHERE books.id = ?";
        if (query(sql, new BookMapper(), id) == null || query(sql, new BookMapper(), id).isEmpty()) return null;
        return query(sql, new BookMapper(), id).get(0);
    }

    @Override
    public BookModel findOneBookBySlug(String slug) {
        String sql = "SELECT DISTINCT * FROM books, author WHERE books.authorId = author.id AND books.slug = ?";
        if (query(sql, new BookMapper(), slug).isEmpty()) {
            return null;
        }
        return query(sql, new BookMapper(), slug).get(0);
    }
    
    public BookModel findOneBookByNameBook(String name) {
        String sql = "SELECT DISTINCT * FROM books, author WHERE books.authorId = author.id AND books.title = ?";
        if (query(sql, new BookMapper(), name).isEmpty()) {
            return null;
        }
        return query(sql, new BookMapper(), name).get(0);
    }

    @Override
    public Long addBook(BookModel bookModel) {
        String sql = "INSERT INTO books (title, slug , description, imageThumbnail, rate, liked, authorId, quantity) VALUES (?, ? ,? ,? ,0 ,0, ? , ?)";
        return insert(sql, bookModel.getTitle(), bookModel.getSlug(), bookModel.getDescription(), bookModel.getImageThumbnail(), bookModel.getIdAuthor(), bookModel.getQuantity());
    }

    public void addCategoriesOnBook(ArrayList<CategoryModel> categoryModels, long idBook) {
        String sqlCategoriesOnBook = "INSERT INTO categoriesonbook (categoryId, bookId) VALUES (? , ?)";
        categoryModels.forEach(categoryModel -> insert(sqlCategoriesOnBook, categoryModel.getId(), idBook));
    }

    @Override
    public void updateBook(BookModel bookModel, Integer id) {
        String sql = "UPDATE books SET `title` = ?,`authorId` = ?, `quantity` = ? WHERE `id` = ?";
        update(sql, bookModel.getTitle(), bookModel.getIdAuthor(), bookModel.getQuantity(), id);
    }

    public void deleteCategoriesOnBook(BookModel bookModel) {
        String sqlDeleteCategoriesOnBook = "DELETE FROM categoriesonbook WHERE bookId = ?";
        update(sqlDeleteCategoriesOnBook, bookModel.getId());
    }

    @Override
    public void deleteBook(Integer id) {
        String sql = "DELETE FROM books WHERE id = ?";
        update(sql, id);
    }

}
