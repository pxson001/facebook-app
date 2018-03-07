package com.facebook.react.modules.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: frma */
class AsyncLocalStorageUtil {
    AsyncLocalStorageUtil() {
    }

    static String m13745a(int i) {
        String[] strArr = new String[i];
        Arrays.fill(strArr, "?");
        return "key IN (" + TextUtils.join(", ", strArr) + ")";
    }

    static String[] m13749a(ReadableArray readableArray, int i, int i2) {
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = readableArray.getString(i + i3);
        }
        return strArr;
    }

    @Nullable
    private static String m13746a(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = null;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("catalystLocalStorage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
        try {
            if (query.moveToFirst()) {
                str2 = query.getString(0);
                query.close();
            }
            return str2;
        } finally {
            query.close();
        }
    }

    private static boolean m13750b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", str2);
        SQLiteDetour.a(641353822);
        long insertWithOnConflict = sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", null, contentValues, 5);
        SQLiteDetour.a(1909992813);
        return -1 != insertWithOnConflict;
    }

    static boolean m13748a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String a = m13746a(sQLiteDatabase, str);
        if (a != null) {
            JSONObject jSONObject = new JSONObject(a);
            m13747a(jSONObject, new JSONObject(str2));
            str2 = jSONObject.toString();
        }
        return m13750b(sQLiteDatabase, str, str2);
    }

    private static void m13747a(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject = jSONObject2.optJSONObject(str);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(str);
            if (optJSONObject == null || optJSONObject2 == null) {
                jSONObject.put(str, jSONObject2.get(str));
            } else {
                m13747a(optJSONObject2, optJSONObject);
                jSONObject.put(str, optJSONObject2);
            }
        }
    }
}
