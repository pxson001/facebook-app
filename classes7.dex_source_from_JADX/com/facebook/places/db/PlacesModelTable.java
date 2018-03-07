package com.facebook.places.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.inject.Inject;

/* compiled from: in_sync_with_change_since_last_upload */
public class PlacesModelTable {
    public static String f11139a = "CREATE TABLE places_model (  _id INTEGER PRIMARY KEY,   content TEXT);";
    private Context f11140b;

    @Inject
    public PlacesModelTable(Context context) {
        this.f11140b = context;
    }

    public final void m13074a(int i, String str) {
        PlacesDbHelper placesDbHelper = new PlacesDbHelper(this.f11140b);
        SQLiteDatabase writableDatabase = placesDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        contentValues.put("content", str);
        try {
            SQLiteDetour.a(-1233573222);
            writableDatabase.insertWithOnConflict("places_model", null, contentValues, 5);
            SQLiteDetour.a(-911960241);
        } finally {
            placesDbHelper.close();
        }
    }

    public final String m13073a(int i) {
        Cursor query;
        Throwable th;
        String str = null;
        PlacesDbHelper placesDbHelper = new PlacesDbHelper(this.f11140b);
        try {
            query = placesDbHelper.getWritableDatabase().query("places_model", new String[]{"content"}, " _id = ?", new String[]{Integer.toString(i)}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                }
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                placesDbHelper.close();
                return str;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                placesDbHelper.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            placesDbHelper.close();
            throw th;
        }
    }
}
