package utilities;

import objects.Account;

import java.sql.*;
import java.util.ArrayList;

public class ReadDB {
    static Connection connection;
    static ResultSet resultSet;
    static Statement statement;

    public static void main(String[] args) {
        connection = connection();
        ArrayList<Account> accounts = getAccounts(connection);
        /*closeConnections();*/
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
        Account account = getAccount(connection, "abc");
        System.out.println(account.toString());
        /*closeConnections();*/

        String update_Account_SQL = "update \"Accounts\" set message = ?, password = ? where username = ?;";
        updateAccount(connection, new Account("abc", "new password", "new message"), update_Account_SQL);

        String insert_Account_SQL = "INSERT INTO \"Accounts\" VALUES (?, ? ,?)";
        createAccount(connection, new Account("hehe", "pass", "mess"), insert_Account_SQL);

        String delete_Account_SQL = "DELETE FROM \"Accounts\" WHERE username = ?";
        deleteAccount(connection, new Account("hehe", "pass", "mess"), delete_Account_SQL);
        closeConnections();
    }

    public static ResultSet executeQuery(Connection conn, String query) {
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return rs;
    }


    public static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + Constant.DB_HOSTNAME + ":" + Constant.DB_PORT + "/" + Constant.DB_NAME,
                            Constant.DB_USERNAME, Constant.DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    public static ArrayList<Account> getAccounts(Connection conn) {
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("Select * from \"Accounts\"");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Account account = new Account();
                account.setUsername(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));
                account.setMessage(resultSet.getString(3));
                accounts.add(account);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return accounts;
    }

    public static Account getAccount(Connection conn, String username) {
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("Select * from \"Accounts\" WHERE username = '" + username + "'");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        Account account = new Account();
        try {
            if (resultSet.next()) {
                account.setUsername(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));
                account.setMessage(resultSet.getString(3));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return account;
    }

    public static void updateAccount(Connection connection, Account account, String query) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.getMessage());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getUsername());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createAccount(Connection connection, Account account, String query) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getMessage());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void deleteAccount(Connection connection, Account account, String query) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void closeConnections() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (Exception exception) {
        }
    }
}
