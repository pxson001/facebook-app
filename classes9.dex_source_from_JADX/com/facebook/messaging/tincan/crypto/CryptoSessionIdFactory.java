package com.facebook.messaging.tincan.crypto;

/* compiled from: com.facebook.AccessToken */
public class CryptoSessionIdFactory {
    public static String m17860a(long j) {
        return m17861a(j, null);
    }

    public static String m17861a(long j, String str) {
        if (str == null || str.isEmpty()) {
            return Long.toString(j);
        }
        return Long.toString(j) + "_" + str;
    }
}
