package com.facebook.search.results.util;

/* compiled from: PICKER_CLOSE */
public class SearchResultsFormatUtil {
    public static String m28568a(long j) {
        long j2 = j / 60;
        long j3 = j % 60;
        long j4 = j2 / 60;
        j2 %= 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (j4 > 0) {
            stringBuilder.append(j4).append(':');
            if (j2 <= 9) {
                stringBuilder.append('0');
            }
        }
        stringBuilder.append(j2).append(':');
        if (j3 <= 9) {
            stringBuilder.append('0');
        }
        stringBuilder.append(j3);
        return stringBuilder.toString();
    }
}
