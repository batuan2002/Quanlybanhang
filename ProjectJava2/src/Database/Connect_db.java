/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author ASUS
 */
import java.sql.*;

public class Connect_db {

    public static Connection getConnection() {
        Connection con = null;
        String connectionUrl = "jdbc:mysql://" + database.HOSTNAME
                + ":" + database.PORT + "/"
                + database.DBNAME;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("MySQL Connector/J is missing");
            return con;
        }
        con = DriverManager.getConnection(connectionUrl, database.USERNAME, database.PASSWORD);
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Close connection failed");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Close ResultSet failed");
        }
    }

    public static void closePreparedStatement(PreparedStatement prepare) {
        try {
            if (prepare != null) {
                prepare.close();
            }
        } catch (SQLException e) {
            System.out.println("Close PreparedStatement failed");
        }
    }

}