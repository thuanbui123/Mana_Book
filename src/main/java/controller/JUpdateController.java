/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import service.impl.JUpdateService;
import views.JUpdate;
import views.ViewMain;

/**
 *
 * @author ThuanBui
 */
public class JUpdateController implements ActionListener {

    private JUpdate JUpdate;
    private JUpdateService jUpdateService = new JUpdateService();

    public JUpdateController(JUpdate JUpdate) {
        this.JUpdate = JUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Thêm sách")) {
            String nameBook = this.JUpdate.txtNameBook.getText();
            Integer quantity = Integer.valueOf(this.JUpdate.txtNumber.getText());
            String nameAuthor = (String) this.JUpdate.cboAuthor.getSelectedItem();
            jUpdateService.insertData(nameBook, quantity, nameAuthor);
            JUpdateService.loadData(this.JUpdate.tblBook);
        } else if (action.equals("Sửa sách")) {
            String nameBook = this.JUpdate.txtNameBook.getText();
            Integer quantity = Integer.valueOf(this.JUpdate.txtNumber.getText());
            String nameAuthor = (String) this.JUpdate.cboAuthor.getSelectedItem();
            Integer idBook = Integer.valueOf(this.JUpdate.txtID.getText());
            jUpdateService.updateData(idBook, nameBook, quantity, nameAuthor);
            JUpdateService.loadData(this.JUpdate.tblBook);
        } else if (action.equals("Xóa sách")) {
            Integer idBook = Integer.valueOf(this.JUpdate.txtID.getText());
            String nameBook = this.JUpdate.txtNameBook.getText();
            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sách " + nameBook + " không?", "Xác nhận xóa!", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                jUpdateService.deleteData(idBook);
                JUpdateService.loadData(this.JUpdate.tblBook);
            }
        } else if (action.equals("Tìm sách")) {
            String nameBook = this.JUpdate.txtFindBook.getText();
            JUpdateService.findData(this.JUpdate.tblBook, nameBook);
        } else if (action.equals("Nhập sách mới")) {
            this.JUpdate.btnAddBook.setEnabled(true);
            this.JUpdate.txtNameBook.setText(null);
            this.JUpdate.cboAuthor.setSelectedIndex(0);
            this.JUpdate.txtNumber.setText(null);
            this.JUpdate.btnEditBook.setEnabled(false);
            this.JUpdate.btnDelBook.setEnabled(false);
        } else if (action.equals("Quay lại")) {
            ViewMain vm = new ViewMain();
            vm.setVisible(true);
            this.JUpdate.dispose();
        } else if (action.equals("Tìm phiếu mượn")) {

        } else if (action.equals("Nhập phiếu mượn mới")) {
            this.JUpdate.txtIdLoanSlip.setText(null);
            this.JUpdate.txtNameCustomer.setText(null);
            this.JUpdate.cboNameBorrowedBook.setSelectedIndex(0);
            this.JUpdate.txtBorrowedDay.setText(null);
            this.JUpdate.btnAddLoanSlip.setEnabled(true);
        } else if (action.equals("Thêm phiếu mượn")) {

        } else if (action.equals("Sửa phiếu mượn")) {

        } else if (action.equals("Xóa phiếu mượn")) {

        } else if (action.equals("Trả sách")) {

        } else if (action.equals("Tìm kiếm khách hàng")) {

        } else if (action.equals("Nhập khách hàng mới")) {
            this.JUpdate.btnAddCustomer.setEnabled(true);
            this.JUpdate.txtMaKhach.setText(null);
            this.JUpdate.txtTenKhachHang.setText(null);
            this.JUpdate.txtEmail.setText(null);
            this.JUpdate.txtEmail.setText(null);
            this.JUpdate.txtPhone.setText(null);
        } else if (action.equals("Thêm khách hàng")) {

        } else if (action.equals("Sửa khách hàng")) {

        } else if (action.equals("Xóa khách hàng")) {

        }
    }

}
