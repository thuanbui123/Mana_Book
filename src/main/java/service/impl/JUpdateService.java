/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.impl.BookDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.BookModel;
import service.IJUpdateService;
import utils.UpdateTable;

/**
 *
 * @author ThuanBui
 */
public class JUpdateService implements IJUpdateService {

    private final BookDAO bookDAO = new BookDAO();

    @Override
    public BookModel findOneBookById(int id) {
        return bookDAO.findOneBookById(id);
    }

    @Override
    public List<BookModel> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    @Override
    public BookModel findOneBookBySlug(String slug) {
        return bookDAO.findOneBookBySlug(slug);
    }

    @Override
    public BookModel save(BookModel bookModel) {
        Long idBook = bookDAO.addBook(bookModel);
        return findOneBookBySlug(bookModel.getSlug());
    }

    @Override
    public void delete(Integer idBook) {
        BookModel bookModel = findOneBookById(idBook);
        bookDAO.deleteBook(idBook);
    }

    @Override
    public BookModel update(BookModel bookModel, Integer id) {

        bookDAO.updateBook(bookModel, id);
        return findOneBookById(id);
    }

    public DefaultTableModel showDataBook() {
        DefaultTableModel model = new DefaultTableModel();
        List<BookModel> list = findAllBooks();
        for (BookModel book : list) {
            model.addRow(new Object[]{book.getId(), book.getTitle(), book.getNameAuthor(), book.getQuantity()});
        }
        return model;
    }

    public static void loadData(JTable table) {
        String query = "Select books.id, books.title, author.name, books.quantity from books, author where books.authorId = author.id";
        UpdateTable.updateTableData(table, query);
    }
    
    public static void findData(JTable table, String title) {
        String query = "Select books.id, books.title, author.name, books.quantity from books, author where books.authorId = author.id and books.title like '%" + title + "%'";
        UpdateTable.updateTableData(table, query);
    }

    public void insertData(String nameBook, Integer quantity, String nameAuthor) {
        String replaced = nameBook.toLowerCase().replaceAll("\\s+", "-");
        String slug = replaced.replaceAll("[^a-z0-9-]", "");
        String description = "description";
        String imageThumbnail = "https://e7.pngegg.com/pngimages/133/587/png-clipart-out-of-the-dark-by-lun-jones-book-book-cover-mockup-online-book-book-cover-text-publishing-thumbnail.png";
        Integer idAuthor = bookDAO.findOneAuthorByName(nameAuthor);

        BookModel bookModel = new BookModel(nameBook, slug, description, imageThumbnail, idAuthor, nameAuthor, quantity);

        if (bookModel.getTitle() == null || bookModel.getTitle().isEmpty() || bookModel.getSlug() == null || bookModel.getSlug().isEmpty() || bookModel.getDescription() == null || bookModel.getDescription().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin");
        } else {
            BookModel findBook = findOneBookBySlug(bookModel.getSlug());
            if (findBook == null) {
                BookModel bookModel1 = save(bookModel);
                JOptionPane.showMessageDialog(null, "Thêm sách thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm sách không thành công");
            }
        }
    }

    public Integer findOneBookByName(String nameBook) {
        return bookDAO.findOneBookByNameBook(nameBook).getId();
    }

    public void updateData(Integer idBook, String nameBook, Integer quantity, String nameAuthor) {
        Integer idAuthor = bookDAO.findOneAuthorByName(nameAuthor);
        BookModel bookModel = new BookModel(nameBook, idAuthor, quantity);
        BookModel bookModel1 = update(bookModel, idBook);
        JOptionPane.showMessageDialog(null, "Sửa sách thành công");
    }
    
    public void deleteData (Integer idBook) {
        delete(idBook);
        BookModel bookModel = findOneBookById(idBook);
        if(bookModel != null) {
            JOptionPane.showMessageDialog(null, "Xóa sách thất bại");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa sách thành công!");
        }
    }
}
