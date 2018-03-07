package com.facebook.appupdate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;

/* compiled from: friend */
class AppUpdatePersistence$DbHelper extends SQLiteOpenHelper {
    public AppUpdatePersistence$DbHelper(Context context) {
        super(context, "app_updates_db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1317761821);
        sQLiteDatabase.execSQL("CREATE TABLE app_updates (id INTEGER PRIMARY KEY, data BLOB)");
        SQLiteDetour.a(1731568622);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SQLiteDetour.a(641357095);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_updates");
        SQLiteDetour.a(1388365889);
        onCreate(sQLiteDatabase);
    }
}
