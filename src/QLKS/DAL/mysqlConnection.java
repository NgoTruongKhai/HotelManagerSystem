/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import java.sql.*;


/**
 *
 * @author ASUS
 */
public class mysqlConnection {

    String hostname;
    String username;
    String password;
    String database;

    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;

    public mysqlConnection(String hostname, String username, String password, String database) {
        this.hostname = hostname;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    //kieerm tra driver
    protected void driverTest() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("JDBC driver not found....");
        }
    }

    //kết nối database
    protected Connection getConnection() throws Exception {
        if (this.connection == null) {
            driverTest();
            String url = "jdbc:mysql://" + this.hostname + ":3306/" + this.database;
            try {
                this.connection = DriverManager.getConnection(url, this.username, this.password);
            } catch (java.sql.SQLException e) {
                throw new Exception("khong the ket noi database " + this.database + "---" + this.connection);
            }
        }
        return this.connection;
    }

    protected Statement getStatement() throws SQLException, Exception {
        if (this.statement == null ? true : this.statement.isClosed()) {
            this.statement = this.getConnection().createStatement();
        }
        return this.statement;
    }

    //select
    public ResultSet excuteQuery(String query) throws Exception {
        try {
            this.result = getStatement().executeQuery(query);
        } catch (Exception e) {
            throw new Exception("erro:" + e.getMessage() + "--" + query);
        }

        return this.result;
    }

    // insert,delete,update
    public int excuteUpdate(String query) throws Exception {
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("erro : " + e.getMessage() + "---" + query);

        } finally {
            this.Close();
        }
        return res;
    }

    // đống kết nối database
    public void Close() throws SQLException {
        if (this.result != null && this.result.isClosed()) {
            this.result.close();
            this.result = null;
        }
        if (this.statement != null && this.statement.isClosed()) {
            this.statement.close();
            this.statement = null;
        }
        if (this.connection != null && this.connection.isClosed()) {
            this.connection.close();
            this.connection = null;
        }

    }

}
