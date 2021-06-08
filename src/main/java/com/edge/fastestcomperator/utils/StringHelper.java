package com.edge.fastestcomperator.utils;

import java.util.regex.Pattern;

public class StringHelper {
    private StringHelper() {
    }

    public static boolean isInteger(final String s) {
        final Pattern pattern = Pattern.compile("^-?[0-9]{1,10}$");
        if (s == null) return false;
        if (s.isEmpty()) return false;
        if (s.length() > 11) return false;
        return pattern.matcher(s).matches();
    }
}
