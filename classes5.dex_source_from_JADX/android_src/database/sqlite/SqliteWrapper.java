package android_src.database.sqlite;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.facebook.debug.log.BLog;

/* compiled from: best_description */
public final class SqliteWrapper {
    private SqliteWrapper() {
    }

    private static void m14117a(SQLiteException sQLiteException) {
        throw sQLiteException;
    }

    public static Cursor m14115a(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (Throwable e) {
            BLog.b("SqliteWrapper", "Catch a SQLiteException when query: ", e);
            m14117a(e);
            return null;
        }
    }

    public static int m14113a(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (Throwable e) {
            BLog.b("SqliteWrapper", "Catch a SQLiteException when update: ", e);
            m14117a(e);
            return -1;
        }
    }

    public static int m14114a(Context context, ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        try {
            return contentResolver.delete(uri, str, strArr);
        } catch (Throwable e) {
            BLog.b("SqliteWrapper", "Catch a SQLiteException when delete: ", e);
            m14117a(e);
            return -1;
        }
    }

    public static Uri m14116a(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (Throwable e) {
            BLog.b("SqliteWrapper", "Catch a SQLiteException when insert: ", e);
            m14117a(e);
            return null;
        }
    }
}
