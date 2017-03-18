package ua.spalah.bank;


import java.sql.*;


public class JdbcMain {


    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:tcp://localhost/E:\\database\\bankdata";
        Connection connection = DriverManager.getConnection(url, "sa", "");

//        update(connection);
//        select(connection);

    }

    private static void update(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        String updateString = "INSERT INTO PUBLIC.Clients (first_name, gender, email, phone_number, city) VALUES ('Jack', 'MALE', 'jjj@gmail.com', '+362415897546', 'Dresden')";
        String deleteString = "DELETE FROM Clients WHERE first_name = 'Jack'";
        statement.executeUpdate(deleteString);
        statement.executeUpdate(updateString);
    }

    public static void select(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String select = "SELECT * from Clients";
        ResultSet resultSet = statement.executeQuery(select);
        System.out.println(resultSet);
    }


}
