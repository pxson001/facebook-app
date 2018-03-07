package com.facebook.common.util;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images.Media;
import javax.annotation.Nullable;

/* compiled from: networkType */
public class UriUtil {
    public static final String f12743a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();

    public static boolean m18788a(@Nullable Uri uri) {
        String i = m18794i(uri);
        return "https".equals(i) || "http".equals(i);
    }

    public static boolean m18789b(@Nullable Uri uri) {
        return "file".equals(m18794i(uri));
    }

    public static boolean m18790c(@Nullable Uri uri) {
        return "content".equals(m18794i(uri));
    }

    public static boolean m18791e(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean m18792f(@Nullable Uri uri) {
        return "asset".equals(m18794i(uri));
    }

    public static boolean m18793g(@Nullable Uri uri) {
        return "res".equals(m18794i(uri));
    }

    @Nullable
    public static String m18794i(@Nullable Uri uri) {
        return uri == null ? null : uri.getScheme();
    }

    public static Uri m18787a(@Nullable String str) {
        return str != null ? Uri.parse(str) : null;
    }
}
