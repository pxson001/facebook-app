package com.facebook.common.time;

/* compiled from: install_location */
public class TimeUtil {
    private static final long[] f10309a = new long[]{86400000, 3600000, 60000, 1000};
    private static final String[] f10310b = new String[]{"d", "h", "m", "s", "ms"};

    public static long m10808a(int i) {
        return ((long) i) * 60000;
    }

    public static String m10810a(long j, long j2) {
        if (j == j2) {
            return "now";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m10809a(Math.abs(j - j2))).append(' ').append(j > j2 ? "later" : "ago");
        return stringBuilder.toString();
    }

    public static String m10809a(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = f10309a.length;
        int i = 0;
        long j2 = j;
        while (i < length) {
            long j3 = j2 / f10309a[i];
            if (j3 > 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(j3).append(f10310b[i]);
                j2 %= f10309a[i];
            }
            i++;
        }
        if (stringBuilder.length() <= 0) {
            stringBuilder.append(j2).append(f10310b[i]);
        } else if (j2 > 0) {
            stringBuilder.append(' ').append(j2).append(f10310b[i]);
        }
        return stringBuilder.toString();
    }
}
