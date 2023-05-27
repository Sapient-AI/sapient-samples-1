package demo.mockito;

import java.util.regex.Pattern;

public class Validator {

    private static String USER_ID_PATTERN = "[A-z]+[0-9]*";

    public static boolean validateUserId(String userId) {
        if (userId==null || !Pattern.matches(USER_ID_PATTERN, userId)){
            throw new IllegalArgumentException("UserId must contain alphanumeric characters only");
        }
        return true;
    }
}
