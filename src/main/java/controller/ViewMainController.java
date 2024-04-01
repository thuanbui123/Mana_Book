/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.JUpdate;
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
        switch (action) {
            case "Cập nhật":
                JUpdate jUpdate = new JUpdate();
                jUpdate.setVisible(true);
                this.vm.dispose();
                break;
            case "Tìm kiếm":
                JOptionPane.showMessageDialog(null, "Search");
                break;
            case "Báo Cáo":
                JOptionPane.showMessageDialog(null, "Report");
                break;
            case "Thống kê":
                JOptionPane.showMessageDialog(null, "statistical");
                break;
            case "Quay lại":
                JOptionPane.showMessageDialog(null, "Back");
                break;
            default:
                break;
        }
    }
    
}
