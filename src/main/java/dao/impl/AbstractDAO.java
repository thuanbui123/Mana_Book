/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IGenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import mapper.RowMapper;
import utils.ConnectDB;

/**
 *
 * @author ThuanBui
 */
public class AbstractDAO<T> implements IGenericDAO<T>{

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.provideConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (Exception ex) {

            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (statement != null) {
                    statement.close();
                } else if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ex) {
                return null;
            }
        }
    }
    
    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Integer) {
                    statement.setInt(index, (int) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(index, (Float) parameter);
                } else if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.provideConnection(); //Runtime Exception; And SQLException;
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (statement != null) {
                    statement.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Long id = null;
            connection = ConnectDB.provideConnection(); //Runtime Exception; And SQLException;
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();

            return id;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (statement != null) {
                    statement.close();
                } else if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
}
