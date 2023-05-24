package ru.smak.db;

import ru.smak.data.Transfer;
import ru.smak.data.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private Connection connection;
    private String dbName = "bank003a";
    public DBHelper(String host, int port, String user, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbName, user, password);
    }
    public void addUser(User user) throws SQLException {
        var sql = "INSERT INTO users (phone, lastName, firstName, middleName, birth, password)" +
                " VALUES (?,?,?,?,?,?)";
        connection.setAutoCommit(false);
        var stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getPhone());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getFirstName());
        stmt.setString(4, user.getMiddleName());
        stmt.setDate(5, user.getBirth());
        stmt.setString(6, user.getPassword());
        try {
            stmt.executeUpdate();
        } catch (Exception e){
            connection.rollback();
            throw new SQLException(e);
        }
        connection.commit();
    }


    public void doTransfer(Transfer t) throws SQLException {

        var sql1 = "UPDATE accounts SET Balance = Balance - ? WHERE AccId = ?";
        var sql2 = "UPDATE accounts SET Balance = Balance + ? WHERE AccId = ?";
        connection.setAutoCommit(false);
        var stmt = connection.prepareStatement(sql1);
        stmt.setFloat(1, t.getSum() + t.getFee());
        stmt.setString(2, t.getAcc1());
        try {
            stmt.executeUpdate();
        } catch (Exception e){
            connection.rollback();
            throw new SQLException(e);
        }
        stmt = connection.prepareStatement(sql2);
        stmt.setFloat(1, t.getSum());
        stmt.setString(2, t.getAcc2());
        try {
            stmt.executeUpdate();
        } catch (Exception e){
            connection.rollback();
            throw new SQLException(e);
        }
        connection.commit();
    }
}
