package com.facebook.ads.internal.util;

import java.security.MessageDigest;

public class C1994r {
    public static boolean m14486a(String str) {
        return str == null || str.length() <= 0;
    }

    public static String m14487b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
