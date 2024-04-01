/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AuthorModel;
import model.BookModel;
import utils.TimeConvertUtils;

/**
 *
 * @author ThuanBui
 */
public class BookMapper implements RowMapper<BookModel> {

    @Override
    public BookModel mapRow(ResultSet resultSet) {
        try {
            int bookId = (int) resultSet.getLong(1);
            BookModel bookModel = new BookModel();
            bookModel.setId(bookId);
            bookModel.setNameAuthor(resultSet.getString("author.name"));
            bookModel.setDescription(resultSet.getString("description"));
            bookModel.setSlug(resultSet.getString("books.slug"));
            bookModel.setImageThumbnail(resultSet.getString("imageThumbnail"));
            bookModel.setQuantity((int) resultSet.getLong("quantity"));
            bookModel.setIdAuthor((int) resultSet.getLong("authorId"));
            bookModel.setTitle(resultSet.getString("title"));
            bookModel.setCreated_at(resultSet.getTimestamp("books.created_at"));
            bookModel.setUpdated_at(resultSet.getTimestamp("books.updated_at"));

            bookModel.setCreated(TimeConvertUtils.convertTimestampToDate(resultSet.getTimestamp("books.created_at")));
            bookModel.setUpdated(TimeConvertUtils.convertTimestampToDate(resultSet.getTimestamp("books.updated_at")));

            return bookModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
