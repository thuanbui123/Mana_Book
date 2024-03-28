/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.AccountModel;

/**
 *
 * @author ThuanBui
 */
public interface ILoginService {
    List<AccountModel> findAllAccount ();
    AccountModel findOneAccount (String username);
    AccountModel login (String username, String password);
    AccountModel save (AccountModel accountModel);
}
