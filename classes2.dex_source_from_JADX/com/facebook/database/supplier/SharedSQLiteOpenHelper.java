package com.facebook.database.supplier;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.List;

@SuppressLint({"BadSuperClassSQLiteOpenHelper.SharedSQLiteOpenHelper"})
/* compiled from: unsubscribed */
public class SharedSQLiteOpenHelper extends SQLiteOpenHelper {
    private final SharedSQLiteDbHelper f1859a;

    public SharedSQLiteOpenHelper(Context context, String str, List<? extends SharedSQLiteSchemaPart> list, int i, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, null, 200, databaseErrorHandler);
        this.f1859a = new SharedSQLiteDbHelper(list, i, context);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SharedSQLiteDbHelper sharedSQLiteDbHelper = this.f1859a;
        if (i < 200) {
            SQLiteDetour.a(2037050678);
            sQLiteDatabase.execSQL("CREATE TABLE _shared_version (name TEXT PRIMARY KEY, version INTEGER)");
            SQLiteDetour.a(1173999346);
            int size = sharedSQLiteDbHelper.f1863c.size();
            for (int i3 = 0; i3 < size; i3++) {
                SharedSQLiteDbHelper.m3760a(sQLiteDatabase, ((SharedSQLiteSchemaPart) sharedSQLiteDbHelper.f1863c.get(i3)).f1011a, i);
            }
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.f1859a.m3770b(sQLiteDatabase);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1959790794);
        sQLiteDatabase.execSQL("CREATE TABLE _shared_version (name TEXT PRIMARY KEY, version INTEGER)");
        SQLiteDetour.a(-1724107687);
    }
}
