package data;

import objects.Account;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TesData_DB {
    public static ArrayList<Account> getAccounts(ResultSet resultSet) {
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

        }
        return accounts;
    }
}
