package com.facebook.crudolib.db;

import android.database.Cursor;

/* compiled from: TreehouseTTMallNextStories */
public class DbHelper {
    public static long m25928a(Cursor cursor, long j) {
        try {
            int columnCount = cursor.getColumnCount();
            if (columnCount > 1) {
                throw new IllegalArgumentException("Expected 1 column, got " + columnCount);
            }
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
            } else {
                cursor.close();
            }
            return j;
        } finally {
            cursor.close();
        }
    }
}
