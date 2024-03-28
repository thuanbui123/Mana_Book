/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IAccount;
import java.util.List;
import mapper.AccountMapper;
import model.AccountModel;

/**
 *
 * @author ThuanBui
 */
public class AccountDAO extends AbstractDAO<AccountModel> implements IAccount {
    @Override
    public List<AccountModel> findAllAccount() {
        String sql = "SELECT * FROM account ORDER BY username ASC";
        return query(sql, new AccountMapper());
    }

    @Override
    public AccountModel findOneAccount(String username) {
        String sql = "SELECT * FROM account WHERE `username` = ?";

        if (!query(sql, new AccountMapper(), username).isEmpty()) {
            return query(sql, new AccountMapper(), username).get(0);
        } else {
            return null;
        }
    }

    @Override
    public AccountModel findOneById(String id) {
        String sql = "SELECT * FROM account WHERE `id` = ?";

        if (!query(sql, new AccountMapper(), id).isEmpty()) {
            return query(sql, new AccountMapper(), id).get(0);
        } else {
            return null;
        }
    }


    @Override
    public AccountModel signInAccount(String username, String password) {
        String sql = "SELECT * FROM account WHERE `username` = ? AND `password` = ?";
        if (!query(sql, new AccountMapper(), username, password).isEmpty()) {
            return query(sql, new AccountMapper(), username, password).get(0);
        } else {
            return null;
        }
    }

    @Override
    public void registerAccount(AccountModel account) {
        String sql = "INSERT INTO account (username, password, email, numberPhone, role) VALUES (? , ? , ?, ?, 0)";
        insert(sql, account.getUsername(), account.getPassword(), account.getEmail(), account.getPhoneNumber());
    }
}

