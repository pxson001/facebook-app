package com.facebook.messengerwear.shared;

import android.net.Uri;

/* compiled from: photo_suggestions */
public class MessengerWearConstants {

    /* compiled from: photo_suggestions */
    public enum AssetType {
        STICKER,
        IMAGE
    }

    /* compiled from: photo_suggestions */
    public class WearDataApiPath {
        public static String m4496a(String str) {
            return "/threads/" + str;
        }

        public static String m4498c(String str) {
            return m4497a(str, "/threads/");
        }

        public static String m4499d(String str) {
            return "/stickers/" + str;
        }

        public static Uri m4500e(String str) {
            return Uri.parse("wear:" + m4499d(str));
        }

        public static String m4495a() {
            return "/mru_stickers";
        }

        public static String m4501f(String str) {
            return "/images/" + str;
        }

        public static Uri m4502g(String str) {
            return Uri.parse("wear:" + m4501f(str));
        }

        private static String m4497a(String str, String str2) {
            try {
                if (str.startsWith(str2)) {
                    return str.substring(str2.length());
                }
                throw new IllegalArgumentException();
            } catch (Exception e) {
                throw new IllegalArgumentException("Malformed uri, expected [" + str2 + "]");
            }
        }
    }
}
