package data;

import objects.Account;
import utilities.Constant;
import utilities.ReadCSV;

import java.util.ArrayList;

public class TestData_Sauce {
    public static Account accountSuccess1(){return new Account("standard_user", "secret_sauce");}
    public static Account accountSuccess2(){return new Account("locked_out_user", "secret_sauce");}
    public static Account accountSuccess3(){return new Account("problem_user", "secret_sauce");}
    public static Account accountSuccess4(){return new Account("performance_glitch_user", "secret_sauce");}
    public static Account invalidUsername(){return new Account("abc", "secret_sauce");}
    public static Account invalidPassword1(){return new Account("standard_user", "abc");}
    public static Account invalidPassword2(){return new Account("locked_out_user", "abc");}
    public static Account invalidPassword3(){return new Account("problem_user", "abc");}
    public static Account invalidPassword4(){return new Account("performance_glitch_user", "abc");}
    public static ArrayList<Account> readAccount(){
        ArrayList<Account> accountArrayList = new ArrayList<>();
        ArrayList<String> data = ReadCSV.readCSV(Constant.ACCOUNT_FILE);
        for (String str : data){
            String[] array = str.split(";");
            accountArrayList.add(new Account(array[0], array[1],array[2]));
            /*String username = str.split(";")[0];
            String password = str.split(";")[1];
            String message = str.split(";")[2];
            accountArrayList.add(new Account(username, password, message));*/
        }
        return accountArrayList;
    }
}
