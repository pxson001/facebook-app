package com.facebook.vault.hash;

import android.util.Pair;

/* compiled from: thumbnailResolution */
public class VaultHashUtil {
    public static boolean m1739a(String str) {
        if (str != null) {
            String[] split = str.split("/");
            if (split.length == 2) {
                try {
                    Long.parseLong(split[1]);
                    return true;
                } catch (NumberFormatException e) {
                }
            }
        }
        return false;
    }

    public static Pair<String, Long> m1740b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Hash was null");
        }
        String[] split = str.split("/");
        if (split.length == 2) {
            return new Pair(split[0], Long.valueOf(Long.parseLong(split[1])));
        }
        throw new IllegalArgumentException("invalid image hash: " + str);
    }
}
