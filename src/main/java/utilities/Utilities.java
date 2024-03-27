package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utilities {
    public static String getCurrentDate(String dateTimeFormat) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
        String currentDateTime = dateFormat.format(currentDate);
        return currentDateTime;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean genRandomBoolean() {
        return (new Random()).nextBoolean();
    }
}
