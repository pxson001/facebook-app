package com.facebook.graphql.executor.cache;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.graphql.executor.cache.GraphQLDBContract.QueriesTable.Columns;
import java.io.File;

/* compiled from: legacy_api_id */
public class DiskCacheEntriesLogEventFactory {
    public static HoneyClientEvent m6300a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.b(str2, m6301a(sQLiteDatabase, str3, strArr));
        String path = sQLiteDatabase.getPath();
        if (path != null) {
            honeyClientEvent.a("db_size", new File(path).length());
        }
        return honeyClientEvent;
    }

    private static String m6301a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        Throwable th;
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        Throwable th2 = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int columnIndexOrThrow = rawQuery.getColumnIndexOrThrow(Columns.g.a());
            int columnIndexOrThrow2 = rawQuery.getColumnIndexOrThrow("row_count");
            int columnIndexOrThrow3 = rawQuery.getColumnIndexOrThrow("total_length");
            int columnIndexOrThrow4 = rawQuery.getColumnIndexOrThrow("average_age");
            if (rawQuery.moveToFirst()) {
                while (!rawQuery.isAfterLast()) {
                    String string = rawQuery.getString(columnIndexOrThrow);
                    long j = rawQuery.getLong(columnIndexOrThrow2);
                    long j2 = rawQuery.getLong(columnIndexOrThrow3);
                    stringBuilder.append(string).append(" : ").append(j).append(" : ").append(j2).append(" : ").append(rawQuery.getLong(columnIndexOrThrow4)).append("\n");
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
