package objects;

import org.json.JSONObject;

public class Account {
    private String username;
    private String password;
    private String message;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String message) {
        this.username = username;
        this.password = password;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                "message='" + message + '\'' +
                '}';
    }

    public Object[] toObjectArray() {
        return new Object[]{getUsername(), getPassword()};
    }

    public Account jsonFormat(JSONObject json) {
        Account account = new Account();
        account.setUsername(json.getString("username"));
        account.setPassword(json.getString("password"));
        account.setMessage(json.getString("message"));
        return account;
    }
}
