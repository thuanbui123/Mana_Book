/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mana_book;

import dao.IBookDAO;
import dao.impl.BookDAO;
import java.util.List;
import model.BookModel;

/**
 *
 * @author ThuanBui
 */
public class Mana_Book {

    public static void main(String[] args) {
        IBookDAO bookDAO = new BookDAO();
        List<BookModel> list = bookDAO.findAllBooks();
        for(BookModel bookModel : list) {
            System.out.println(bookModel.toString());
        }
    }
}
