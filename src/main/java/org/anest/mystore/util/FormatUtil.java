package org.anest.mystore.util;

public class FormatUtil {

    public static String leftPad(String value, int length, String pad) {
        int l = length - value.length();

        StringBuilder valueBuilder = new StringBuilder(value);
        while (l > 0) {
            valueBuilder.insert(0, pad);
            --l;
        }
        value = valueBuilder.toString();
        return value;
    }
}
