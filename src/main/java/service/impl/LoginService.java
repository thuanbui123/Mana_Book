/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.impl.AccountDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.AccountModel;
import service.ILoginService;
import views.Login;
import views.ViewMain;

/**
 *
 * @author ThuanBui
 */
public class LoginService implements ILoginService {

    private final AccountDAO accountDAO = new AccountDAO();

    @Override
    public List<AccountModel> findAllAccount() {
        return accountDAO.findAllAccount();
    }

    @Override
    public AccountModel findOneAccount(String username) {
        return accountDAO.findOneAccount(username);
    }

    @Override
    public AccountModel login(String username, String password) {
        return accountDAO.signInAccount(username, password);
    }

    @Override
    public AccountModel save(AccountModel accountModel) {
        accountDAO.registerAccount(accountModel);
        return findOneAccount(accountModel.getUsername());
    }

    public void account(String username, String password, Login login) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Tài khoản hoặc mật khẩu không được để trống!", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        } else {
            AccountModel accountModel = login(username, password);
            if (accountModel == null) {
                JOptionPane.showConfirmDialog(null, "Tài khoản không tồn tại!", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            } else {
                ViewMain vm = new ViewMain();
                vm.setVisible(true);
                login.dispose();
            }
        }
    }

}
