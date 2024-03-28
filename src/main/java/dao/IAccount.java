/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.AccountModel;

/**
 *
 * @author ThuanBui
 */
public interface IAccount {

    List<AccountModel> findAllAccount();

    AccountModel findOneAccount(String username);

    AccountModel findOneById(String id);

    AccountModel signInAccount(String username, String password);

    void registerAccount(AccountModel account);
}
