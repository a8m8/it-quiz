package net.itquiz.utils;

import java.util.regex.Pattern;

/**
 * @author Artur Meshcheriakov
 */
public class EmailValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public static boolean isValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

}