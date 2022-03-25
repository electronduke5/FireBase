package com.example.firebase2;

import android.service.autofill.FieldClassification;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static boolean checkEmailForValidity(String email){
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        return matcher.find();
    }
    public static boolean checkPasswordForValidity(String password){
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public static boolean checkPasswordForEquals(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    public static boolean checkPhoneNumberForValidity(String phoneNumber){
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber);
        return matcher.find();
    }

    private static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
                    Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PHONE_NUMBER_REGEX =
            Pattern.compile("^(\\+[7]\\([0-9]{3}\\)[0-9]{3}\\-[0-9]{2}\\-[0-9]{2})$",
                    Pattern.CASE_INSENSITIVE);
}
