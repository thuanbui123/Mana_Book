/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.impl.LoginService;
import views.Login;

/**
 *
 * @author ThuanBui
 */
public class LoginController implements ActionListener{
    private Login login;
    private LoginService loginService = new LoginService();

    public LoginController(Login login) {
        this.login = login;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Đăng nhập")) {
            String username = this.login.txtTaiKhoan.getText();
            String password = this.login.txtMatKhau.getText();
            loginService.account(username, password, login);
        } else {
            System.exit(0);
        }
    }
}
