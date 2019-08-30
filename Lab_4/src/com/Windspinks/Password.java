package com.Windspinks;

public class Password {
    private String pass;

    public Password() {
    }

    public Password(String pass) {
        this.pass = pass;
    }

    public boolean isValid() {
        if (pass.length() < 6) {
            return false;
        }
        boolean containsUpper = false;
        boolean containsLower = false;
        boolean containsDigit = false;

        for (Character c : pass.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                containsLower = true;
            if (c >= 'A' && c <= 'Z')
                containsUpper = true;
            if (c >= '0' && c <= '9')
                containsDigit = true;
        }

        return containsUpper && containsLower && containsDigit;
    }
}
