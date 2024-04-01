/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mana_book;

import dao.IBookDAO;
import dao.impl.BookDAO;
import java.util.List;
import model.BookModel;
import service.impl.JUpdateService;

/**
 *
 * @author ThuanBui
 */
public class Mana_Book {

    public static void main(String[] args) {
        JUpdateService bookDAO = new JUpdateService();
        List<BookModel> list = bookDAO.findAllBooks();
        for(BookModel bookModel : list) {
            System.out.println(bookModel.toString());
        }
    }
}
