/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewMain;

/**
 *
 * @author ThuanBui
 */
public class ViewMainController implements ActionListener{

    private ViewMain vm;

    public ViewMainController(ViewMain vm) {
        this.vm = vm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Cập nhật")) {
            JOptionPane.showMessageDialog(null, "update");
        } else if (action.equals("Tìm kiếm")) {
            JOptionPane.showMessageDialog(null, "Search");
        } else if (action.equals("Báo Cáo")) {
            JOptionPane.showMessageDialog(null, "Report");
        } else if (action.equals("Thống kê")) {
            JOptionPane.showMessageDialog(null, "statistical");
        } else if (action.equals("Quay lại")) {
            JOptionPane.showMessageDialog(null, "Back");
        }
    }
    
}
