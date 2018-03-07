package com.facebook.fbtrace.utils;

import java.util.Random;

/* compiled from: zero_rating2/clearable/carrier_id */
public class FbTraceId {
    public static final Random f494a = new Random();

    public static String m1023a(long j) {
        return m1024a(j, 11);
    }

    public static String m1022a() {
        long abs;
        do {
            abs = Math.abs(f494a.nextLong());
        } while (abs <= 0);
        return m1023a(abs);
    }

    private static String m1024a(long j, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n must be positive");
        } else if (j < 0) {
            throw new IllegalArgumentException("Cannot internalEncode negative integer " + j);
        } else if (j > (1 << Math.min(63, i * 6)) - 1) {
            throw new IllegalArgumentException("Cannot internalEncode integer " + j + " in " + i + " chars");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((int) (j % 64)));
                j >>= 6;
            }
            if (j > 0) {
                throw new IllegalArgumentException("Number won't fit in string");
            }
            stringBuilder.reverse();
            return stringBuilder.toString();
        }
    }

    public static long[] m1025a(String str) {
        if (str == null || str.length() != 22) {
            throw new IllegalArgumentException("Invalid Metadata");
        }
        return new long[]{m1026b(str.substring(0, 11)), m1026b(str.substring(11, 22))};
    }

    private static long m1026b(String str) {
        long j = 0;
        for (int i = 0; i < str.length(); i++) {
            j <<= 6;
            int indexOf = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(str.charAt(i));
            if (indexOf < 0) {
                throw new IllegalArgumentException("Invalid encoded integer " + str);
            }
            j += (long) indexOf;
        }
        return j;
    }
}
