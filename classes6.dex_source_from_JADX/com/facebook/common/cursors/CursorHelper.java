package com.facebook.common.cursors;

import android.database.Cursor;

/* compiled from: place_picker_session_id */
public class CursorHelper {
    public static int m11024a(Cursor cursor, String str) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(str));
    }

    public static long m11025b(Cursor cursor, String str) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(str));
    }

    public static String m11026c(Cursor cursor, String str) {
        return cursor.getString(cursor.getColumnIndexOrThrow(str));
    }
}
