package com.facebook.prefs.shared;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.VisibleForTesting;
import java.util.Map;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: viewer_watch_status */
public class FbSharedPreferencesContract {

    /* compiled from: viewer_watch_status */
    public final class PreferencesTable {
        public static final String[] f2182a = new String[]{Columns.f1019a.f1025d, Columns.f1021c.f1025d, Columns.f1020b.f1025d};

        /* compiled from: viewer_watch_status */
        public final class Columns {
            public static final SqlColumn f1019a = new SqlColumn("key", "TEXT PRIMARY KEY");
            public static final SqlColumn f1020b = new SqlColumn("value", "TEXT");
            public static final SqlColumn f1021c = new SqlColumn("type", "INTEGER");
        }
    }

    public static void m4331a(@Nullable Cursor cursor, Map<PrefKey, Object> map) {
        if (cursor != null) {
            int a = Columns.f1019a.m2089a(cursor);
            int a2 = Columns.f1021c.m2089a(cursor);
            int a3 = Columns.f1020b.m2089a(cursor);
            while (cursor.moveToNext()) {
                String string = cursor.getString(a);
                if (string != null) {
                    int i = cursor.getInt(a2);
                    PrefKey prefKey = new PrefKey(string);
                    switch (i) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            map.put(prefKey, cursor.getString(a3));
                            break;
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            map.put(prefKey, Boolean.valueOf(cursor.getInt(a3) != 0));
                            break;
                        case 3:
                            map.put(prefKey, Integer.valueOf(cursor.getInt(a3)));
                            break;
                        case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                            map.put(prefKey, Long.valueOf(cursor.getLong(a3)));
                            break;
                        case 5:
                            map.put(prefKey, Float.valueOf(cursor.getFloat(a3)));
                            break;
                        case 6:
                            map.put(prefKey, Double.valueOf(cursor.getDouble(a3)));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public static void m4330a(ContentValues contentValues, PrefKey prefKey, Object obj) {
        int i = 1;
        String a = prefKey.m2012a();
        if (a != null) {
            contentValues.put("key", a);
            if (obj instanceof String) {
                contentValues.put("type", Integer.valueOf(1));
                contentValues.put("value", (String) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put("type", Integer.valueOf(2));
                a = "value";
                if (!((Boolean) obj).booleanValue()) {
                    i = 0;
                }
                contentValues.put(a, Integer.valueOf(i));
            } else if (obj instanceof Integer) {
                contentValues.put("type", Integer.valueOf(3));
                contentValues.put("value", (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put("type", Integer.valueOf(4));
                contentValues.put("value", (Long) obj);
            } else if (obj instanceof Float) {
                contentValues.put("type", Integer.valueOf(5));
                contentValues.put("value", (Float) obj);
            } else if (obj instanceof Double) {
                contentValues.put("type", Integer.valueOf(6));
                contentValues.put("value", (Double) obj);
            }
        }
    }
}
