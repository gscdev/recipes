package com.gsc.recipes.utils;

import static android.text.TextUtils.isEmpty;


public class StringUtils {

    public static String getString(String value) {
        return getStringOrDefault(value, "");
    }

    public static String getStringOrDefault(String value, String defaultValue) {
        return isEmpty(value) ? defaultValue : value;
    }
}
