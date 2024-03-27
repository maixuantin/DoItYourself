package utilities;

import objects.Account;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadJSON {
    public static ArrayList<Account> getAccounts(String path) {
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            String str = new String(Files.readAllBytes(Paths.get(Constant.JSON_FILE)));
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Account account = new Account();
                accounts.add(account.jsonFormat(jsonObject));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return accounts;
    }

    public static void main(String[] args) throws IOException {
        String path = Constant.JSON_FILE;
        ArrayList<Account> accounts = getAccounts(path);
        for (Account account : accounts) {
            System.out.println(account.getUsername());
            System.out.println(account.getPassword());
            System.out.println(account.getMessage());
        }
    }
}
