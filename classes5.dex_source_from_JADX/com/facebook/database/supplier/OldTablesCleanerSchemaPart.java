package com.facebook.database.supplier;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;

/* compiled from: search_score */
public class OldTablesCleanerSchemaPart extends SharedSQLiteSchemaPart {
    private final ImmutableList<String> f2885a;

    public OldTablesCleanerSchemaPart(int i, ImmutableList<String> immutableList) {
        super("_old_tables_cleaner", i);
        this.f2885a = immutableList;
    }

    private void m4020d(SQLiteDatabase sQLiteDatabase) {
        int size = this.f2885a.size();
        for (int i = 0; i < size; i++) {
            String str = "DROP TABLE IF EXISTS " + ((String) this.f2885a.get(i));
            SQLiteDetour.a(-656488570);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1332507866);
        }
    }

    protected final void m4021a(SQLiteDatabase sQLiteDatabase) {
        m4020d(sQLiteDatabase);
    }

    protected final void m4022a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m4020d(sQLiteDatabase);
    }

    public final void m4023b(SQLiteDatabase sQLiteDatabase) {
    }
}
