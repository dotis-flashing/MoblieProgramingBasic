package com.example.myapplication.projectlab.Lab10.Exe1;

public class ValidationUtils {
    public static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
