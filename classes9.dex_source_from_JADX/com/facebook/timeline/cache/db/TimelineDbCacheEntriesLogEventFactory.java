package com.facebook.timeline.cache.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.androidcompat.AndroidCompat;
import java.io.File;

/* compiled from: url  */
public class TimelineDbCacheEntriesLogEventFactory {
    public static HoneyClientEvent m864a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.b(str2, m865a(sQLiteDatabase, str3, strArr));
        String path = sQLiteDatabase.getPath();
        if (path != null) {
            honeyClientEvent.a("db_size", new File(path).length());
        }
        return honeyClientEvent;
    }

    private static String m865a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        Throwable th;
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        Throwable th2 = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int columnIndexOrThrow = rawQuery.getColumnIndexOrThrow("COUNT(*)");
            int columnIndexOrThrow2 = rawQuery.getColumnIndexOrThrow(TimelineDbCacheQueryFormatter.f820a);
            int columnIndexOrThrow3 = rawQuery.getColumnIndexOrThrow("average_age");
            if (rawQuery.moveToFirst()) {
                while (!rawQuery.isAfterLast()) {
                    long j = rawQuery.getLong(columnIndexOrThrow);
                    long j2 = rawQuery.getLong(columnIndexOrThrow2);
                    stringBuilder.append("TimelineHeaderCommonFields : ").append(j).append(" : ").append(j2).append(" : ").append(rawQuery.getLong(columnIndexOrThrow3)).append("\n");
                    rawQuery.moveToNext();
                }
            }
            String stringBuilder2 = stringBuilder.toString();
            if (rawQuery != null) {
                rawQuery.close();
            }
            return stringBuilder2;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (rawQuery != null) {
            if (th22 != null) {
                try {
                    rawQuery.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                rawQuery.close();
            }
        }
        throw th;
        throw th;
    }
}
