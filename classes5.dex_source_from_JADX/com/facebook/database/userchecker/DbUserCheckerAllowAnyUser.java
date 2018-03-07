package com.facebook.database.userchecker;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.inject.InjectorLike;

/* compiled from: search_results_tabs */
public class DbUserCheckerAllowAnyUser implements DbUserChecker {
    public static DbUserCheckerAllowAnyUser m4024a(InjectorLike injectorLike) {
        return new DbUserCheckerAllowAnyUser();
    }

    public final boolean m4025a(SQLiteDatabase sQLiteDatabase) {
        return true;
    }

    public final void m4026b(SQLiteDatabase sQLiteDatabase) {
    }
}
