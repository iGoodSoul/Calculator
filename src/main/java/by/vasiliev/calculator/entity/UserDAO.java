package by.vasiliev.calculator.entity;

import java.sql.*;

public class UserDAO {
    String URL = "jdbc:mysql://localhost:3306/users";
    String LOGIN = "root";
    String PASSWORD = "radist127";
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}

    public User checkLogin(String login, String password) throws SQLException,
            ClassNotFoundException {


        String sqlLog = "SELECT * FROM users WHERE login = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sqlLog);
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
        }
        statement.close();
        connection.close();

        return user;
    }
    public User regAcc(String login, String password, String name) throws SQLException,
            ClassNotFoundException {


        String sqlReg = "Insert Into users (login,password,name) VALUES(?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sqlReg);
        statement.setString(1, login);
        statement.setString(2, password);
        statement.setString(3, name);
       int result = statement.executeUpdate();


        User user = null;

    if(result == 3) {
        user = new User();
    }
        statement.close();
        connection.close();

        return user;
    }

}

