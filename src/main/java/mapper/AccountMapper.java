/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.AccountModel;

/**
 *
 * @author ThuanBui
 */
public class AccountMapper implements RowMapper<AccountModel> {
    @Override
    public AccountModel mapRow(ResultSet resultSet) {
        try {
            AccountModel accountModel = new AccountModel();

            accountModel.setId(resultSet.getInt("id"));
            accountModel.setUsername(resultSet.getString("username"));
            accountModel.setPassword(resultSet.getString("password"));
            accountModel.setEmail(resultSet.getString("email"));
            accountModel.setPhoneNumber(resultSet.getString("numberPhone"));
            accountModel.setRole(resultSet.getInt("role"));
            accountModel.setCreated_at(resultSet.getTimestamp("created_at"));
            accountModel.setUpdated_at(resultSet.getTimestamp("updated_at"));

            return accountModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
