/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ThuanBui
 */
public class ConnectDB {
    public static Connection provideConnection() throws SQLException, ClassNotFoundException {
        String user = "root";
        String pass = "Thuan0101#";
        String url = "jdbc:mysql://localhost:3306/mana_book";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
